package com.stkiller.webexample.dal.factories.hibernate;

import com.stkiller.webexample.dal.dataaccess.IAccessManager;
import com.stkiller.webexample.dal.exceptions.DBException;
import com.stkiller.webexample.dal.valueobject.GroupVO;
import com.stkiller.webexample.dal.valueobject.RoleVO;
import com.stkiller.webexample.dal.valueobject.UserVO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Andrei Podoprigora
 * Date: 12/12/11
 * Time: 18:43
 */
public class HibernateAccessManager implements IAccessManager {

    private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public List<UserVO> retrieveUsers() throws DBException {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            List<UserVO> result = session.createQuery("from UserVO ").list();
            transaction.commit();
            return result;
        } catch (HibernateException ex) {
            transaction.rollback();
            throw new DBException(ex);
        }
        finally{
            session.close();
        }
    }

    @Override
    public List<UserVO> retrieveUsersWithGroups() throws DBException {
        return retrieveUsers();
    }

    @Override
    public UserVO retrieveUser(Long id) throws DBException {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            UserVO userVO = (UserVO) session.createQuery("from UserVO where id=" + id).uniqueResult();
            transaction.commit();
            return userVO;
        } catch (HibernateException ex) {
            transaction.rollback();
            throw new DBException(ex);
        }
        finally{
            session.close();
        }
    }

    @Override
    public UserVO retrieveUserWithGroup(Long id) throws DBException {
        return retrieveUser(id);
    }

    @Override
    public long writeUser(UserVO user) throws DBException {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(user);
            transaction.commit();
            return user.getId();
        } catch (HibernateException ex) {
            transaction.rollback();
            throw new DBException(ex);
        }
        finally{
            session.close();
        }
    }

    @Override
    public boolean removeUser(UserVO user) throws DBException {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(user);
            transaction.commit();
            return true;
        } catch (HibernateException ex) {
            transaction.rollback();
            throw new DBException(ex);
        }
        finally{
            session.close();
        }
    }

    @Override
    public List<GroupVO> retrieveGroups() throws DBException {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            List<GroupVO> groups = getSession().createQuery("from GroupVO ").list();
            transaction.commit();
            return groups;
        } catch (HibernateException ex) {
            transaction.rollback();
            throw new DBException(ex);
        }
        finally{
            session.close();
        }
    }

    @Override
    public GroupVO retrieveGroup(Long id) throws DBException {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            GroupVO group = (GroupVO) getSession().createQuery("from GroupVO where id=" + id).uniqueResult();
            transaction.commit();
            return group;
        } catch (HibernateException ex) {
            transaction.rollback();
            throw new DBException(ex);
        }
        finally{
            session.close();
        }
    }

    @Override
    public long writeGroup(GroupVO group) throws DBException {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(group);
            transaction.commit();
            return group.getId();
        } catch (HibernateException ex) {
            transaction.rollback();
            throw new DBException(ex);
        }
        finally{
            session.close();
        }
    }

    @Override
    public boolean removeGroup(GroupVO group) throws DBException {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(group);
            transaction.commit();
            return true;
        } catch (HibernateException ex) {
            transaction.rollback();
            throw new DBException(ex);
        }
        finally{
            session.close();
        }
    }

    @Override
    public List<RoleVO> retrieveRoles() throws DBException {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            List<RoleVO> roles = getSession().createQuery("from RoleVO ").list();
            transaction.commit();
            return roles;
        } catch (HibernateException ex) {
            transaction.rollback();
            throw new DBException(ex);
        }
        finally{
            session.close();
        }
    }

    @Override
    public RoleVO retrieveRole(Long id) throws DBException {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            RoleVO role = (RoleVO) getSession().createQuery("from RoleVO where id=" + id).uniqueResult();
            transaction.commit();
            return role;
        } catch (HibernateException ex) {
            transaction.rollback();
            throw new DBException(ex);
        }
        finally{
            session.close();
        }
    }

    @Override
    public long writeRole(RoleVO role) throws DBException {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(role);
            transaction.commit();
            return role.getId();
        } catch (HibernateException ex) {
            transaction.rollback();
            throw new DBException(ex);
        }
        finally{
            session.close();
        }
    }

    @Override
    public boolean removeRole(RoleVO role) throws DBException {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(role);
            transaction.commit();
            return true;
        } catch (HibernateException ex) {
            transaction.rollback();
            throw new DBException(ex);
        }
        finally{
            session.close();
        }
    }
}