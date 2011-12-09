package com.stkiller.webexample.bl.datavalidation.implementation;


import com.stkiller.webexample.bl.datavalidation.interfaces.IValidationResult;
import com.stkiller.webexample.bl.datavalidation.interfaces.IValidator;
import com.stkiller.webexample.dal.valueobject.GroupVO;

public class GroupValidator implements IValidator<GroupVO> {

	@Override
	public IValidationResult isValid(GroupVO object) {
		if(object ==null ){
			return new ValidationResult(true, "Group object cannot be null");
		}
		if(object.getName()==null || object.getName().length()<3){
			return new ValidationResult(true, "Group name cannot be null or shorter than 3 chars");
		}
		if(object.getRoles()==null || object.getRoles().size()<1){
			return new ValidationResult(true, "Group should have at least one role");
		}
		return new ValidationResult(false, "");
	}

	@Override
	public IValidationResult isIdentityValid(GroupVO object) {
		if(object ==null ){
			return new ValidationResult(true, "Group object cannot be null");
		}
		if(object.getId()==null || object.getId()<1){
			return new ValidationResult(true, "Group id cannot be null or lesser that 1");
		}
		return new ValidationResult(false, "");
	}

}
