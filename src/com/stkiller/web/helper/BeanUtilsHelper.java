package com.example.web.helper;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtilsHelper {
	@SuppressWarnings("rawtypes")
	public void populateBean(Object bean, Map map){
		try {
			BeanUtils.populate(bean, map);
		} catch (Exception e) {
			throw new RuntimeException("There is an error when populating bean : "+e.getMessage());
		}
	}
}
