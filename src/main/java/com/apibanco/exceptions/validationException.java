package com.apibanco.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class validationException extends Exception {
	private String msgDeErro;
	  public validationException(String defaultMessage) {
		  msgDeErro = defaultMessage;
	}

	@Override
	  public String getMessage(){
	    return msgDeErro;
	  }	
}
