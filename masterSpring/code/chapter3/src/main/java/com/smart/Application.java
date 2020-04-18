package com.smart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;

import javax.sql.DataSource;

/**
 * SpringBoot 1.2+中可以使用 @SpringBootApplication 代替 @Configuration @ComponentScan  @EnableAutoConfiguration三个注解
 *
 * SpringBoot中使用事务非常简单，首先在Application上标注@EnableTransactionManagement注解(
 * 开启事务支持，相当于XML中的<tx:annotation-driven/> 配置方式)，然后在访问Service方法上标注@Transactional注解即可
 * 如果将@Transactional注解标注在Service类级别上，那么当前Service类所有的方法都将被事务增强，建议不要在类级别上
 * 标注@Transactional注解
 *
 */
//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
@EnableTransactionManagement
public class Application extends SpringBootServletInitializer implements WebApplicationInitializer {

    /**
     * 通过@EnableTransactionManagement注解，Boot为应用自动装配了事物支持，这对用户并不透明，用户如果想自己定义事务
     * 管理器，则在Application类中添加一个，在Application中添加自定义事务管理器txManager，并在方法上标注@Bean注解，
     * 此时SpringBoot会加载自定义的事务管理器，不会重新实例化其他事务管理器
     * 如果在实际的项目中需要分布式事务支持，那么，Boot也提供了很好的支持，它集成了 Atomikos和Bitronix分布式事务
     * 处理框架，可以根据需要导入相应的启动器(spring-boot-starter-jta-atomikos或spring-boot-starter-jta-bitronix)
     * @param dataSource
     * @return
     */
    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 配置SpringMVC，Application继承SpringBootServletInitializer
     * 重写configure方法
     * @param application
     * @return
     */
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
