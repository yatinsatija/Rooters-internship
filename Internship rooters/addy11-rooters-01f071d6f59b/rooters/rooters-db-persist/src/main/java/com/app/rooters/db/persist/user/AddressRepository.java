package com.app.rooters.db.persist.user;

import com.app.rooters.db.model.user.Address;
import com.app.rooters.db.model.user.User;
import com.app.rooters.db.persist.base.QuerydslJpaRepository;

import java.util.List;
import java.util.UUID;

public interface AddressRepository extends QuerydslJpaRepository<Address, UUID> {

    List<Address> findByUser(User user);

}
