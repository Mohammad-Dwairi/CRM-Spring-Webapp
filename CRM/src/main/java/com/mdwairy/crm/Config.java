package com.mdwairy.crm;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

//@Spring Configuration Class 
//@EnableTransactionManagement to enable auto-transactions
//@ComponentScan is used to register Beans in the Spring Container by scanning the given packages.
//Implementing WebMvcConfigurer is not Mandatory in this project, you will need it in more advanced projects.
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.mdwairy.crm")
public class Config implements WebMvcConfigurer {

    //ViewResolver to set the "engine" that renders the JSP files.
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolverBean = new InternalResourceViewResolver();
        viewResolverBean.setViewClass(JstlView.class);
        viewResolverBean.setPrefix("/WEB-INF/view/");
        viewResolverBean.setSuffix(".jsp");
        return viewResolverBean;
    }

    //DataSource Bean contains meta-data about the database to tell the session factory how to connect to that specific database.
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSourceBean = new ComboPooledDataSource();
        dataSourceBean.setDriverClass("com.mysql.jdbc.Driver");
        dataSourceBean.setJdbcUrl("jdbc:mysql://localhost:3306/DatabaseName?useSSL=false&serverTimezone=UTC");
        dataSourceBean.setUser("mysql username");
        dataSourceBean.setPassword("password");
        return dataSourceBean;
    }

    //Hibernate properties to personalize Hibernate logging and some other properties.
    @Bean
    public Properties hibernateProperty(){
        Properties hibernatePropertiesBean = new Properties();
        hibernatePropertiesBean.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        hibernatePropertiesBean.setProperty("hibernate.show_sql", "true");
        return hibernatePropertiesBean;
    }

    //Session Factory creates sessions with the database to execute queries and transactions.
    @Bean
    public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource()); //Injecting DataSource into SessionFactory, Important!
        sessionFactoryBean.setPackagesToScan("com.mdwairy.crm.entity"); // Tell the Session Factory where to search for entities.
        sessionFactoryBean.setHibernateProperties(hibernateProperty());
        return sessionFactoryBean;
    }

    //Transaction Manager handles the Session's start and commit operations.
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

    //Register the resources location, CSS, Javascript and others.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

}
