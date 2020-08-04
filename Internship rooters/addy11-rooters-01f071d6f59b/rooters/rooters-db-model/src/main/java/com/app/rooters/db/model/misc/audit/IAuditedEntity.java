package com.app.rooters.db.model.misc.audit;

import java.time.Instant;

public interface IAuditedEntity {


    String createdBy();

    Instant created();

    String modifiedBy();

    Instant modified();


}
