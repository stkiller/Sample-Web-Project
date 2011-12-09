/**
 * 
 */
package com.example.dal.factories.ms_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.dal.dao.IBaseDao;
import com.example.dal.dao.IManyToManyDAO;
import com.example.dal.exceptions.DBException;
import com.example.dal.factories.AbstractDAOFactory;
import com.example.dal.valueobject.GroupVO;
import com.example.dal.valueobject.RoleVO;
import com.example.dal.valueobject.UserVO;

/**
 * @author stkiller
 * 
 */
public class MSSqlDAOFactory extends AbstractDAOFactory {

	private static final String DB_DRIVER = "net.sourceforge.jtds.jdbc.Driver";

	public MSSqlDAOFactory(String userName, String userPassword, String driverName) {
		super(userName, userPassword, driverName);
	}

	public Connection getConnection() throws DBException {
		try {
			Class.forName(DB_DRIVER);
			return DriverManager.getConnection(dbURL, userName, userPassword);
		} catch (ClassNotFoundException ex) {
			throw new DBException(String.format("MS SQL DB driver not found: %1$s", ex.getMessage()));
		} catch (SQLException ex) {
			throw new DBException(String.format("DB connection cannont be retrieved: %1$s", ex.getMessage()));
		}
	}

	@Override
	public void returnConnection(Connection connection) throws DBException {
		try {
			connection.close();
		} catch (SQLException ex) {
			throw new DBException(String.format("Connection cannot be closed: %1$s", ex.getMessage()));
		}
	}

	@Override
	public IBaseDao<UserVO> getUserDAO() {
		return new MSSqlUserDAO();
	}

	@Override
	public IBaseDao<RoleVO> getRoleDAO() {
		return new MSSqlRoleDAO();
	}

	@Override
	public IManyToManyDAO<GroupVO> getGroupDAO() {
		return new MSSqlGroupDAO();
	}

}
