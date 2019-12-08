package br.com.alura.forum.controller;


import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.com.alura.forum.controller.dto.ErrorDto;

@RestControllerAdvice
public class ExceptionHandlerController {
	
	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	@ExceptionHandler(value = BadCredentialsException.class)
	public ErrorDto handleBadCredentialsException(WebRequest request, BadCredentialsException exception){
		ErrorDto errorDto = new ErrorDto(403, "Autenticação Inválida", exception.getMessage());
		String stackTrace = ExceptionUtils.getStackTrace(exception);
		errorDto.setTrace(stackTrace);
		return errorDto;
	}

}
