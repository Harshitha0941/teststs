package com.hcl.employee.exception;

public class IdException extends Exception{
	
	 
	private static final long serialVersionUID = 1L;
private String msg;
 public IdException(String msg) {
	 this.msg=msg;
 }
 @Override
 public String getMessage() {
	return this.msg;
	 
 }
}