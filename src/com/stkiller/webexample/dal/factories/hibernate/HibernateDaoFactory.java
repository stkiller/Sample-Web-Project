package com.stkiller.webexample.dal.factories.hibernate;

import com.stkiller.webexample.dal.dao.IBaseDao;
import com.stkiller.webexample.dal.dao.IManyToManyDAO;
import com.stkiller.webexample.dal.exceptions.DBException;
import com.stkiller.webexample.dal.factories.AbstractDAOFactory;
import com.stkiller.webexample.dal.valueobject.GroupVO;
import com.stkiller.webexample.dal.valueobject.RoleVO;
import com.stkiller.webexample.dal.valueobject.UserVO;

import java.sql.Connection;

/**
 * Created by IntelliJ IDEA.
 * User: Andrei Podoprigora
 * Date: 05/12/11
 * Time: 18:19
 */
public class HibernateDaoFactory extends AbstractDAOFactory {
    public HibernateDaoFactory(String userName, String userPassword, String driverName) {
        super(userName, userPassword, driverName);
    }

    @Override
    public IBaseDao<UserVO> getUserDAO() {
        return new HibernateUserDAO();
    }

    @Override
    public IBaseDao<RoleVO> getRoleDAO() {
        return new HibernateRoleDAO();
    }

    @Override
    public IManyToManyDAO<GroupVO> getGroupDAO() {
        return new HibernateGroupDAO();
    }

    @Override
    public Connection getConnection() throws DBException {
        return null;
    }

    @Override
    public void returnConnection(Connection connection) throws DBException {
        //nothind to do;
    }
}
