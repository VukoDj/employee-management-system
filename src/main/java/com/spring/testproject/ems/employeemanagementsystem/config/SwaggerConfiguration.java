package com.spring.testproject.ems.employeemanagementsystem.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    public Docket employeeManagementSystemAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Employee management system API")
                .version("1.0")
                .description("Test project for Amplitudo")
                .contact(new Contact("Vuko Djaletic",
                        "https://www.linkedin.com/in/vuko-%C4%91aleti%C4%87-471b711bb/",
                        "djaleticv@gmail.com"))
                .license("Apache Licence Version 2.0")
                .build();
    }
}
