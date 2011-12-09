package com.example.web.handlers;

import com.example.bl.dataaccess.IBLAccessManager;
import com.example.bl.exceptions.DataWriteException;
import com.example.bl.exceptions.ValidationException;
import com.example.dal.valueobject.GroupVO;
import com.example.dal.valueobject.RoleVO;
import com.example.dal.valueobject.UserVO;
import com.example.web.entities.execution.IExecutionContext;
import com.example.web.entities.resolution.IResolution;
import com.example.web.entities.resolution.RedirectResolution;
import com.example.web.helper.AvailableActionType;

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
					UserVO user = new UserVO();
					user.setId(new Long(id));
					accessManager.removeUser(user);
				}
				if (objectType.equals("role")) {
					RoleVO role = new RoleVO();
					role.setId(new Long(id));
					accessManager.removeRole(role);
				}
				if (objectType.equals("group")) {
					GroupVO group = new GroupVO();
					group.setId(new Long(id));
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
