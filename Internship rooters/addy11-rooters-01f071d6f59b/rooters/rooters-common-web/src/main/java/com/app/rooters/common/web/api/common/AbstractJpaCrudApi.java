package com.app.rooters.common.web.api.common;

import com.app.rooters.common.web.api.ApiResponse;
import com.app.rooters.common.web.api.ErrorResponse;
import com.app.rooters.common.web.api.common.model.IdNameListModel;
import com.app.rooters.db.persist.base.QuerydslJpaRepository;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.ExpressionUtils;

import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractJpaCrudApi<E extends BaseModel, L extends IdNameListModel, T>
        extends AbstractApi<E, L, T> {

    @Value("${rooters.max-entity-page-size:1000}")
    private int maxPageSize = 1000;

    protected abstract QuerydslJpaRepository<T, UUID> repository();


    protected T getById(UUID id) {
        return repository().findById(id).orElse(null);
    }

    private L newListModel(T entity) {

        try {
            return listModelType.constructor(listModelType.getRawType().getConstructor(entityType.getRawType()))
                    .invoke(null, entity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * Search method.  Simple implementations will just call super.search().
     */
    public abstract ResponseEntity search(Pageable pageable,
                                          Predicate predicate, String search);


    protected <T, R> Page<T> searchPage(Pageable pageable, Predicate predicate,
                                        Set<Predicate> extraPredicates, String search,
                                        Set<StringExpression> searchFields,
                                        @NonNull QuerydslJpaRepository<R, UUID> repository,
                                        @NonNull Function<R, T> mapper) {

        if (pageable.getPageSize() > maxPageSize) {
            throw new RuntimeException("Requested page size " + pageable.getPageSize() + " > " + maxPageSize);
        }

        Predicate searchPredicate = null;
        if (StringUtils.isNotBlank(search) && !searchFields.isEmpty()) {
            searchPredicate = ExpressionUtils.anyOf(
                    searchFields.stream().map(path -> path.like("%" + search + "%")).collect(Collectors.toList()));
        }

        Predicate finalPredicate = ExpressionUtils.allOf(predicate, searchPredicate, ExpressionUtils.allOf(extraPredicates));
        Page<T> page = (finalPredicate != null
                ? repository.findAll(finalPredicate, pageable) : repository.findAll(pageable)).map(mapper::apply);
        return page;
    }

    protected <T, R> ResponseEntity search(Pageable pageable, Predicate predicate,
                                           Set<Predicate> extraPredicates, String search,
                                           Set<StringExpression> searchFields,
                                           @NonNull QuerydslJpaRepository<R, UUID> repository,
                                           @NonNull Function<R, T> mapper) {
        try {
            Page<T> result = searchPage(pageable, predicate, extraPredicates, search, searchFields, repository, mapper);
            return ApiResponse.ok(result);
        } catch (RuntimeException e) {
            return ApiResponse.badRequest(e.getMessage());
        }
    }

    /**
     * Standard search.
     */
    protected ResponseEntity search(Pageable pageable, Predicate predicate, Set<Predicate> extraPredicates,
                                    String search, Set<StringExpression> searchFields) {

        return search(pageable, predicate, extraPredicates, search, searchFields, repository(), this::newListModel);
    }

    /**
     * Standard search.
     */
    protected ResponseEntity search(Pageable pageable, Predicate predicate, Set<Predicate> extraPredicates,
                                    String search, Set<StringExpression> searchFields, Function<T, L> supply) {
        return search(pageable, predicate, extraPredicates, search, searchFields, repository(), supply);
    }

    /**
     * Given a query, returns false if an entity is found and adds the given message to result.
     *
     * @param query   predicates
     * @param field   field name for validation message if not unique
     * @param message validation message
     * @param error   error messages container
     * @param entity  current entity.  If found entity is the same, it will be ignored.
     * @return true if not entity is found, false otherwise.
     */
    protected boolean validateUnique(T entity, Predicate query, String field, String message,
                                     ErrorResponse error) {

        Iterable<T> results = repository().findAll(query);
        for (T candidate : results) {
            if (!candidate.equals(entity)) {
                error.addFieldError(field, message);
                return false;
            }
        }
        return true;
    }

}