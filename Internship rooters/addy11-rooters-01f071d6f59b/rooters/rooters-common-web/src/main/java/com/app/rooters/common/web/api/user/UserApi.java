package com.app.rooters.common.web.api.user;

import com.app.rooters.common.web.api.ApiResponse;
import com.app.rooters.common.web.api.common.AbstractJpaCrudApi;
import com.app.rooters.common.web.api.user.model.UserEditModel;
import com.app.rooters.common.web.api.user.model.UserListModel;
import com.app.rooters.db.model.user.User;
import com.app.rooters.db.persist.base.QuerydslJpaRepository;
import com.app.rooters.db.persist.user.UserRepository;
import com.google.common.collect.ImmutableMap;
import com.querydsl.core.types.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.AccessDeniedException;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserApi extends AbstractJpaCrudApi<UserEditModel, UserListModel, User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    protected QuerydslJpaRepository<User, UUID> repository() {
        return null;
    }

    @Override
    public ResponseEntity search(Pageable pageable, Predicate predicate, String search) {
        return null;
    }

    @Override
    @RequestMapping(value = "/fetch/{id}", method = RequestMethod.GET)
    //@PreAuthorize("hasAnyAuthority('USER','ADMIN','SUPER_ADMIN')")
    public ResponseEntity get(@PathVariable UUID id) {
        try {
            return super.get(id, user -> !user.deleted());
        } catch (AccessDeniedException e) {
            log.error("Unauthorized access to get user", e);
            return ApiResponse.accessDenied();
        }
    }

    @Override
    public ResponseEntity saveOrUpdate(UserEditModel editModel) {
        return null;
    }

    @Override
    public ResponseEntity delete(UserEditModel editModel) {
        return null;
    }

    @PostMapping(value = "/session/check")
    public ResponseEntity isSessionAlive() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null != authentication
                && null != authentication.getPrincipal()
                && authentication instanceof UsernamePasswordAuthenticationToken) {
            return ApiResponse.ok(ImmutableMap.of(
                    "success", Boolean.TRUE));
        } else {
            return ApiResponse.ok(ImmutableMap.of("success", Boolean.FALSE));
        }
    }
}
