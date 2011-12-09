package com.stkiller.webexample.web.handlers;


import com.stkiller.webexample.bl.dataaccess.IBLAccessManager;
import com.stkiller.webexample.bl.exceptions.DataRetrievalException;
import com.stkiller.webexample.dal.valueobject.GroupVO;
import com.stkiller.webexample.dal.valueobject.RoleVO;
import com.stkiller.webexample.dal.valueobject.UserVO;
import com.stkiller.webexample.web.entities.execution.IExecutionContext;
import com.stkiller.webexample.web.entities.resolution.ForwardResolution;
import com.stkiller.webexample.web.entities.resolution.IResolution;

import java.util.List;

public class ViewAllRequestHandler implements IRequestHandler {
	private static final String VIEW = "/WEB-INF/view/GetAllData.jsp";

	private IBLAccessManager accessManager;

	public ViewAllRequestHandler(IBLAccessManager accessManager) {
		super();
		this.accessManager = accessManager;
	}

	@Override
	public IResolution parseRequest(IExecutionContext context){
		try {
			List<UserVO> users = accessManager.retrieveUsersWithGroups();
			context.setAttribute("users", users);
			List<GroupVO> groups = accessManager.retrieveGroups();
			context.setAttribute("groups", groups);
			List<RoleVO> roles = accessManager.retrieveRoles();
			context.setAttribute("roles", roles);
			return new ForwardResolution(VIEW);
		} catch (DataRetrievalException ex) {
			throw new RuntimeException(ex);
		}
	}

}
