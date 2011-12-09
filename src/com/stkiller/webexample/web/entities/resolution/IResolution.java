package com.stkiller.webexample.web.entities.resolution;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IResolution {
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException ;
}
