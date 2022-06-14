package com.globant.elearning.auth.exception;

public class UserAlreadyRegisteredException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserAlreadyRegisteredException(String msg) {
		super(msg);
	}
}
