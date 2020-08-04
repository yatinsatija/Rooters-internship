package com.app.rooters.db.model.operators;

import com.app.rooters.db.model.misc.audit.AuditedEntity;
import com.app.rooters.db.model.user.EmbeddableAddress;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity(name = "operator")
@Accessors(fluent = true)
@Setter
@Getter
@ToString(of = {"name"})
public class Operator extends AuditedEntity {

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @Id
    @Setter(AccessLevel.NONE)
    private UUID operatorId;

    @NotNull(message = "Name can not be null")
    private String name;

    @Embedded
    @NotNull(message = "Address can not be null")
    private EmbeddableAddress details;

    @NotNull(message = "GST No can not be null")
    private String gstNo;

    //Add other details like payment details


}
