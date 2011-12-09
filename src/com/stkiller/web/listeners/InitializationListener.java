package com.example.web.listeners;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.PropertyConfigurator;

import com.example.bl.dataaccess.BLAccessManager;
import com.example.bl.dataaccess.IBLAccessManager;
import com.example.dal.factories.DAOFactoryType;
import com.example.web.handlers.AddGroupRequestHandler;
import com.example.web.handlers.AddRoleRequestHandler;
import com.example.web.handlers.AddUserRequestHandler;
import com.example.web.handlers.DeleteEntityRequestHandler;
import com.example.web.handlers.IRequestHandler;
import com.example.web.handlers.LoginErrorHandler;
import com.example.web.handlers.LoginHandler;
import com.example.web.handlers.ViewAllRequestHandler;
import com.example.web.helper.AvailableActionType;
import com.example.web.helper.BeanUtilsHelper;


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
