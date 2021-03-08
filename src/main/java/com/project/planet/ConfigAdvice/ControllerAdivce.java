package com.project.planet.ConfigAdvice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdivce {
   
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrosList handleMethodNotErrosList(MethodArgumentNotValidException ms) {
		List<String> ResultDefaultErrosAtributs = ms.getBindingResult().getAllErrors()
		        .stream()
		        .map(erros -> erros.getDefaultMessage())
		        .collect(Collectors.toList());
		return new ErrosList(ResultDefaultErrosAtributs);
	}
}
