package com.java.exceptions;

public class FoodItemNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public FoodItemNotFoundException(String message) {
		super(message);
	}

	public FoodItemNotFoundException(String message, Throwable t) {
		super(message, t);
	}
}
