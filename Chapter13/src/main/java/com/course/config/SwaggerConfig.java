package com.course.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//自动生成开发的接口文档的注解
public class SwaggerConfig {
    //固定写法
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/.*")).build();

    }
    //swagger生成的报告中会显示以下内容的信息
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("UserManager service API")
                .contact(new Contact("lyn","","ss.qq.com"))
                .description("This is the UserManager service API")
                .version("V1")
                .build();
    }

}
