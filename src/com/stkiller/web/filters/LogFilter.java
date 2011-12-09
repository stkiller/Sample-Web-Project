package com.example.web.filters;

import java.io.IOException;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

@WebFilter(urlPatterns={"/*"})
public class LogFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		logInputRequest((HttpServletRequest)request);
		filterChain.doFilter(request, response);
		logResponse(response.getBufferSize());
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
	private void logResponse(int bufferSize) {
		Logger.getLogger(getClass()).info("Response: "+bufferSize);
	}
		
	private void logInputRequest(HttpServletRequest req){
		String parameters = "";
		for(Entry<String, String[]> entry : req.getParameterMap().entrySet()){
			parameters+=entry.getKey()+":[";
			for(String value : entry.getValue()){
				parameters += value;
			}
			parameters+="]";
		}
		parameters = "["+req.getRemoteHost()+"]"+req.getRequestURI()+"?"+parameters;
		Logger.getLogger(getClass()).info("Incoming request: "+parameters);
	}

}
