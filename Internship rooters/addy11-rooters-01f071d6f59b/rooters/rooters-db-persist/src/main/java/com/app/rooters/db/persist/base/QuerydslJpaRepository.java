package com.app.rooters.db.persist.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.lang.Nullable;

import java.io.Serializable;

@NoRepositoryBean
public interface QuerydslJpaRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, QuerydslPredicateExecutor<T> {

    /**
     * A finder that passes the actual return entity or null, instead of and Optional. A midpoint between
     * CrudRepository#findById,
     * which returns an Optional, and JpaRepository#getOne,
     * which returns a reference, but not a full entity.  Over time, enrolledClient
     * code should consider restructuring to using optionals when appropriate.
     *
     * @param id the id of the entity to retrieve
     * @return the entity, or null
     * @see JpaRepository#getOne(Object)
     * @see org.springframework.data.repository.CrudRepository#findById(Object)
     */


    @Nullable
    default T findByIdOrNull(ID id) {
        return findById(id).orElse(null);
    }
}
