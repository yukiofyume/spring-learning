package com.lwh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lwh
 * @Date: 2022年10月01日
 * @Describe: TODO
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryPrimary",
        transactionManagerRef = "transactionManagerPrimary",
        basePackages = {"com.lwh.repository.primary"})
public class PrimaryConfig {
    @Value("${spring.datasource.primary.show-sql}")
    private String showSql;
    @Value("${spring.jpa.hibernate.primary.ddl-auto}")
    private String ddlAuto;
    @Value("${spring.jpa.properties.hibernate.pg-dialect}")
    private String pgDialect;

    @Autowired
    @Qualifier("primaryDataSource")
    private DataSource primaryDataSource;
    @Autowired
    private HibernateProperties hibernateProperties;
    @Autowired
    private JpaProperties jpaProperties;

    @Primary
    @Bean(name = "entityManagerPrimary")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "entityManagerFactoryPrimary")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder) {
       final HashMap<String, String> properties = new HashMap<>();
       properties.put("hibernate.hbm2ddl.auto", ddlAuto);
       properties.put("hibernate.dialect", pgDialect);
       properties.put("hibernate.show_sql", showSql);
        return builder.dataSource(primaryDataSource)
                .properties(getHibernateProperties())
                .packages("com.lwh.pojo.entity.primary")
                .properties(properties)
                .persistenceUnit("primaryPersistenceUnit")
                .build();
    }

    @Primary
    @Bean(name = "transactionManagerPrimary")
    public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
    }

    private Map<String, Object> getHibernateProperties() {
        return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
    }
}
