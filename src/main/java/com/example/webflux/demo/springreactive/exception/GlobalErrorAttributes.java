package com.example.webflux.demo.springreactive.exception;


import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes{

	@Override
	public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
		Map<String, Object> errorMap = new LinkedHashMap<String, Object>();//getErrorAttributes(request, options.isIncluded(Include.STACK_TRACE));
		Throwable error = getError(request);
		errorMap.put("message", error.getMessage());
		errorMap.put("path", request.path());
		return errorMap;
	}
}