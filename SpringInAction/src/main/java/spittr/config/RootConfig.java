package spittr.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration

@EnableTransactionManagement
@EnableJpaRepositories(basePackages="spittr.db")
@ComponentScan(
		basePackages= {"spitter"},
		excludeFilters= {
				@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)
				
		}
		)
public class RootConfig {
	@Bean
	 public ReloadableResourceBundleMessageSource messageSource() {
		 ReloadableResourceBundleMessageSource source=new ReloadableResourceBundleMessageSource();
		 source.setDefaultEncoding("UTF-8");
		 source.setBasenames("ValidationMessages");
		 return  source;
	 }
	//@Bean
	public JndiObjectFactoryBean dataSource() {
		
		JndiObjectFactoryBean jndiObjectFactoryBean=new JndiObjectFactoryBean();
		jndiObjectFactoryBean.setJndiName("jdbc/SpittrDS");
		jndiObjectFactoryBean.setResourceRef(true);
		jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
		return jndiObjectFactoryBean;
	}
	@Bean
	public DataSource datasource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("classpath:schema.sql")
				.addScript("classpath:test-data.sql")
				.build();
	}
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource datasource) {
		return new JdbcTemplate(datasource);
		
	}
	@Bean

	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sfd=new LocalSessionFactoryBean();
		sfd.setDataSource(dataSource);
		sfd.setPackagesToScan(new String[] {"spittr.model"});
		Properties properties=new Properties();
		properties.setProperty("dialect","org.hibernate.dialect.H2Dialect");
		properties.setProperty("show_sql", "true");
		properties.setProperty("format_sql","true");
		sfd.setHibernateProperties(properties);
		return sfd;
		
	}
	@Bean
	public AbstractPlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager manager=new HibernateTransactionManager(sessionFactory);
		return  manager;
	}
	@Bean
	//给不适用模板的HibernateRespsitory添加异常转换功能
	public BeanPostProcessor persistenceTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter=new HibernateJpaVendorAdapter();
	
              adapter.setShowSql(true);
              adapter.setGenerateDdl(true);
              adapter.setDatabasePlatform("org.hibernate.dialect.HSQLDialect");
              return adapter;
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			DataSource dataSource,
			JpaVendorAdapter jpaVendorAdapter
			) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean=
				new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		entityManagerFactoryBean.setPackagesToScan("spittr.model");
		return entityManagerFactoryBean;
		
	}
}
