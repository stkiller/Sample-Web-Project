package com.example.dal.dataaccess;

import java.util.List;

import com.example.dal.exceptions.DBException;
import com.example.dal.valueobject.GroupVO;
import com.example.dal.valueobject.RoleVO;
import com.example.dal.valueobject.UserVO;

public interface IAccessManager {

	/**
	 * 
	 * @return a list of {@link UserVO} from the used DB
	 * @throws DBException
	 */
	public abstract List<UserVO> retrieveUsers() throws DBException;

	/**
	 * 
	 * @return a list of {@link UserVO} with filled groups
	 * @throws DBException
	 */
	public abstract List<UserVO> retrieveUsersWithGroups() throws DBException;

	/**
	 * Retrieves the {@link UserVO} with specified ID
	 * 
	 * @param id
	 *            - id of target user
	 * @return {@link UserVO}
	 * @throws DBException
	 */
	public abstract UserVO retrieveUser(Long id) throws DBException;

	/**
	 * Retrieves the {@link UserVO} with {@link GroupVO} filled
	 * 
	 * @param id
	 *            - id of target user
	 * @return {@link UserVO} with {@link GroupVO} filled
	 * @throws DBException
	 */
	public abstract UserVO retrieveUserWithGroup(Long id) throws DBException;

	/**
	 * Writes the specified {@link UserVO}
	 * 
	 * @param userVO
	 *            - {@link UserVO} that should be written to the DB
	 * @return the id of written user.
	 * @throws DBException
	 */
	public abstract long writeUser(UserVO userVO) throws DBException;

	/**
	 * Removes the specified {@link UserVO}
	 * 
	 * @param user
	 *            - {@link UserVO} that should be deleted
	 * @return true if the user was successfully deleted, false otherwise
	 * @throws DBException
	 */
	public abstract boolean removeUser(UserVO user) throws DBException;

	/**
	 * Retrieves a list of {@link GroupVO}
	 * 
	 * @return List of {@link GroupVO}
	 * @throws DBException
	 */
	public abstract List<GroupVO> retrieveGroups() throws DBException;

	/**
	 * Retrieves the {@link GroupVO} with specified groupID
	 * 
	 * @param id
	 *            - the id of target {@link GroupVO}
	 * @return {@link GroupVO} if such a group is presented, null otherwise
	 * @throws DBException
	 */
	public abstract GroupVO retrieveGroup(Long id) throws DBException;

	/**
	 * Write the specified {@link GroupVO}
	 * 
	 * @param group
	 *            - {@link GroupVO} object that should be written
	 * @return the id of written {@link GroupVO}
	 * @throws DBException
	 */
	public abstract long writeGroup(GroupVO group) throws DBException;

	/**
	 * Remove the specified {@link GroupVO} object
	 * 
	 * @param group
	 *            - {@link GroupVO} object that should be removed from the DB
	 * @return true if the object was successfully removed, false otherwise
	 * @throws DBException
	 */
	public abstract boolean removeGroup(GroupVO group) throws DBException;

	/**
	 * Retrieves a list of {@link RoleVO} objects with associated groups
	 * 
	 * @return a list of {@link RoleVO} objects
	 * @throws DBException
	 */
	public abstract List<RoleVO> retrieveRoles() throws DBException;

	/**
	 * Retrieves a single {@link RoleVO} object with associated groups
	 * 
	 * @param id
	 *            - id of target {@link RoleVO} object
	 * @return the target {@link RoleVO} object, if it's found, null otherwise
	 * @throws DBException
	 */
	public abstract RoleVO retrieveRole(Long id) throws DBException;

	/**
	 * Writes {@link RoleVO} and associated {@link GroupVO} objects
	 * 
	 * @param {@link RoleVO} that should be written
	 * @return the id of written {@link RoleVO} object
	 * @throws DBException
	 */
	public abstract long writeRole(RoleVO role) throws DBException;

	/**
	 * Remove the specified {@link RoleVO} object
	 * 
	 * @param role
	 *            - {@link RoleVO} object that should be removed
	 * @return true is the target object is deleted successfully, false
	 *         otherwise
	 * @throws DBException
	 */
	public abstract boolean removeRole(RoleVO role) throws DBException;

}