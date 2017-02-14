package com.gaospot.cms.config;

import java.util.Properties;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@EnableTransactionManagement
@ComponentScan
public class DataSourceConfig implements TransactionManagementConfigurer{
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Bean
	public DataSource embeddedDataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("user/db/schema.sql")
				.addScript("user/db/test-data.sql")
				.build();
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource ds) {
		LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
		sfb.setDataSource(ds);
		sfb.setPackagesToScan(new String[] { "com.gaospot.cms.domain" });
		Properties props = new Properties();
		props.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
		sfb.setHibernateProperties(props);
		return sfb;
		
	}

	public PlatformTransactionManager annotationDrivenTransactionManager() {
	    System.out.println(sessionFactory);
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	    transactionManager.setSessionFactory(sessionFactory);
	    return transactionManager;
	}

}
