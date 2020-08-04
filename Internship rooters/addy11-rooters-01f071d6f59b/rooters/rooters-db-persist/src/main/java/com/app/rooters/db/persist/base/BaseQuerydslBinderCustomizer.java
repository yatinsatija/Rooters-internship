package com.app.rooters.db.persist.base;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Path;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import java.util.Set;

/**
 * Base binding customizer that turns on whitelisting and delegates to getAllowedPaths.  More complex
 * customizations can be done by overriding customize, but, don't forget to excludeUnlistedProperties(true).
 */
public abstract class BaseQuerydslBinderCustomizer<T extends EntityPath<?>> implements QuerydslBinderCustomizer<T> {

    public abstract Set<Path<?>> getAllowedPaths();

    public abstract void bindAliases(QuerydslBindings bindings);

    @Override
    public void customize(QuerydslBindings bindings, T root) {
        bindings.excludeUnlistedProperties(true);
        bindings.including(getAllowedPaths().toArray(new Path[]{}));
        bindAliases(bindings);
    }

}
