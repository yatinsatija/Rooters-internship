package com.app.rooters.db;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@Slf4j
@EnableJpaRepositories(entityManagerFactoryRef = DbPersistConfig.ENTITY_MANAGER_FACTORY,
        transactionManagerRef = DbPersistConfig.TRANSACTION_MANAGER)
@ComponentScan
public class DbPersistConfig extends FlywayEnabledDbConfig {

    public static final String ENTITY_MANAGER_FACTORY = "entityManagerFactory";
    public static final String TRANSACTION_MANAGER = "transactionManager";
    public static final String DATA_SOURCE = "dataSource";

    @Value("${rooters.datasource.show-sql:false}")
    private boolean showSql;

    @Value("${rooters.datasource.format_sql:false}")
    private boolean formatSql;

    @Bean(name = "dataSourceProperties")
    @ConfigurationProperties("rooters.datasource")
    @Override
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = DATA_SOURCE)
    @Primary
    @ConfigurationProperties("rooters.datasource")
    public DataSource dataSource() {
        return dataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Override
    public String persistenceUnit() {
        return "rdb";
    }

    @Bean(name = TRANSACTION_MANAGER)
    @Primary
    @Override
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(rdbEntityManagerFactory().getObject());
    }

    @Override
    protected boolean showSql() {
        return showSql;
    }

    @Override
    protected boolean formatSql() {
        return formatSql;
    }

    @Override
    protected boolean validateSchema() {
        return true;
    }

    @Bean(name = "rdbFlywayProperties")
    @ConfigurationProperties(prefix = "rooters.flyway")
    public FlywayProperties flywayProperties() {
        return new FlywayProperties();
    }

    @Bean(name = "rdbFlyway")
    @Override
    public Flyway flyway() {
        return buildFlyway();
    }

    @Bean(name = ENTITY_MANAGER_FACTORY)
    @Primary
    @DependsOn("rdbFlywayInitializer")
    public LocalContainerEntityManagerFactoryBean rdbEntityManagerFactory() {
        return buildEntityManagerFactoryBean();
    }

    @Bean
    public FlywayMigrationInitializer rdbFlywayInitializer() {
        return buildFlywayInitializer();
    }

}
