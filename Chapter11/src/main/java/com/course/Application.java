package com.course6666;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
        ///(exclude = DataSourceAutoConfiguration.class,scanBasePackages={ "com.course.controller.com.course.Demo"})

public class Application {
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        System.out.println("1111111111111111");
       Application.context=SpringApplication.run(Application.class,args);

    }
/*    @Bean
    public SqlSessionFactory sessionFactory() throws Exception{
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBean().getObject();
        return sqlSessionFactory;
    }*/
   /* @PreDestroy
    public void close(){
    com.course.Application.context.close();
    }*/
}
