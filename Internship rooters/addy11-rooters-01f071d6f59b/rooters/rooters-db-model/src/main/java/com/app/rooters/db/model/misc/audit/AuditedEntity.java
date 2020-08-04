package com.app.rooters.db.model.misc.audit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@AccessType(AccessType.Type.PROPERTY)
@Getter
@Setter
@Accessors(fluent = true)
@NoArgsConstructor
public abstract class AuditedEntity implements IAuditedEntity {

    public static final String DEFAULT_USER = "SYSTEM";

    @CreatedDate
    protected Instant created = Instant.now();

    @CreatedBy
    @AccessType(AccessType.Type.PROPERTY)
    @JsonIgnore
    protected String createdBy = DEFAULT_USER;

    @LastModifiedDate
    protected Instant modified;

    @JsonIgnore
    @LastModifiedBy
    @AccessType(AccessType.Type.PROPERTY)
    protected String modifiedBy;


    // We expose setters for these so that if createdBy and/or modifiedBy is already set spring-data JPA auditing doesn't
    // overwrite it them with null in tests.
    public void setCreatedBy(String createdBy) {
        if (null != createdBy) {
            this.createdBy = createdBy;
        }
    }

    public void setModifiedBy(String modifiedBy) {
        if (null != modifiedBy) {
            this.modifiedBy = modifiedBy;
        }
    }
}
