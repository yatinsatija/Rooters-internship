package com.app.rooters.db.persist.user;

import com.app.rooters.db.model.user.User;
import com.app.rooters.db.persist.base.QuerydslJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

/**
 * User JPA repository.
 */
public interface UserRepository extends QuerydslJpaRepository<User, UUID> {

    //This may return deleted users also.
    @Query("select a from User a where a.email is not NULL and a.email = email")
    User findByEmail(@Param("email") String email);

    @Query("select a from User a where a.email is not NULL and a.email = email and a.deleted = false")
    User findExistingUserByEmail(@Param("email") String email);

    @Query(value = "SELECT distinct a from User a where a.deleted = true")
    List<User> findAllDeletedUser();
}
