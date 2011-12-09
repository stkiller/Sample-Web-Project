package com.example.web.entities.resolution;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IResolution {
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException ;
}
