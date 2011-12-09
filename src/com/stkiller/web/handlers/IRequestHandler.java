package com.example.web.handlers;

import com.example.web.entities.execution.IExecutionContext;
import com.example.web.entities.resolution.IResolution;

public interface IRequestHandler {
	public IResolution parseRequest(IExecutionContext context);
}
