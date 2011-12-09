package com.stkiller.webexample.web.entities.execution;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExecutionContext implements IExecutionContext {
    private HttpServletRequest request;
    private HttpServletResponse response;

	public ExecutionContext(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addValidationError(String message) {
		List<String> messages;
		if (request.getAttribute("validation") == null) {
			messages = new ArrayList<String>();
		} else {
			messages = (List<String>) request.getAttribute("validation");
		}
		messages.add(message);
		request.setAttribute("validation", messages);
	}

	@Override
	public HttpServletRequest getRequest() {
		return request;
	}

	@Override
	public HttpServletResponse getResponse() {
		return response;
	}

	@Override
	public boolean isParameterPresent(String name) {
		return request.getParameterMap().containsKey(name);
	}

	@Override
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public String getParameter(String name) {
		return request.getParameter(name);
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return request.getParameterMap();
	}

	@Override
	public String[] getParameterValues(String arg0) {
		return request.getParameterValues(arg0);
	}

	@Override
	public void setAttribute(String arg0, Object arg1) {
		request.setAttribute(arg0, arg1);
	}
}
