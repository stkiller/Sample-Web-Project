package com.example.web.entities.execution;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IExecutionContext {
	public void addValidationError(String message);
	public boolean isParameterPresent(String name);
	public abstract String[] getParameterValues(String arg0);
	public abstract Map<String, String[]> getParameterMap();
	public abstract String getParameter(String name);
	public abstract void setResponse(HttpServletResponse response);
	public abstract void setRequest(HttpServletRequest request);
	public abstract HttpServletResponse getResponse();
	public abstract HttpServletRequest getRequest();
	public abstract void setAttribute(String arg0, Object arg1);
}
