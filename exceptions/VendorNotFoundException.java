package com.java.exceptions;

public class VendorNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public VendorNotFoundException(String message) {
			super(message);
		}

	public VendorNotFoundException(String message, Throwable t) {
			super(message, t);
		}

}
