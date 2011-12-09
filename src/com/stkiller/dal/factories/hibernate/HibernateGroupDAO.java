package com.example.dal.factories.hibernate;

import com.example.dal.dao.IManyToManyDAO;
import com.example.dal.valueobject.GroupVO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Andrei Podoprigora
 * Date: 05/12/11
 * Time: 18:21
 */
public class HibernateGroupDAO implements IManyToManyDAO<GroupVO>{
    @Override
    public List<Long> getDependentsIDs(GroupVO owner, Connection connection) throws SQLException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean removeDependent(GroupVO owner, Long dependentID, Connection connection) throws SQLException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean addDependent(GroupVO owner, Long dependentID, Connection connection) throws SQLException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<GroupVO> retrieve(Connection connection) throws SQLException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public GroupVO retrieve(long id, Connection connection) throws SQLException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean update(GroupVO item, Connection connection) throws SQLException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean delete(GroupVO item, Connection connection) throws SQLException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long insert(GroupVO item, Connection connection) throws SQLException {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
