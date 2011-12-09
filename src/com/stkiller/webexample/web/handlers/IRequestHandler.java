package com.stkiller.webexample.web.handlers;


import com.stkiller.webexample.web.entities.execution.IExecutionContext;
import com.stkiller.webexample.web.entities.resolution.IResolution;

public interface IRequestHandler {
	public IResolution parseRequest(IExecutionContext context);
}
