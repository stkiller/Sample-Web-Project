package com.stkiller.webexample.web.handlers;


import com.stkiller.webexample.bl.dataaccess.IBLAccessManager;
import com.stkiller.webexample.bl.exceptions.DataWriteException;
import com.stkiller.webexample.bl.exceptions.ValidationException;
import com.stkiller.webexample.dal.valueobject.GroupVO;
import com.stkiller.webexample.dal.valueobject.RoleVO;
import com.stkiller.webexample.dal.valueobject.UserVO;
import com.stkiller.webexample.web.entities.execution.IExecutionContext;
import com.stkiller.webexample.web.entities.resolution.IResolution;
import com.stkiller.webexample.web.entities.resolution.RedirectResolution;
import com.stkiller.webexample.web.helper.AvailableActionType;

public class DeleteEntityRequestHandler implements IRequestHandler {

	private IBLAccessManager accessManager;

	public DeleteEntityRequestHandler(IBLAccessManager accessManager) {
		super();
		this.accessManager = accessManager;
	}

	@Override
	public IResolution parseRequest(IExecutionContext context){
		String objectType = context.getParameter("type");
		String id = context.getParameter("id");
		try {
			if (objectType != null && id != null) {
				if (objectType.equals("user")) {
                    UserVO user = new UserVO(new Long(id));
                    user.setName("");
                    user.setLogin("");
                    user.setPassword("");
                    accessManager.removeUser(user);
                }
				if (objectType.equals("role")) {
                    RoleVO role = new RoleVO(new Long(id));
                    role.setName("");
                    accessManager.removeRole(role);
                }
				if (objectType.equals("group")) {
                    GroupVO group = new GroupVO(new Long(id));
                    group.setName("");
                    accessManager.removeGroup(group);
                }
			}
			return new RedirectResolution("index.html?action=" + AvailableActionType.VIEW);
		} catch (DataWriteException ex) {
			throw new RuntimeException(ex);
		} catch (ValidationException e) {
			throw new RuntimeException(e);
		}
	}

}
