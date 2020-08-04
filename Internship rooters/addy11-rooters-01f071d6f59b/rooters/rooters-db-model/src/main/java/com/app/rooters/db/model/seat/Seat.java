package com.app.rooters.db.model.seat;

import com.app.rooters.db.model.bus.Bus;
import com.app.rooters.db.model.bus.SeatType;
import com.app.rooters.db.model.misc.audit.AuditedEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity(name = "seat")
@Accessors(fluent = true)
@Setter
@Getter
public class Seat extends AuditedEntity {

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @Id
    @Setter(AccessLevel.NONE)
    private UUID seatId;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "bus_id")
    @NotNull
    private Bus busId;

    @NotNull
    private String code;

    @NotNull
    @Enumerated(EnumType.STRING)
    private SeatForType seatForType = SeatForType.NONE;

    @NotNull
    private Integer seatFare;

    @NotNull
    @Enumerated(EnumType.STRING)
    private SeatBookingStatus seatBookingStatus;

    @NotNull
    @Enumerated(EnumType.STRING)
    private SeatType seatType;

}
