package com.stkiller.webexample.bl.datavalidation.implementation;


import com.stkiller.webexample.bl.datavalidation.interfaces.IValidationResult;

public class ValidationResult implements IValidationResult {
	private boolean invalid;
	private String message;
	
	public ValidationResult(){}
	
	public ValidationResult(boolean invalid, String message) {
		super();
		this.invalid = invalid;
		this.message = message;
	}
	@Override
	public String getValidationResultMessage() {
		return message;
	}
	@Override
	public boolean isInvalid() {
		return invalid;
	}
	@Override
	public void setInvalid(boolean invalid) {
		this.invalid =invalid;
	}
	
	@Override
	public void setValidationResultMessage(String message) {
		this.message=message;
	}
	
	

}
