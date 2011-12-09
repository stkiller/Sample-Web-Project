package com.stkiller.webexample.bl.dataaccess;


import com.stkiller.webexample.bl.datavalidation.implementation.GroupValidator;
import com.stkiller.webexample.bl.datavalidation.implementation.RoleValidator;
import com.stkiller.webexample.bl.datavalidation.implementation.UserValidator;
import com.stkiller.webexample.bl.datavalidation.interfaces.IValidationResult;
import com.stkiller.webexample.bl.datavalidation.interfaces.IValidator;
import com.stkiller.webexample.bl.exceptions.DataRetrievalException;
import com.stkiller.webexample.bl.exceptions.DataWriteException;
import com.stkiller.webexample.bl.exceptions.ValidationException;
import com.stkiller.webexample.dal.dataaccess.AccessManager;
import com.stkiller.webexample.dal.dataaccess.IAccessManager;
import com.stkiller.webexample.dal.exceptions.DBException;
import com.stkiller.webexample.dal.exceptions.NoSuchFactoryException;
import com.stkiller.webexample.dal.factories.DAOFactoryType;
import com.stkiller.webexample.dal.valueobject.GroupVO;
import com.stkiller.webexample.dal.valueobject.RoleVO;
import com.stkiller.webexample.dal.valueobject.UserVO;
import org.apache.log4j.Logger;

import java.util.List;

public class BLAccessManager implements IBLAccessManager {

    private IAccessManager accessManager;
    private IValidator<UserVO> userValidator = new UserValidator();
    private IValidator<GroupVO> groupValidator = new GroupValidator();
    private IValidator<RoleVO> roleValidator = new RoleValidator();

    public BLAccessManager(DAOFactoryType dbType, String dbUser, String dbPass, String dbURL) {
        try {
            accessManager = new AccessManager(dbType, dbUser, dbPass, dbURL);
        } catch (NoSuchFactoryException e) {
            throw new RuntimeException(e);
        }
    }

    public List<UserVO> retrieveUsers() throws DataRetrievalException {
        try {
            return accessManager.retrieveUsers();
        } catch (DBException ex) {
            Logger.getLogger(getClass()).error("Error on retrieveUsers : ", ex);
            throw new DataRetrievalException(ex);
        }
    }

    public List<UserVO> retrieveUsersWithGroups() throws DataRetrievalException {
        try {
            return accessManager.retrieveUsersWithGroups();
        } catch (DBException ex) {
            Logger.getLogger(getClass()).error("Error on retrieveUsersWithGroups : ", ex);
            throw new DataRetrievalException(ex);
        }
    }

    public UserVO retrieveUser(Long id) throws DataRetrievalException {
        try {
            if (id == null || id < 0) {
                throw new DataRetrievalException("User's id cannot be null or negative !");
            }
            return accessManager.retrieveUser(id);
        } catch (DBException ex) {
            Logger.getLogger(getClass()).error("Error on retrieveUser : ", ex);
            throw new DataRetrievalException(ex);
        }
    }

    public UserVO retrieveUserWithGroup(Long id) throws DataRetrievalException {
        try {
            if (id == null || id < 0) {
                throw new DataRetrievalException("User's id cannot be null or negative !");
            }
            return accessManager.retrieveUserWithGroup(id);
        } catch (DBException ex) {
            Logger.getLogger(getClass()).error("Error on retrieveUserWithGroup : ", ex);
            throw new DataRetrievalException(ex);
        }
    }

    public long writeUser(UserVO userVO) throws ValidationException, DataWriteException {
        try {
            Logger.getLogger(getClass()).debug("Write user:" + userVO);
            IValidationResult result = userValidator.isValid(userVO);
            if (result.isInvalid()) {
                throw new ValidationException(result);
            }
            return accessManager.writeUser(userVO);
        } catch (DBException ex) {
            Logger.getLogger(getClass()).error("Error on writeUser : ", ex);
            throw new DataWriteException(ex);
        }
    }

