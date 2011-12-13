package com.stkiller.webexample.test;

import com.stkiller.webexample.dal.dataaccess.IAccessManager;
import com.stkiller.webexample.dal.exceptions.DBException;
import com.stkiller.webexample.dal.factories.hibernate.HibernateAccessManager;
import com.stkiller.webexample.dal.valueobject.GroupVO;
import com.stkiller.webexample.dal.valueobject.RoleVO;
import com.stkiller.webexample.dal.valueobject.UserVO;
import org.junit.*;

import java.util.List;

public class AccessManagerTest {
    private static IAccessManager accessManager;
    private static UserVO refUser;
    private static GroupVO refGroup;
    private static RoleVO refRole;

	@BeforeClass
	public static void before() {
		refRole = new RoleVO("FirstRole", "FirstRole description");

		refGroup = new GroupVO("FirstGroup", "FirstGroup description");

		refGroup.getRoles().add(refRole);

		refUser = new UserVO("FirstUser", "FirstUserLogin", "UserPassword");
	}

	@Test
	public void testAccessManager() {
        accessManager = new HibernateAccessManager();
    }

	@Test
	public void testWriteRole() {
		try {
			long result;
			result = accessManager.writeRole(refRole);
			Assert.assertTrue(result == refRole.getId());
            System.out.println(refRole);
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
            System.out.println(refGroup);
		} catch (DBException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testWriteUser() {
		try {
			long result;
			result = accessManager.writeUser(refUser);
			Assert.assertTrue(result == refUser.getId());
            System.out.println(refUser);
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

//    @Ignore
//	@Test
//	public void testRetrieveUsersWithGroups() {
//		try {
//			List<UserVO> users = accessManager.retrieveUsersWithGroups();
//			Assert.assertNotNull(users);
//			Assert.assertTrue("There are no users in the list", 0 < users.size());
//			refUserWithGroup.setGroup(refGroup);
//			Assert.assertEquals(refUserWithGroup, users.get(0));
//			Assert.assertEquals(refGroup, users.get(0).getGroup());
//		} catch (DBException ex) {
//			Assert.fail(ex.getMessage());
//		}
//	}

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

//	@Test
//	public void testRetrieveUserWithGroup() {
//		try {
//			UserVO actual = accessManager.retrieveUserWithGroup(refUser.getId());
//			Assert.assertEquals(refUserWithGroup, actual);
//			Assert.assertEquals(refGroup, actual.getGroup());
//		} catch (DBException ex) {
//			Assert.fail(ex.getMessage());
//		}
//	}

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

//    @Ignore
//	@AfterClass
//	public static void after() {
//		try {
//			boolean result = accessManager.removeUser(refUser);
//			Assert.assertTrue(result);
//			result = accessManager.removeGroup(refGroup);
//			Assert.assertTrue(result);
//			result = accessManager.removeRole(refRole);
//			Assert.assertTrue(result);
//		} catch (DBException ex) {
//			Assert.fail(ex.getMessage());
//		}
//	}
}
