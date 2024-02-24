package com.example.webflux.demo.springreactive.exception;

/*import java.util.Map;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;


@Component
public class CustomerAPIExceptionHandler extends AbstractErrorWebExceptionHandler {

	public CustomerAPIExceptionHandler(ErrorAttributes errorAttributes, Resources resources,
			ApplicationContext applicationContext,ServerCodecConfigurer configurer) {
		super(errorAttributes, resources, applicationContext);
		// TODO Auto-generated constructor stub
		this.setMessageReaders(configurer.getReaders());
		this.setMessageWriters(configurer.getWriters());
	}

	@Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(),this::handleException);
    }
	private  Mono<ServerResponse> handleException(ServerRequest request){
		Map<String,Object> error=this.getErrorAttributes(request, ErrorAttributeOptions.defaults());
		error.remove("status");
		error.remove("requestId");
		return ServerResponse.status(HttpStatus.BAD_REQUEST)
				.contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(error));
	}

}*/
import java.util.Map;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class CustomerAPIExceptionHandler extends AbstractErrorWebExceptionHandler {

	public CustomerAPIExceptionHandler(ErrorAttributes errorAttributes, Resources resources,
			ApplicationContext applicationContext, ServerCodecConfigurer configurer) {
		super(errorAttributes, resources, applicationContext);
		this.setMessageWriters(configurer.getWriters());
		this.setMessageReaders(configurer.getReaders());
	}

	@Override
	protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {

		return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
	}

	private Mono<ServerResponse> renderErrorResponse(ServerRequest request) {
		Map<String, Object> errorProperties = getErrorAttributes(request, ErrorAttributeOptions.defaults());
		return ServerResponse.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(errorProperties));
	}
}
