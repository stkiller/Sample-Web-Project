package com.example.dal.factories.postgre;

import com.example.dal.dao.IBaseDao;
import com.example.dal.valueobject.UserVO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class PostgreUserDAO implements IBaseDao<UserVO> {
	private static final String SELECT_ALL = "select * from users";
	private static final String SELECT = "select * from users where id=%1$d";
	private static final String UPDATE = "update users set name='%2$s',login ='%3$s',password='%4$s', group_id=%5$d where id=%1$d";
	private static final String DELETE = "delete from users where id= %1$d";
	private static final String INSERT = "insert into users(id, name,login,password,group_id) values (%1$d,'%2$s','%3$s','%4$s',%5$d)";

	@Override
	public List<UserVO> retrieve(Connection connection) throws SQLException {
		List<UserVO> result = new LinkedList<UserVO>();
		Statement statement = connection.createStatement();
		ResultSet resSet = statement.executeQuery(SELECT_ALL);
		while (resSet.next()) {
			UserVO current = new UserVO(resSet.getLong("id"), resSet.getString("name"), resSet.getString("login"),
					resSet.getString("password"), resSet.getLong("group_id"));
			result.add(current);
		}
		return result;
	}

	@Override
	public UserVO retrieve(long id, Connection connection) throws SQLException {
		UserVO result = null;
		Statement statement = connection.createStatement();
		ResultSet resSet = statement.executeQuery(String.format(SELECT, id));
		if (resSet.next()) {
			result = new UserVO(resSet.getLong("id"), resSet.getString("name"), resSet.getString("login"),
					resSet.getString("password"), resSet.getLong("group_id"));
		}
		return result;
	}

	@Override
	public boolean update(UserVO item, Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate(String.format(UPDATE, item.getId(), item.getName(), item.getLogin(),
				item.getPassword(), item.getGroupID()));
		return 0 < result;
	}

	@Override
	public boolean delete(UserVO item, Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate(String.format(DELETE, item.getId()));
		return 0 < result;
	}

	@Override
	public long insert(UserVO item, Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(String.format(INSERT, item.getId(), item.getName(), item.getLogin(),
				item.getPassword(), item.getGroupID()));
		return item.getId();
	}

}
