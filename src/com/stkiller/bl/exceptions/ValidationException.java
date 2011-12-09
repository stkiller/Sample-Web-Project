package com.example.bl.exceptions;

import com.example.bl.datavalidation.interfaces.IValidationResult;

public class ValidationException extends Exception {
	
	private IValidationResult validationResult;

	private static final long serialVersionUID = -8657882445542823036L;

	public ValidationException(IValidationResult result) {
		super();
		validationResult=result;
	}

	public IValidationResult getValidationResult() {
		return validationResult;
	}

	public void setValidationResult(IValidationResult validationResult) {
		this.validationResult = validationResult;
	}

	@Override
	public String getMessage() {
		return validationResult.getValidationResultMessage();
	}
	
	
}
