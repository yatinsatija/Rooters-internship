package com.app.rooters.db.model.route;

import com.app.rooters.db.model.bus.Bus;
import com.app.rooters.db.model.city.CityArea;
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

@Entity(name = "route")
@Accessors(fluent = true)
@Setter
@Getter
public class Route extends AuditedEntity {

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @Id
    @Setter(AccessLevel.NONE)
    private UUID routeId;

    @NotNull(message = "Route group id can not be null")
    @Column(columnDefinition = "BINARY(16)")
    private UUID routeGroupId;

    @NotNull(message = "Order value can not be null")
    private Integer orderValue;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "source_area_id")
    @NotNull(message = "Source area can not be null")
    private CityArea sourcePoint;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "destination_area_id")
    @NotNull(message = "Destination area can not be null")
    private CityArea destinationPoint;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "bus_id")
    @NotNull(message = "Bus can not be null")
    private Bus bus;

}
