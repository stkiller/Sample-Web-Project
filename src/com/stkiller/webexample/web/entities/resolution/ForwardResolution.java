package com.stkiller.webexample.web.entities.resolution;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForwardResolution implements IResolution {

	private String path;
	
	public ForwardResolution(String path) {
		super();
		this.path = path;
	}


	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
		requestDispatcher.forward(req, resp);
	}

}
