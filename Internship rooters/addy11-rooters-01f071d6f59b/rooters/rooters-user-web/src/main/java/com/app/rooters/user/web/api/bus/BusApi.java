package com.app.rooters.user.web.api.bus;

import com.app.rooters.common.web.api.common.AbstractJpaCrudApi;
import com.app.rooters.db.model.bus.Bus;
import com.app.rooters.db.persist.base.QuerydslJpaRepository;
import com.app.rooters.user.web.api.bus.model.BusEditModel;
import com.app.rooters.user.web.api.bus.model.BusListModel;
import com.querydsl.core.types.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/bus")
public class BusApi extends
        AbstractJpaCrudApi<BusEditModel, BusListModel, Bus> {

    @Override
    protected QuerydslJpaRepository<Bus, UUID> repository() {
        return null;
    }

    @Override
    public ResponseEntity search(Pageable pageable, Predicate predicate, String search) {
        return null;
    }

    @Override
    public ResponseEntity get(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity saveOrUpdate(BusEditModel editModel) {
        return null;
    }

    @Override
    public ResponseEntity delete(BusEditModel editModel) {
        return null;
    }
}