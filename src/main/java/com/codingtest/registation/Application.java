package com.codingtest.registation;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				 .select()
				 .apis(RequestHandlerSelectors.basePackage("com.codingtest.registation"))
				 .paths(PathSelectors.any())
				 .build()
				 .apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo("Student Course Registration",
				"This API helps to add, remove and register student and course", "VERSION", "TERMS OF SERVICE URL",
				new Contact("Mahesh", "URL", "maheshjava5052@gmail.com"), "LICENSE", "LICENSE URL",
				Collections.emptyList());
	}
}
