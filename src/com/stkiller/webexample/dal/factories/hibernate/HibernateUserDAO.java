package com.stkiller.webexample.dal.factories.hibernate;


import com.stkiller.webexample.dal.dao.IBaseDao;
import com.stkiller.webexample.dal.valueobject.UserVO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Andrei Podoprigora
 * Date: 05/12/11
 * Time: 18:22
 */
public class HibernateUserDAO implements IBaseDao<UserVO> {
    @Override
    public List<UserVO> retrieve(Connection connection) throws SQLException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UserVO retrieve(long id, Connection connection) throws SQLException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean update(UserVO item, Connection connection) throws SQLException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean delete(UserVO item, Connection connection) throws SQLException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long insert(UserVO item, Connection connection) throws SQLException {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
