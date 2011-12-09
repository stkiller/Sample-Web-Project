package com.stkiller.webexample.web.handlers;


import com.stkiller.webexample.web.entities.execution.IExecutionContext;
import com.stkiller.webexample.web.entities.resolution.ForwardResolution;
import com.stkiller.webexample.web.entities.resolution.IResolution;

public class LoginHandler implements IRequestHandler {
	private static final String PATH="WEB-INF/view/Login.jsp";

	@Override
	public IResolution parseRequest(IExecutionContext context) {
		return new ForwardResolution(PATH);
	}

}
