package com.mike.springjpa.crud.config;

import com.mike.springjpa.crud.bean.Department;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * - This is a  configuration class sets up an embedded H2 database using the EmbeddedDatabaseBuilder API of spring-jdbc.
 *   We then set up a EntityManagerFactory and use Hibernate as sample persistence provider. Declared here is the
 *   JpaTransactionManager. We finally activate Spring Data JPA repositories using the @EnableJpaRepositories annotation.
 *
 * @author: Miguel Angel Gonzalez Hernandez
 * @version: 22/09/2018/A
 * @see <a href = "https://github.com/miguel776/" /> https://github.com/miguel776/ – Spring proyect backend; MVC, JPA, Maven, Toncat embedded </a>
 */
@Configuration
@ComponentScan("com.mike.springjpa.crud.service")
@EnableJpaRepositories("com.mike.springjpa.crud.repository")
public class InfrastructureConfig {

    /**
     * - Create a DataSource using an embedded H2 database through  the EmbeddedDatabase class.
     *
     * @return DataSource
     */
    @Bean
    public DataSource dataSource() {
        EmbeddedDatabase db = new EmbeddedDatabaseBuilder()
                .setName("testdb")
                .setType(EmbeddedDatabaseType.H2)
                .build();
        return db;
    }

    /**
     * - JpaVendorAdapter interface that allows to plug in vendor-specific behavior into Spring's EntityManagerFactory creators.
     *   Serves as single configuration point for all vendor-specific properties.
     * - Prepare the underlying JDBC Connection of a transactional Hibernate Session, that is, whether to apply a transaction-specific
     *   isolation level and/or the transaction's read-only flag to the underlying JDBC Connection.
     *
     * @return JpaVendorAdapter
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
        bean.setDatabase(Database.H2);
        bean.setGenerateDdl(true);
        return bean;
    }

    /**
     * - FactoryBean that creates a JPA EntityManagerFactory according to JPA's standard container bootstrap contract. In this
     *   way to set up a shared JPA EntityManagerFactory in a Spring application context; the EntityManagerFactory can then be
     *   passed to JPA-based DAOs via dependency injection.
     *
     * @param dataSource (DataSource)
     * @param jpaVendorAdapter (JpaVendorAdapter)
     * @return LocalContainerEntityManagerFactoryBean
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactoryBean.setJpaDialect(new HibernateJpaDialect());
        entityManagerFactoryBean.setPackagesToScan(Department.class.getPackage().getName());
        entityManagerFactoryBean.setPersistenceUnitName("mysqlsource1");
        entityManagerFactoryBean.afterPropertiesSet();
        return entityManagerFactoryBean;
    }

    /**
     * - This transaction manager is appropriate for applications that use a single JPA EntityManagerFactory for transactional data access.
     *   JTA (usually through JtaTransactionManager) is necessary for accessing multiple transactional resources within the same transaction.
     *   Note that you need to configure your JPA provider accordingly in order to make it participate in JTA transactions.
     *
     * @param emf (EntityManagerFactory)
     * @return JpaTransactionManager
     */
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}