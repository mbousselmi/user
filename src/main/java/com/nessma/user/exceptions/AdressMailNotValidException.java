package com.nessma.user.exceptions;

public class AdressMailNotValidException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public AdressMailNotValidException(String errorMessage) {
		super(errorMessage);
	}

}
