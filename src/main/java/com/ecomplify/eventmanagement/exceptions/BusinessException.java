package com.ecomplify.eventmanagement.exceptions;

public class BusinessException extends RuntimeException {
	
	private String exception;
	public BusinessException(String exception){
        this.exception = exception;       
    }

    public String getExceptionMessage(){
        return exception;
    }
    

}
