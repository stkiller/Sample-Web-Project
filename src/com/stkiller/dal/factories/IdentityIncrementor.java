package com.example.dal.factories;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.example.dal.valueobject.ValueObject;

public class IdentityIncrementor {
	private static Map<Class<?>, Long> idetities = new HashMap<Class<?>, Long>();
	
	public static void incrementIdentity(ValueObject valueObject){
		if(!idetities.containsKey(valueObject.getClass())){
			idetities.put(valueObject.getClass(), 0l);
		}
		idetities.put(valueObject.getClass(), idetities.get(valueObject.getClass())+1);
		valueObject.setId(idetities.get(valueObject.getClass()));
		Logger.getLogger(IdentityIncrementor.class).debug(idetities.get(valueObject.getClass()));
	}

	public static Map<Class<?>, Long> getIdetities() {
		return idetities;
	}
	
	
}
