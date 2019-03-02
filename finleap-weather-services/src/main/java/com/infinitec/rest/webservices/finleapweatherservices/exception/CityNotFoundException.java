package com.infinitec.rest.webservices.finleapweatherservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Custom Exception class when valid input not provided by the user
 * @author Arun Nehru
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CityNotFoundException extends RuntimeException {

	public CityNotFoundException(String message) {
		super(message);
	}

}
