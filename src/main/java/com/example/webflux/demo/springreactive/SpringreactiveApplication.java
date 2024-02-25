package com.example.webflux.demo.springreactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@OpenAPIDefinition(info=@Info(
		title="Spring webflux Crud Example without MongoDB",
		version="2.0",
		description="sample program for showcasing webflux concepts"
		))
public class SpringreactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringreactiveApplication.class, args);
	}

}
