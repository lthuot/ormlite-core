package com.j256.ormlite.field.types;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Arrays;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;

/**
 * Type that persists a byte[] object.
 * 
 * @author graywatson
 */
public class ByteArrayType extends BaseDataType {

	private static final ByteArrayType singleTon = new ByteArrayType();

	public static ByteArrayType getSingleton() {
		return singleTon;
	}

	private ByteArrayType() {
		super(SqlType.BYTE_ARRAY, new Class<?>[0]);
	}

	@Override
	public Object parseDefaultString(FieldType fieldType, String defaultStr) throws SQLException {
		throw new SQLException("byte[] type cannot have default values");
	}

	@Override
	public Object resultToJava(FieldType fieldType, DatabaseResults results, int columnPos) throws SQLException {
		return (byte[]) results.getBytes(columnPos);
	}

	@Override
	public Object javaToSqlArg(FieldType fieldType, Object javaObject) throws SQLException {
		// noop pass-thru
		return javaObject;
	}

	@Override
	public boolean isValidForField(Field field) {
		// by default this is a noop
		return true;
	}

	@Override
	public boolean isAppropriateId() {
		return false;
	}

	@Override
	public boolean isSelectArgRequired() {
		return true;
	}

	@Override
	public boolean dataIsEqual(Object fieldObj1, Object fieldObj2) {
		if (fieldObj1 == null) {
			return (fieldObj2 == null);
		} else if (fieldObj2 == null) {
			return false;
		} else {
			return Arrays.equals((byte[]) fieldObj1, (byte[]) fieldObj2);
		}
	}
}
