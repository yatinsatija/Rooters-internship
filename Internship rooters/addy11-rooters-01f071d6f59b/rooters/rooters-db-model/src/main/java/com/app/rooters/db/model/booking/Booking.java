package com.app.rooters.db.model.booking;

import com.app.rooters.db.model.bus.BusAvailability;
import com.app.rooters.db.model.misc.audit.AuditedEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 *  One passenger will have many booking details, if one passenger books more than one seat.
 */
@Entity(name = "booking")
@Accessors(fluent = true)
@Setter
@Getter
public class Booking extends AuditedEntity {

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @Id
    @Setter(AccessLevel.NONE)
    private UUID bookingId;

    //delete passenger details when booking is deleted
    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull(message = "Passenger detail can not be null")
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull(message = "Bus availability can not be null")
    @JoinColumn(name = "bus_availability_id")
    private BusAvailability busAvailability;

    @NotNull(message = "Booking code can not be null")
    private String bookingCode;

    @NotNull(message = "Seat no can not be null")
    private String seatNo;

}
