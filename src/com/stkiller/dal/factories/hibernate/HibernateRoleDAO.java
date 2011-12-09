package com.example.dal.factories.hibernate;

import com.example.dal.dao.IManyToManyDAO;
import com.example.dal.valueobject.RoleVO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Andrei Podoprigora
 * Date: 05/12/11
 * Time: 18:22
 */
public class HibernateRoleDAO implements IManyToManyDAO<RoleVO>{
    @Override
    public List<Long> getDependentsIDs(RoleVO owner, Connection connection) throws SQLException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean removeDependent(RoleVO owner, Long dependentID, Connection connection) throws SQLException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean addDependent(RoleVO owner, Long dependentID, Connection connection) throws SQLException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<RoleVO> retrieve(Connection connection) throws SQLException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public RoleVO retrieve(long id, Connection connection) throws SQLException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean update(RoleVO item, Connection connection) throws SQLException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean delete(RoleVO item, Connection connection) throws SQLException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long insert(RoleVO item, Connection connection) throws SQLException {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
