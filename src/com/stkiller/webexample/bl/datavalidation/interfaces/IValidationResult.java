package com.stkiller.webexample.bl.datavalidation.interfaces;

public interface IValidationResult {
	public void setInvalid(boolean valid);
	public boolean isInvalid();
	public String getValidationResultMessage();
	public void setValidationResultMessage(String message);
}
