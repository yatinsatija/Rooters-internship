package com.app.rooters.db.model.bus;

import com.app.rooters.db.model.city.CityArea;
import com.app.rooters.db.model.misc.audit.AuditedEntity;
import com.app.rooters.db.model.operators.Operator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
import java.time.Instant;
import java.util.UUID;

@Entity(name = "bus")
@Accessors(fluent = true)
@Setter
@Getter
@ToString(of = {"name", "busNo"})
public class Bus extends AuditedEntity {

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @Id
    @Setter(AccessLevel.NONE)
    private UUID busId;

    @NotNull(message = "Bus name can not be null")
    private String name;

    @NotNull(message = "Bus No can not be null")
    private String busNo;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "operator_id")
    @NotNull(message = "Operator can not be null")
    private Operator operator;

    @NotNull(message = "Seat type can not be null")
    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @NotNull(message = "Registration date can not be null")
    private Instant registrationDate;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "registered_city_area_id")
    @NotNull(message = "Registered city area can not be null")
    private CityArea registeredCityArea;

    @NotNull(message = "Bus type can not be null")
    @Enumerated(EnumType.STRING)
    private BusType busType;

}
