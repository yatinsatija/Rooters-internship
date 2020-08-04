package com.app.rooters.common.web.api.common;

import com.app.rooters.db.model.misc.audit.IAuditedEntity;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.util.UUID;

@Data
@Accessors(fluent = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@NoArgsConstructor
@ToString(callSuper = true)
public class AuditedEntityModel extends BaseModel<UUID> {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant created;

    private String createdBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant modified;

    private String modifiedBy;

    /**
     * New model for given entity.
     */
    public AuditedEntityModel(IAuditedEntity entity, UUID id) {
        super(id);
        this.created = entity.created();
        this.createdBy = entity.createdBy();
        this.modified = entity.modified();
        this.modifiedBy = entity.modifiedBy();
    }
}
