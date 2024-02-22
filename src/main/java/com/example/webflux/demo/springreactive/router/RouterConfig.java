package com.example.webflux.demo.springreactive.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.webflux.demo.springreactive.handler.CustomerHandler;

@Configuration
public class RouterConfig {
   @Autowired
   private CustomerHandler customerHandler;
   
   @Bean
   public RouterFunction<ServerResponse> routerFunction(){
	return RouterFunctions.route()
			.GET("/router/customers",customerHandler::loadCustomers)
			.GET("/router/customers/stream",customerHandler::getCustomers)
			.GET("/router/customers/{input}",customerHandler::findCustomer)
			.POST("/router/customers/save",customerHandler::saveCustomer)
			.build();
	   
   }
  
   
}
