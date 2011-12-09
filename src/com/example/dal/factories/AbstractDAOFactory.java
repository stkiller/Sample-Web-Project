/**
 * 
 */
package com.example.dal.factories;

import com.example.dal.dao.IBaseDao;
import com.example.dal.dao.IManyToManyDAO;
import com.example.dal.exceptions.DBException;
import com.example.dal.exceptions.NoSuchFactoryException;
import com.example.dal.factories.hibernate.HibernateDaoFactory;
import com.example.dal.factories.ms_sql.MSSqlDAOFactory;
import com.example.dal.factories.postgre.PostgreDAOFactory;
import com.example.dal.valueobject.GroupVO;
import com.example.dal.valueobject.RoleVO;
import com.example.dal.valueobject.UserVO;

import java.sql.Connection;

/**
 * @author stkiller
 * 
 */
public abstract class AbstractDAOFactory {

	protected String userName;
	protected String userPassword;
	protected String dbURL;

	protected AbstractDAOFactory(String userName, String userPassword, String driverName) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.dbURL = driverName;
	}

	/**
	 * 
	 * @return IBaseDao<UserVO> DAO that works with specific DB
	 */
	public abstract IBaseDao<UserVO> getUserDAO();

	/**
	 * 
	 * @return IManyToManyDAO<RoleVO> DAO that works with specific DB
	 */
	public abstract IBaseDao<RoleVO> getRoleDAO();

	/**
	 * 
	 * @return IManyToManyDAO<GroupVO> DAO that works with specific DB
	 */
	public abstract IManyToManyDAO<GroupVO> getGroupDAO();

	/**
	 * 
	 * @return Connection object that can be used to access specific DB
	 * @throws DBException
	 */
	public abstract Connection getConnection() throws DBException;

	/**
	 * Returns the connection that should be closed or re-enqueued in queue of
	 * used connection
	 * 
	 * @param connection
	 *            - the target connection
	 * @throws DBException
	 */
	public abstract void returnConnection(Connection connection) throws DBException;

	/**
	 * 
	 * @param DAOType
	 *            - the type of DB the DAOFactory should work
	 * @param userName
	 *            - user name to access the DB
	 * @param userPassword
	 *            - user password to access the DB
	 * @param dbURL
	 *            - connection's URL to access the DB
	 * @return DAOFactory with specified parameters and DAOType
	 * @throws NoSuchFactoryException
	 */
	public static AbstractDAOFactory getFactory(DAOFactoryType DAOType, String userName, String userPassword,
			String dbURL) throws NoSuchFactoryException {
		switch (DAOType) {
			case POSTGRE: {
				return new PostgreDAOFactory(userName, userPassword, dbURL);
			}
			case MS_SQL:{
				return new MSSqlDAOFactory(userName, userPassword, dbURL);
			}
            case HIBERNATE:{
                return new HibernateDaoFactory(userName, userPassword, dbURL);
            }
			default:
				throw new NoSuchFactoryException(String.format("There is no such DAO factory: %1$s", DAOType));
		}
	}
}
