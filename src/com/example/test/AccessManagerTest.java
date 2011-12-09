package com.example.test;

import com.example.dal.dataaccess.AccessManager;
import com.example.dal.dataaccess.IAccessManager;
import com.example.dal.exceptions.DBException;
import com.example.dal.exceptions.NoSuchFactoryException;
import com.example.dal.factories.DAOFactoryType;
import com.example.dal.valueobject.GroupVO;
import com.example.dal.valueobject.RoleVO;
import com.example.dal.valueobject.UserVO;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class AccessManagerTest {
    private static IAccessManager accessManager;
    private static UserVO refUser;
    private static UserVO refUserWithGroup;
    private static GroupVO refGroup;
    private static RoleVO refRole;

	@BeforeClass
	public static void before() {
		refRole = new RoleVO("FirstRole", "FirstRole description");

		refGroup = new GroupVO("FirstGroup", "FirstGroup description");

		refGroup.getRoles().add(refRole);

		refUser = new UserVO("FirstUser", "FirstUserLogin", "UserPassword", refGroup.getId());

		refUserWithGroup = new UserVO(refUser.getId(), refUser.getName(), refUser.getLogin(), refUser.getPassword(),
				refUser.getGroupID());

		refUserWithGroup.setGroup(refGroup);
	}

	@Test
	public void testAccessManager() {
		try {
			accessManager = new AccessManager(DAOFactoryType.MS_SQL, "test", "test",
					"jdbc:jtds:sqlserver://localhost:1433/WebTest");
		} catch (NoSuchFactoryException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testWriteRole() {
		try {
			long result;
			result = accessManager.writeRole(refRole);
			Assert.assertTrue(result == refRole.getId());
		} catch (DBException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testWriteGroup() {
		try {
			long result;
			result = accessManager.writeGroup(refGroup);
			Assert.assertTrue(result == refGroup.getId());
		} catch (DBException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testWriteUser() {
		try {
			long result;
			refUser.setGroupID(refGroup.getId());
			result = accessManager.writeUser(refUser);
			Assert.assertTrue(result == refUser.getId());
		} catch (DBException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testRetrieveUsers() {
		try {
			List<UserVO> users = accessManager.retrieveUsers();
			Assert.assertNotNull(users);
			Assert.assertTrue("There are no users in the list", 0 < users.size());
			Assert.assertEquals(refUser, users.get(0));
			Assert.assertEquals(null, users.get(0).getGroup());
		} catch (DBException ex) {
			Assert.fail(ex.getMessage());
		}
	}

	@Test
	public void testRetrieveUsersWithGroups() {
		try {
			List<UserVO> users = accessManager.retrieveUsersWithGroups();
			Assert.assertNotNull(users);
			Assert.assertTrue("There are no users in the list", 0 < users.size());
			refUserWithGroup.setId(refUser.getId());
			refUserWithGroup.setGroupID(refUser.getGroupID());
			Assert.assertEquals(refUserWithGroup, users.get(0));
			Assert.assertEquals(refGroup, users.get(0).getGroup());
		} catch (DBException ex) {
			Assert.fail(ex.getMessage());
		}
	}

	@Test
	public void testRetrieveUser() {
		try {
			UserVO actual = accessManager.retrieveUser(refUser.getId());
			Assert.assertEquals(refUser, actual);
			Assert.assertEquals(null, actual.getGroup());
		} catch (DBException ex) {
			Assert.fail(ex.getMessage());
		}
	}

	@Test
	public void testRetrieveUserWithGroup() {
		try {
			UserVO actual = accessManager.retrieveUserWithGroup(refUser.getId());
			Assert.assertEquals(refUserWithGroup, actual);
			Assert.assertEquals(refGroup, actual.getGroup());
		} catch (DBException ex) {
			Assert.fail(ex.getMessage());
		}
	}

	@Test
	public void testRetriveGroups() {
		try {
			List<GroupVO> groups = accessManager.retrieveGroups();
			Assert.assertNotNull(groups);
			Assert.assertTrue(0 < groups.size());
			Assert.assertEquals(refGroup, groups.get(0));
		} catch (DBException ex) {
			Assert.fail(ex.getMessage());
		}
	}

	@Test
	public void testRetrieveGroup() {
		try {
			GroupVO group = accessManager.retrieveGroup(refGroup.getId());
			Assert.assertNotNull(group);
			Assert.assertEquals(refGroup, group);
		} catch (DBException ex) {
			Assert.fail(ex.getMessage());
		}
	}

	@Test
	public void testRetrieveRoles() {
		try {
			List<RoleVO> roles = accessManager.retrieveRoles();
			Assert.assertNotNull(roles);
			Assert.assertTrue(0 < roles.size());
			Assert.assertEquals(refRole, roles.get(0));
		} catch (DBException ex) {
			Assert.fail(ex.getMessage());
		}
	}

	@Test
	public void testRetrieveRole() {
		try {
			RoleVO role = accessManager.retrieveRole(refRole.getId());
			Assert.assertNotNull(role);
			Assert.assertEquals(refRole, role);
		} catch (DBException ex) {
			Assert.fail(ex.getMessage());
		}
	}

	@AfterClass
	public static void after() {
		try {
			boolean result = accessManager.removeUser(refUser);
			Assert.assertTrue(result);
			result = accessManager.removeGroup(refGroup);
			Assert.assertTrue(result);
			result = accessManager.removeRole(refRole);
			Assert.assertTrue(result);
		} catch (DBException ex) {
			Assert.fail(ex.getMessage());
		}
	}
}
