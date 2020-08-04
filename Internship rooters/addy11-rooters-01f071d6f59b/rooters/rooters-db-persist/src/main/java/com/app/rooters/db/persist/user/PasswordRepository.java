package com.app.rooters.db.persist.user;

import com.app.rooters.db.model.user.Password;
import com.app.rooters.db.model.user.User;
import com.app.rooters.db.persist.base.QuerydslJpaRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * PasswordRepository for accessing user password.
 */
public interface PasswordRepository extends QuerydslJpaRepository<Password, UUID> {

    List<Password> findByUserOrderByCreatedDesc(User user);

    default Password findCurrentPassword(User user) {
        return findByUserOrderByCreatedDesc(user).stream()
                .filter(password -> !password.expired()).findFirst().orElse(null);
    }

    default List<Password> findLatestPasswords(User user, int last) {
        return findByUserOrderByCreatedDesc(user).stream().limit(last).collect(Collectors.toList());
    }
}
