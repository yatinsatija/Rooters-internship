package com.app.rooters.db.model.bus;

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
import java.time.Instant;
import java.util.UUID;

/**
 *  Availability of bus based on date. Once the date is passed we can delete past entries.
 *  Query this table to get bus availability details based on the date.
 */

@Entity(name = "bus_availability")
@Accessors(fluent = true)
@Setter
@Getter
public class BusAvailability extends AuditedEntity {

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @Id
    @Setter(AccessLevel.NONE)
    private UUID busAvailabilityId;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "bus_id")
    @NotNull(message = "Bus Id can not be null")
    private Bus bus;

    @NotNull(message = "Available date can not be null")
    private Instant availableDate;

    @NotNull(message = "Available seat can not be null")
    private Integer availableSeat;

//    @ManyToOne(cascade = CascadeType.DETACH)
//    @JoinColumn(name = "route_group_id")
    @NotNull(message = "Route group id can not be null")
    private UUID routeGroupId;


}
