package com.example.demo.attornatus.api.servico.exceptions;

public class ControllerrNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ControllerrNotFoundException(Object id) {
		super("Controller not found. Id " + id);
	}

}
