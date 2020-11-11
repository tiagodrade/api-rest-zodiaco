package com.zoodiaco.apirest.config;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zoodiaco.apirest"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

	//informações da criacao do api, apenas para documentacao do swagger
    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "API REST - ZODIACOS",
                "API REST de zodiacos.",
                "1.0",
                "",
                new Contact("Tiago Andrade", "",
                        "tiagodrade18@gmail.com"),
                "",
                "", new ArrayList<VendorExtension>()
        );
        //retorno das informacoes da api
        return apiInfo;
    }

}