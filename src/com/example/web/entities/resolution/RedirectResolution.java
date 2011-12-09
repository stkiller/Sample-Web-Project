package com.example.web.entities.resolution;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
