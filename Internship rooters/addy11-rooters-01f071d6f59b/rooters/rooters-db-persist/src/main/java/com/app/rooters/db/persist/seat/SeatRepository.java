package com.app.rooters.db.persist.seat;

import com.app.rooters.db.model.seat.Seat;
import com.app.rooters.db.persist.base.QuerydslJpaRepository;

import java.util.UUID;

public interface SeatRepository extends QuerydslJpaRepository<Seat, UUID> {
}