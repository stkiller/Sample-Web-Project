package com.stkiller.webexample.web.listeners;


import com.stkiller.webexample.bl.dataaccess.BLAccessManager;
import com.stkiller.webexample.bl.dataaccess.IBLAccessManager;
import com.stkiller.webexample.dal.factories.DAOFactoryType;
import com.stkiller.webexample.web.handlers.*;
import com.stkiller.webexample.web.helper.AvailableActionType;
import com.stkiller.webexample.web.helper.BeanUtilsHelper;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class InitializationListener implements ServletContextListener {
	private static final String DB_USER = "dbUser";
	private static final String DB_PASS = "dbPass";
	private static final String DB_URL = "dbURL";
	private static final String DB_TYPE = "dbType";

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		PropertyConfigurator.configure("log4j.properties");
		String dbUser = contextEvent.getServletContext().getInitParameter(DB_USER);
		String dbPass = contextEvent.getServletContext().getInitParameter(DB_PASS);
		String dbURL = contextEvent.getServletContext().getInitParameter(DB_URL);
		String dbType = contextEvent.getServletContext().getInitParameter(DB_TYPE);
		IBLAccessManager accessManager = new BLAccessManager(DAOFactoryType.valueOf(dbType), dbUser, dbPass, dbURL);
		BeanUtilsHelper beanHelper = new BeanUtilsHelper();
		Map<AvailableActionType, IRequestHandler> availableHandlers = new HashMap<AvailableActionType, IRequestHandler>();
		availableHandlers.put(AvailableActionType.VIEW, new ViewAllRequestHandler(accessManager));
		availableHandlers.put(AvailableActionType.ADD_GROUP, new AddGroupRequestHandler(accessManager, beanHelper));
		availableHandlers.put(AvailableActionType.DELETE_ENTITY, new DeleteEntityRequestHandler(accessManager));
		availableHandlers.put(AvailableActionType.ADD_USER, new AddUserRequestHandler(accessManager, beanHelper));
		availableHandlers.put(AvailableActionType.ADD_ROLE, new AddRoleRequestHandler(accessManager, beanHelper));
		availableHandlers.put(AvailableActionType.LOGIN, new LoginHandler());
		availableHandlers.put(AvailableActionType.LOGIN_ERROR, new LoginErrorHandler());
		contextEvent.getServletContext().setAttribute("handlers", availableHandlers);

	}

}
