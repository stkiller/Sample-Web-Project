package com.example.dal.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.example.dal.valueobject.ValueObject;

public interface IBaseDao<T extends ValueObject> {
	// String SELECT_ALL = "select * from %1$s";
	// String SELECT = "select * from %1$s where id=%2$d";
	// String UPDATE = "update %1$s set %2$s where id=%3$d";
	// String DELETE = "delete from %1$s where id=%2$d";
	// String INSERT = "insert into %1$s values %2$s";

	/**
	 * 
	 * @param connection
	 *            - connection that should be used for accessing the DB
	 * @return the list of element that are stored in the table
	 * @throws SQLException
	 */
	public List<T> retrieve(Connection connection) throws SQLException;

	/**
	 * 
	 * @param id
	 *            - id of the element that should be retrieved
	 * @param connection
	 *            - connection that should be used for accessing the DB
	 * @return the item that has the specified id
	 * @throws SQLException
	 */
	public T retrieve(long id, Connection connection) throws SQLException;

	/**
	 * 
	 * @param item
	 *            - item that should be updated. All it's fields will be written
	 *            to the DB
	 * @param connection
	 *            - connection that should be used for accessing the DB
	 * @return true if any entry was updated, false otherwise
	 * @throws SQLException
	 */
	public boolean update(T item, Connection connection) throws SQLException;

	/**
	 * 
	 * @param item
	 *            - item that should be deleted.
	 * @param connection
	 *            - connection that should be used for accessing the DB
	 * @return true if any entry was deleted, false otherwise
	 * @throws SQLException
	 */
	public boolean delete(T item, Connection connection) throws SQLException;

	/**
	 * 
	 * @param item
	 *            - item that should be inserted in the DB
	 * @param connection
	 *            - connection that should be used for accessing the DB
	 * @return the id of inserted item.
	 * @throws SQLException
	 */
	public long insert(T item, Connection connection) throws SQLException;

}
