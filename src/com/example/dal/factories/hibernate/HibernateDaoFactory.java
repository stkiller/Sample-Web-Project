package com.example.dal.factories.hibernate;

import com.example.dal.dao.IBaseDao;
import com.example.dal.dao.IManyToManyDAO;
import com.example.dal.exceptions.DBException;
import com.example.dal.factories.AbstractDAOFactory;
import com.example.dal.valueobject.GroupVO;
import com.example.dal.valueobject.RoleVO;
import com.example.dal.valueobject.UserVO;

import java.sql.Connection;

/**
 * Created by IntelliJ IDEA.
 * User: Andrei Podoprigora
 * Date: 05/12/11
 * Time: 18:19
 */
public class HibernateDaoFactory extends AbstractDAOFactory{
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
