package com.app.rooters.common.web.api.common;

import com.app.rooters.common.web.api.ApiResponse;
import com.app.rooters.common.web.api.ErrorResponse;
import com.app.rooters.common.web.api.common.model.IdNameListModel;
import com.app.rooters.db.model.misc.audit.IAuditedEntity;
import com.google.common.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.nio.file.AccessDeniedException;
import java.util.UUID;
import java.util.function.Function;

public abstract class AbstractApi<E extends BaseModel, L extends IdNameListModel, T> {

    public static final String NEW_ID = "new";

    private final TypeToken<E> editModelType = new TypeToken<E>(getClass()) {
    };

    final TypeToken<L> listModelType = new TypeToken<L>(getClass()) {
    };

    final TypeToken<T> entityType = new TypeToken<T>(getClass()) {
    };

    /**
     * Load method.  Simple implementations should just call super.loadModel().
     */
    public abstract ResponseEntity get(UUID id);

    /**
     * Save or update method.  If id is not present, it is assumed to be a new entity.
     */
    public abstract ResponseEntity saveOrUpdate(E editModel);

    /**
     * Delete/destroy method.  Some services may not support delete and should return badRequest in that case.
     *
     * @return success() or fail(cause).
     */
    public abstract ResponseEntity delete(E editModel);

    /**
     * Load existing entity by ID.
     */
    protected abstract T getById(UUID id);

    /**
     * Load given entity or if id == 'new', create new empty model (with defaults).
     *
     * <p>If entityAccessCheck is provided it will be invoked for existing entities and if it returns false, an
     * AccessDeniedException will be thrown.</p>
     */
    public ResponseEntity get(UUID id, java.util.function.Predicate<T> entityAccessCheck, Function<T,E> supply)
            throws AccessDeniedException {

        if (id == null) {
            return ApiResponse.ok(newEditModel());
        }

        T entity = getById(id);

        if (null == entity) {
            return ApiResponse.notFound();
        }

        if (null != entityAccessCheck && !entityAccessCheck.test(entity)) {
            throw new AccessDeniedException("Access Denied to " + entityType.getRawType().getSimpleName() + "[" + id + "]");
        }

        return ApiResponse.ok( supply.apply(entity));
    }



    /**
     * Load given entity or if id == 'new', create new empty model (with defaults).
     *
     * <p>If entityAccessCheck is provided it will be invoked for existing entities and if it returns false, an
     * AccessDeniedException will be thrown.</p>
     */
    public ResponseEntity get(UUID id, java.util.function.Predicate<T> entityAccessCheck) throws AccessDeniedException {

        if (id == null) {
            return ApiResponse.ok(newEditModel());
        }

        T entity = getById(id);

        if (null == entity) {
            return ApiResponse.notFound();
        }

        if (null != entityAccessCheck && !entityAccessCheck.test(entity)) {
            throw new AccessDeniedException("Access Denied to " + entityType.getRawType().getSimpleName() + "[" + id + "]");
        }

        return ApiResponse.ok(newEditModel(entity));
    }

    protected E newEditModel() {
        try {
            return newEditModel((T) entityType.getRawType().newInstance());
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw (RuntimeException) e;
            }
            throw new RuntimeException(e);
        }
    }

    protected E newEditModel(T entity) {

        try {
            E model = editModelType.constructor(editModelType.getRawType().getConstructor(entityType.getRawType()))
                    .invoke(null, entity);

            if (model instanceof AuditedEntityModel && entity instanceof IAuditedEntity) {
                ((AuditedEntityModel) model).createdBy(((IAuditedEntity) entity).createdBy());
                ((AuditedEntityModel) model).modifiedBy(((IAuditedEntity) entity).modifiedBy());
            }

            return model;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Finds or creates a new entity for the given entity ID.  If id == 'new' a new entity is created.  Returns null
     * if an ID is provided, but, not found.
     */
    protected T findOrCreateEntity(String id) {

        if (NEW_ID.equals(id)) {
            try {
                return (T) entityType.getRawType().newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            return getById(UUID.fromString(id));
        }

    }

    //@Nullable
    protected T findEntity(UUID id) {
        return getById(id);
    }

    protected T findEntity(E editModel) {
        String id = editModel.id().toString();
        if (id.equals(NEW_ID)) {
            return null;
        }
        return findOrCreateEntity(id);
    }

    /**
     * Helper to find a related entity.
     *
     * @param relatedEntityId id for related entity
     * @param entityName      Short entity name (ex: User, Domain).  Is used to generate validation messages.
     * @param field           field name for validation messages.
     * @param repository      jpa repository to load entity from.
     * @param error           validation messages container
     * @param <T>             Entity type
     * @return the entity, or null if not found.  If not found, not found message will be added to result.
     */
    protected <T> T findRelatedJpaEntity(UUID relatedEntityId,
                                         String entityName,
                                         String field,
                                         JpaRepository<T, UUID> repository,
                                         ErrorResponse error,
                                         boolean nullable) {
        if (nullable && null == relatedEntityId) {
            return null;
        }

        T entity = null;
        try {
            entity = repository.findById(relatedEntityId).orElse(null);
            if (null == entity) {
                error.addFieldError(field, entityName + " not found");
            }
        } catch (Exception e) {
            error.addFieldError(field, "Invalid ID for " + entityName);
        }
        return entity;
    }

    /**
     * Id validation when creating or updating an entity.
     * Checks that the id in the path variable and the id in the request body are equal.
     */
    protected boolean validateIds(String pathId, E model, ErrorResponse errors) {
        boolean isValid;

        if (model.isNew()) {
            isValid = NEW_ID.equals(pathId);
        } else {
            isValid = UUID.fromString(pathId).equals(model.id());
        }

        if (!isValid) {
            errors.addFieldError("id", "Error: id in path does not match id in body");
        }

        return isValid;
    }

    /**
     * Validate the given value is a valid enum name.  If it is, the enum is returned.  If not the given message is added to the
     * result unless nullable is true (for non-required fields).
     *
     * @param enumName  String value of this enum constant
     * @param enumClass class instant of this Enum
     * @param field     field name of enum property in the edit model, used for error msg
     * @param errors    validation result
     * @param nullable  whether or not this field is nullable in the entity.
     */
    protected <E extends Enum<E>> E toEnumFromEnumName(String enumName, Class<E> enumClass, String field, String message,
                                                       ErrorResponse errors, boolean nullable) {

        if (nullable && null == enumName || (enumName != null && StringUtils.isBlank(enumName))) {
            return null;
        } else {
            try {
                return Enum.valueOf(enumClass, enumName);
            } catch (Exception e) {
                errors.addFieldError(field, message);
                return null;
            }
        }
    }

}

