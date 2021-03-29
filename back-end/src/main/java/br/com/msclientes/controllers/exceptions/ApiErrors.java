package br.com.msclientes.controllers.exceptions;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ApiErrors {
	
	@Getter
	private List<String> errors;
	
	
	public ApiErrors(String message) {
		this.errors = Arrays.asList(message);
	}
}
