package com.stkiller.webexample.dal.factories.ms_sql;


import com.stkiller.webexample.dal.dao.IBaseDao;
import com.stkiller.webexample.dal.factories.IdentityIncrementor;
import com.stkiller.webexample.dal.valueobject.RoleVO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class MSSqlRoleDAO implements IBaseDao<RoleVO> {
	private static final String SELECT_ALL = "select * from roles";
	private static final String SELECT = "select * from roles where id=%1$d";
	private static final String UPDATE = "update roles set name='%2$s',description ='%3$s' where id=%1$d";
	private static final String DELETE = "delete from roles where id= %1$d";
	private static final String INSERT = "insert into roles(id, name,description) values (%1$d,'%2$s','%3$s')";

	@Override
	public List<RoleVO> retrieve(Connection connection) throws SQLException {
		List<RoleVO> result = new LinkedList<RoleVO>();
		Statement statement = connection.createStatement();
		ResultSet resSet = statement.executeQuery(SELECT_ALL);
		while (resSet.next()) {
			RoleVO current = new RoleVO(resSet.getLong("id"), resSet.getString("name"), resSet.getString("description"));
			result.add(current);
		}
		return result;
	}

	@Override
	public RoleVO retrieve(long id, Connection connection) throws SQLException {
		RoleVO result = null;
		Statement statement = connection.createStatement();
		ResultSet resSet = statement.executeQuery(String.format(SELECT, id));
		if (resSet.next()) {
			result = new RoleVO(resSet.getLong("id"), resSet.getString("name"), resSet.getString("description"));
		}
		return result;
	}

	@Override
	public boolean update(RoleVO item, Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		int result = statement
				.executeUpdate(String.format(UPDATE, item.getId(), item.getName(), item.getDescription()));
		return 0 < result;
	}

	@Override
	public boolean delete(RoleVO item, Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate(String.format(DELETE, item.getId()));
		return 0 < result;
	}

	@Override
	public long insert(RoleVO item, Connection connection) throws SQLException {
		if(item.getId()==null){
			IdentityIncrementor.incrementIdentity(item);
		}
		Statement statement = connection.createStatement();
		statement.executeUpdate(String.format(INSERT, item.getId(), item.getName(), item.getDescription()));
		return item.getId();
	}

}
