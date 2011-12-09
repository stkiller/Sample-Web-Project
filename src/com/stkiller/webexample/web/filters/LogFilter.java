package com.stkiller.webexample.web.filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map.Entry;

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
