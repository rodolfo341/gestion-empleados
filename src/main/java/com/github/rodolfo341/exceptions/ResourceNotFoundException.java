package com.github.rodolfo341.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =  HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
		private static final Long serialVersionID = 1L;
		
		public ResourceNotFoundException(String mensaje) {
			super(mensaje);
		}

}
