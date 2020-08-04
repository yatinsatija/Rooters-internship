package com.app.rooters.db.model.city;

import com.app.rooters.db.model.misc.audit.AuditedEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity(name = "city")
@Accessors(fluent = true)
@Setter
@Getter
@ToString(of = {"name"})
public class City extends AuditedEntity {

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @Id
    @Setter(AccessLevel.NONE)
    private UUID cityId;

    @NotNull(message = "City name can not be null")
    private String name;

    @NotNull(message = "State name can not be null")
    private String state;

}
