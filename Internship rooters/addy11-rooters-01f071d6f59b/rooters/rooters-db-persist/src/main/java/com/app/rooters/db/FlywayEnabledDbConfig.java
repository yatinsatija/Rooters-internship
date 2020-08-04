package com.app.rooters.db;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;

@Slf4j
public abstract class FlywayEnabledDbConfig extends BaseDbConfig {

    protected abstract FlywayProperties flywayProperties();

    protected abstract Flyway flyway();


    protected FlywayMigrationInitializer buildFlywayInitializer() {
        Flyway flyway = flyway();
        FlywayProperties properties = flywayProperties();
        FlywayMigrationStrategy migrationStrategy = flyway1 -> {
            if (properties.isEnabled()) {
                flyway1.migrate();
            } else {
                log.info("Flyway {} disabled", persistenceUnit());
            }
        };
        return new FlywayMigrationInitializer(flyway, migrationStrategy);
    }

    protected Flyway buildFlyway() {
        FlywayProperties properties = flywayProperties();
        return Flyway.configure()
                .dataSource(properties.getUrl(), properties.getUser(), properties.getPassword())
                .schemas(properties.getSchemas().toArray(new String[]{}))
                .table(properties.getTable())
                .outOfOrder(properties.isOutOfOrder())
                .placeholderPrefix("$flyway{")
                .placeholderSuffix("}")
                .locations("classpath:com/app/rooters/" + persistenceUnit() + "/db/migration")
                .load();
    }
}
