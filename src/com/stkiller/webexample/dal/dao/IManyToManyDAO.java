package com.stkiller.webexample.dal.dao;


import com.stkiller.webexample.dal.valueobject.ValueObject;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IManyToManyDAO<T extends ValueObject> extends IBaseDao<T> {
	// public static final String GET_DEPENDENTS =
	// "select %1$s from %2$s where %3$s";
	// public static final String ADD_DEPENDENT =
	// "insert into %1$s values %2$s";
	// public static final String REMOVE_DEPENDENT =
	// "delete from %1$s where %2$s";

	/**
	 * 
	 * @param owner
	 *            - entry that owns the requested relationships
	 * @param connection
	 *            - connection that should be used for accessing the DB
	 * @return the list of IDs of dependents.
	 * @throws SQLException
	 */
	public List<Long> getDependentsIDs(T owner, Connection connection) throws SQLException;

	/**
	 * 
	 * @param owner
	 *            - entry that owns the requested relationships
	 * @param dependentID
	 *            - id of dependent that should be deleted from the DB
	 * @param connection
	 *            - connection that should be used for accessing the DB
	 * @return true if the relation was successfully removed, false otherwise
	 * @throws SQLException
	 */
	public boolean removeDependent(T owner, Long dependentID, Connection connection) throws SQLException;

	/**
	 * 
	 * @param owner
	 *            - entry that owns the requested relationships
	 * @param dependentID
	 *            - id of dependent that should be added to the DB
	 * @param connection
	 *            - connection that should be used for accessing the DB
	 * @return true if the dependent was successfully added, false otherwise
	 * @throws SQLException
	 */
	public boolean addDependent(T owner, Long dependentID, Connection connection) throws SQLException;
}
