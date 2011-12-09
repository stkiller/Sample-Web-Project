package com.stkiller.webexample.bl.datavalidation.interfaces;


import com.stkiller.webexample.dal.valueobject.ValueObject;

public interface IValidator<T extends ValueObject> {
	
	/**
	 * Used to validate the entire object
	 * @param object
	 * @return
	 */
	public IValidationResult isValid(T object);
	
	/**
	 * Used to validate is object as an Identity ( has a valid ID )
	 * @param object
	 * @return
	 */
	public IValidationResult isIdentityValid(T object);

}
