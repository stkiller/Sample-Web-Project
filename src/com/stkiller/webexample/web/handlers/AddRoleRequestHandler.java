package com.stkiller.webexample.web.handlers;


import com.stkiller.webexample.bl.dataaccess.IBLAccessManager;
import com.stkiller.webexample.bl.exceptions.DataRetrievalException;
import com.stkiller.webexample.bl.exceptions.DataWriteException;
import com.stkiller.webexample.bl.exceptions.ValidationException;
import com.stkiller.webexample.dal.valueobject.RoleVO;
import com.stkiller.webexample.web.entities.execution.IExecutionContext;
import com.stkiller.webexample.web.entities.resolution.ForwardResolution;
import com.stkiller.webexample.web.entities.resolution.IResolution;
import com.stkiller.webexample.web.entities.resolution.RedirectResolution;
import com.stkiller.webexample.web.helper.AvailableActionType;
import com.stkiller.webexample.web.helper.BeanUtilsHelper;

public class AddRoleRequestHandler implements IRequestHandler {
	private static final String FORWARD_PATH = "/WEB-INF/view/AddRole.jsp";

	private IBLAccessManager accessManager;
	private BeanUtilsHelper beanHelper;

	public AddRoleRequestHandler(IBLAccessManager accessManager, BeanUtilsHelper beanHelper) {
		super();
		this.accessManager = accessManager;
		this.beanHelper = beanHelper;
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
			}
		}
	}

	private IResolution parseEditRequest(IExecutionContext context) throws DataRetrievalException {
		RoleVO role = null;
		if (context.isParameterPresent("id")) {
			role = accessManager.retrieveRole(new Long(context.getParameter("id")));
		}
		return parseEditRequest(role, context);
	}

	private IResolution parseEditRequest(RoleVO role, IExecutionContext context) {
		context.setAttribute("role", role);
		return new ForwardResolution(FORWARD_PATH);
	}

	private IResolution parseAddRequest(IExecutionContext context) throws DataWriteException {
		RoleVO role = new RoleVO();
		try {
			beanHelper.populateBean(role, context.getParameterMap());
			accessManager.writeRole(role);
			return new RedirectResolution("index.html?action=" + AvailableActionType.VIEW);
		} catch (ValidationException ex) {
			context.addValidationError(ex.getValidationResult().getValidationResultMessage());
			return parseEditRequest(role, context);
		}
	}
}
