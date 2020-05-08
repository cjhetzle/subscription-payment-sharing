package com.cameronhetzler.paypal.SQL;

public class SQLBase implements SQL {

	private String sql;
	private String name;
	private int parameterCount;
	
	SQLBase(String name, String sql) {
		if (sql == null) {
			return;
		}
		this.sql = sql;
		this.parameterCount = sql.length() - sql.replace("?", "").length();
		this.name = name;
	}

	public String getSQL() {
		// TODO Auto-generated method stub
		return sql;
	}

	public int getParameterCount() {
		// TODO Auto-generated method stub
		return parameterCount;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}
