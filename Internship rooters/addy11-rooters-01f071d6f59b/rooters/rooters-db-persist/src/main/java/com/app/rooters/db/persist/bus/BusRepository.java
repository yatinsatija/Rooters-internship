package com.app.rooters.db.persist.bus;

import com.app.rooters.db.model.bus.Bus;
import com.app.rooters.db.persist.base.QuerydslJpaRepository;

import java.util.UUID;

//Repository for bus
public interface BusRepository extends QuerydslJpaRepository<Bus, UUID> {
}