package com.example.web.handlers;

import com.example.bl.dataaccess.IBLAccessManager;
import com.example.bl.exceptions.DataRetrievalException;
import com.example.bl.exceptions.DataWriteException;
import com.example.bl.exceptions.ValidationException;
import com.example.dal.valueobject.GroupVO;
import com.example.dal.valueobject.RoleVO;
import com.example.web.entities.execution.IExecutionContext;
import com.example.web.entities.resolution.ForwardResolution;
import com.example.web.entities.resolution.IResolution;
import com.example.web.entities.resolution.RedirectResolution;
import com.example.web.helper.AvailableActionType;
import com.example.web.helper.BeanUtilsHelper;

import java.util.ArrayList;
import java.util.List;

public class AddGroupRequestHandler implements IRequestHandler {
	private static final String VIEW = "/WEB-INF/view/AddGroup.jsp";
	private IBLAccessManager accessManager;
	private BeanUtilsHelper beanUtilsHelper;

	public AddGroupRequestHandler(IBLAccessManager accessManager, BeanUtilsHelper beanUtilsHelper) {
		super();
		this.accessManager = accessManager;
		this.beanUtilsHelper = beanUtilsHelper;
	}

	@Override
	public IResolution parseRequest(IExecutionContext context){
		if (!context.isParameterPresent("name")) {
			try {
				return parseEditRequest(context);
			} catch (DataRetrievalException ex) {
				throw new RuntimeException(ex);
			}
		} else {
			try {
				return parseAddRequest(context);
			} catch (DataWriteException e) {
				throw new RuntimeException(e);
			} catch (DataRetrievalException e) {
				throw new RuntimeException(e);
			}
		}
	}

	private IResolution parseEditRequest(IExecutionContext context) throws DataRetrievalException {
		GroupVO group = null;
		if (context.isParameterPresent("id")) {
			String id = context.getParameter("id");
			group = accessManager.retrieveGroup(new Long(id));
		}
		return parseEditRequest(group, context);
	}

	private IResolution parseEditRequest(GroupVO group, IExecutionContext context) throws DataRetrievalException {
		context.setAttribute("group", group);
		List<RoleVO> roles;
		roles = accessManager.retrieveRoles();
		context.setAttribute("roles", roles);
		return new ForwardResolution(VIEW);
	}

	private IResolution parseAddRequest(IExecutionContext context) throws DataRetrievalException, DataWriteException {
		GroupVO group = new GroupVO();
		try {
			beanUtilsHelper.populateBean(group, context.getParameterMap());
			List<RoleVO> roles = new ArrayList<RoleVO>();
			if (context.isParameterPresent("roles_id")) {
				for (String roleID : context.getParameterValues("roles_id")) {
					if (roleID == null) {
						continue;
					}
					roles.add(accessManager.retrieveRole(Long.parseLong(roleID)));
				}
			}
			group.setRoles(roles);
			accessManager.writeGroup(group);
			return new RedirectResolution("index.html?action=" + AvailableActionType.VIEW);
		} catch (ValidationException e) {
			context.addValidationError(e.getValidationResult().getValidationResultMessage());
			parseEditRequest(group, context);
			return new ForwardResolution(VIEW);
		}
	}
}
