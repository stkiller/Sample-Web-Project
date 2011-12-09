package com.stkiller.webexample.web.entities.resolution;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectResolution implements IResolution {

	private String path;
	
	public RedirectResolution(String path) {
		super();
		this.path = path;
	}
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.sendRedirect(path);
	}

}
