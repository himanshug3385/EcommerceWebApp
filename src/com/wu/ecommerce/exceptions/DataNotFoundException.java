package com.wu.ecommerce.exceptions;

public class DataNotFoundException extends Exception {
//	only have one constructor which will accept the string
	
	public DataNotFoundException(String msg) {
		super(msg);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
}
