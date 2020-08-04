package com.app.rooters.db;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Slf4j
public abstract class BaseDbConfig {

    protected abstract DataSourceProperties dataSourceProperties();

    protected abstract DataSource dataSource();

    protected abstract String persistenceUnit();

    protected abstract boolean validateSchema();

    protected abstract boolean showSql();

    protected abstract boolean formatSql();

    protected abstract PlatformTransactionManager transactionManager();

    protected String[] getPackagesToScan() {
        return new String[]{getClass().getPackage().getName()};
    }

    protected LocalContainerEntityManagerFactoryBean buildEntityManagerFactoryBean() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(false);
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan(getPackagesToScan());
        factoryBean.setPersistenceUnitName(persistenceUnit());
        factoryBean.getJpaPropertyMap().put("hibernate.dialect.storage_engine", "innodb");
        factoryBean.getJpaPropertyMap().put("hibernate.physical_naming_strategy", SpringPhysicalNamingStrategy.class.getName());
        if (validateSchema()) {
            factoryBean.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "validate");
        }
        factoryBean.getJpaPropertyMap().put("hibernate.show_sql", showSql() + "");
        factoryBean.getJpaPropertyMap().put("hibernate.format_sql", formatSql() + "");
        return factoryBean;
    }

}
