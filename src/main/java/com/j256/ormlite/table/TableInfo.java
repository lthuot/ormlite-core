package com.j256.ormlite.table;

import java.sql.SQLException;

import com.j256.ormlite.field.FieldType;

/**
 * Interface representing information about a database table including the associated tableName, class, constructor, and the included fields.
 * 
 * @param <T>
 *            The class that the code will be operating on.
 * @param <ID>
 *            The class of the ID column associated with the class. The T class does not require an ID field. The class
 *            needs an ID parameter however so you can use Void or Object to satisfy the compiler.
 * @author luct (extracted from TableInfoImpl)
 */
public interface TableInfo<T, ID> {
	/**
	 * Return the name of the table associated with the object.
	 */
	String getTableName();
	/**
	 * Return the {@link FieldType} associated with the columnName.
	 */
	FieldType getFieldTypeByColumnName(String columnName);
	/**
	 * Return the class associated with this object-info.
	 */
	Class<T> getDataClass();
	/**
	 * Return the array of field types associated with the object.
	 */
	FieldType[] getFieldTypes();
	/**
	 * Return the id-field associated with the object.
	 */
	FieldType getIdField();
	/**
	 * Create and return an object of this type using our reflection constructor.
	 */
	T createObject() throws SQLException;
	/**
	 * Return true if one of the fields has {@link DatabaseField#foreignAutoCreate()} enabled.
	 */
	boolean isForeignAutoCreate();
	/**
	 * Return an array with the fields that are {@link ForeignCollection}s or a blank array if none.
	 */
	FieldType[] getForeignCollections();
}
