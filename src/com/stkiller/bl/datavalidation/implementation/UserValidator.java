package com.example.bl.datavalidation.implementation;

import com.example.bl.datavalidation.interfaces.IValidationResult;
import com.example.bl.datavalidation.interfaces.IValidator;
import com.example.dal.valueobject.UserVO;

public class UserValidator implements IValidator<UserVO> {

	@Override
	public IValidationResult isValid(UserVO object) {
		if(object ==null ){
			return new ValidationResult(true, "User object cannot be null");
		}
		if(object.getName()==null || object.getName().length()<2){
			return new ValidationResult(true, "User name cannot be null or shorter than 5 chars");
		}
		if(object.getLogin()==null || object.getLogin().length()<5){
			return new ValidationResult(true, "User login cannot be null or shorter than 5 chars");
		}
		if(object.getPassword()==null || object.getPassword().length()<5){
			return new ValidationResult(true, "User password cannot be null or shorter that 5 chars");
		}
		return new ValidationResult(false, "");
	}

	@Override
	public IValidationResult isIdentityValid(UserVO object) {

		if(object ==null ){
			return new ValidationResult(true, "User object cannot be null");
		}
		if(object.getId()==null || object.getId()<1){
			return new ValidationResult(true, "User id cannot be null or lesser that 1 :"+object.getId());
		}
		return new ValidationResult(false, "");
	}

}
