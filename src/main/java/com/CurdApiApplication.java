package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class CurdApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(CurdApiApplication.class, args);
	}

	
	  @Bean 
	  public Docket productApi() { return new
			  Docket(DocumentationType.SWAGGER_2)
			  .select().apis(RequestHandlerSelectors.any()
					  /*RequestHandlerSelectors.basePackage("com.controller")*/)
			  .paths(PathSelectors.any())
			  .build();
			  //.apiInfo(apiInfo()); 
	  }
	  
	/*
	 * private ApiInfo apiInfo() { return new ApiInfo( "My REST API",
	 * "Some custom description of API.", "API TOS", "Terms of service", new
	 * springfox.documentation.service.Contact("John Doe", "www.example.com",
	 * "myeaddress@company.com"), "License of API", "API license URL"); }
	 */
	 
	  }