    public boolean removeUser(UserVO userVO) throws ValidationException, DataWriteException {
        try {
            Logger.getLogger(getClass()).debug("Remove user:" + userVO);
            IValidationResult result = userValidator.isIdentityValid(userVO);
            if (result.isInvalid()) {
                throw new ValidationException(result);
            }
            return accessManager.removeUser(userVO);
        } catch (DBException ex) {
            Logger.getLogger(getClass()).error("Error on removeUser : ", ex);
            throw new DataWriteException(ex);
        }
    }

    public List<GroupVO> retrieveGroups() throws DataRetrievalException {
        try {
            return accessManager.retrieveGroups();
        } catch (DBException ex) {
            Logger.getLogger(getClass()).error("Error on retrieveGroups : ", ex);
            throw new DataRetrievalException(ex);
        }
    }

    public GroupVO retrieveGroup(Long id) throws DataRetrievalException {
        try {
            if (id == null || id < 0) {
                throw new DataRetrievalException("Group's id cannot be null or negative !");
            }
            return accessManager.retrieveGroup(id);
        } catch (DBException ex) {
            Logger.getLogger(getClass()).error("Error on retrieveGroup : ", ex);
            throw new DataRetrievalException(ex);
        }
    }

    public long writeGroup(GroupVO groupVO) throws ValidationException, DataWriteException {
        try {
            Logger.getLogger(getClass()).debug("Write group:" + groupVO);
            IValidationResult result = groupValidator.isValid(groupVO);
            if (result.isInvalid()) {
                throw new ValidationException(result);
            }
            return accessManager.writeGroup(groupVO);
        } catch (DBException ex) {
            Logger.getLogger(getClass()).error("Error on writeGroup : ", ex);
            throw new DataWriteException(ex);
        }
    }

    public boolean removeGroup(GroupVO groupVO) throws ValidationException, DataWriteException {
        try {
            Logger.getLogger(getClass()).debug("Remove group: "+groupVO);
            IValidationResult result = groupValidator.isIdentityValid(groupVO);
            if (result.isInvalid()) {
                throw new ValidationException(result);
            }
            return accessManager.removeGroup(groupVO);
        } catch (DBException ex) {
            Logger.getLogger(getClass()).error("Error on removeGroup : ", ex);
            throw new DataWriteException(ex);
        }
    }

    public List<RoleVO> retrieveRoles() throws DataRetrievalException {
        try {
            return accessManager.retrieveRoles();
        } catch (DBException ex) {
            Logger.getLogger(getClass()).error("Error on retrieveRoles : ", ex);
            throw new DataRetrievalException(ex);
        }
    }

    public RoleVO retrieveRole(Long id) throws DataRetrievalException {
        try {
            if (id == null || id < 0) {
                throw new DataRetrievalException("Role's id cannot be null or negative !");
            }
            return accessManager.retrieveRole(id);
        } catch (DBException ex) {
            Logger.getLogger(getClass()).error("Error on retrieveRole : ", ex);
            throw new DataRetrievalException(ex);
        }
    }

    public long writeRole(RoleVO roleVO) throws ValidationException, DataWriteException {
        try {
            Logger.getLogger(getClass()).debug("Write role: " + roleVO);
            IValidationResult result = roleValidator.isValid(roleVO);
            if (result.isInvalid()) {
                throw new ValidationException(result);
            }
            return accessManager.writeRole(roleVO);
        } catch (DBException ex) {
            Logger.getLogger(getClass()).error("Error on writeRole : ", ex);
            throw new DataWriteException(ex);
        }
    }

    public boolean removeRole(RoleVO roleVO) throws ValidationException, DataWriteException {
        try {
            Logger.getLogger(getClass()).debug("Remove role: " + roleVO);
            IValidationResult result = roleValidator.isIdentityValid(roleVO);
            if (result.isInvalid()) {
                throw new ValidationException(result);
            }
            return accessManager.removeRole(roleVO);
        } catch (DBException ex) {
            Logger.getLogger(getClass()).error("Error on removeRole : ", ex);
            throw new DataWriteException(ex);
        }
    }

}
