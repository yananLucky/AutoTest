package com.course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PreDestroy;

@EnableScheduling
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class,scanBasePackages={ "com.course.controller.Demo"})

public class Application {
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        System.out.println("1111111111111111");
        Application.context=SpringApplication.run(Application.class,args);
    }
    @PreDestroy
    public void close(){
    Application.context.close();
    }
}
