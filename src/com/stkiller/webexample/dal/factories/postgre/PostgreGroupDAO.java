package com.stkiller.webexample.dal.factories.postgre;


import com.stkiller.webexample.dal.dao.IManyToManyDAO;
import com.stkiller.webexample.dal.valueobject.GroupVO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class PostgreGroupDAO implements IManyToManyDAO<GroupVO> {

	private static final String SELECT_ALL = "select * from groups";
	private static final String SELECT = "select * from groups where id=%1$d";
	private static final String UPDATE = "update groups set name='%2$s',description ='%3$s' where id=%1$d";
	private static final String DELETE = "delete from groups where id= %1$d";
	private static final String INSERT = "insert into groups(id, name,description) values (%1$d,'%2$s','%3$s')";
	private static final String GET_ROLES = "select role_id from groupsroles where group_id=%1$d";
	private static final String ADD_ROLE = "insert into groupsroles(group_id, role_id) values (%1$d,%2$d)";
	private static final String REMOVE_ROLE = "delete from groupsroles where group_id=%1$d and role_id=%2$d";

	@Override
	public List<Long> getDependentsIDs(GroupVO owner, Connection connection) throws SQLException {
		List<Long> result = new LinkedList<Long>();
		Statement statement = connection.createStatement();
		ResultSet resSet = statement.executeQuery(String.format(GET_ROLES, owner.getId()));
		while (resSet.next()) {
			result.add(resSet.getLong("role_id"));
		}
		return result;
	}

	@Override
	public boolean removeDependent(GroupVO owner, Long dependentID, Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate(String.format(REMOVE_ROLE, owner.getId(), dependentID));
		return 0 < result;
	}

	@Override
	public boolean addDependent(GroupVO owner, Long dependentID, Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate(String.format(ADD_ROLE, owner.getId(), dependentID));
		return 0 < result;
	}

	@Override
	public List<GroupVO> retrieve(Connection connection) throws SQLException {
		List<GroupVO> result = new LinkedList<GroupVO>();
		Statement statement = connection.createStatement();
		ResultSet resSet = statement.executeQuery(SELECT_ALL);
		while (resSet.next()) {
			GroupVO current = new GroupVO(resSet.getLong("id"), resSet.getString("name"),
					resSet.getString("description"));
			result.add(current);
		}
		return result;
	}

	@Override
	public GroupVO retrieve(long id, Connection connection) throws SQLException {
		GroupVO result = null;
		Statement statement = connection.createStatement();
		ResultSet resSet = statement.executeQuery(String.format(SELECT, id));
		if (resSet.next()) {
			result = new GroupVO(resSet.getLong("id"), resSet.getString("name"), resSet.getString("description"));
		}
		return result;
	}

	@Override
	public boolean update(GroupVO item, Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		int result = statement
				.executeUpdate(String.format(UPDATE, item.getId(), item.getName(), item.getDescription()));
		return 0 < result;
	}

	@Override
	public boolean delete(GroupVO item, Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate(String.format(DELETE, item.getId()));
		return 0 < result;
	}

	@Override
	public long insert(GroupVO item, Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(String.format(INSERT, item.getId(), item.getName(), item.getDescription()));
		return item.getId();
	}

}
