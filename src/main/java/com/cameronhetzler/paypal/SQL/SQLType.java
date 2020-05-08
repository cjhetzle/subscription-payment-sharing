package com.cameronhetzler.paypal.SQL;

public enum SQLType implements SQL {
	
	INSERT_INTO_SERVICES("INSERT INTO Services () VALUES (?);"),
	SELECT_ALL_FROM_PLANS("SELECT * FROM PLANS;"),
	SELECT_ALL_FROM_BILLINGCYCLES("SELECT * FROM BILLINGCYCLES;");
	
	private final SQL instance;
	
	SQLType(String sql) {
		this.instance = new SQLBase(this.name(), sql);
	}

	public String getSQL() {
		// TODO Auto-generated method stub
		return instance.getSQL();
	}

	public int getParameterCount() {
		// TODO Auto-generated method stub
		return instance.getParameterCount();
	}

	public String getName() {
		// TODO Auto-generated method stub
		return instance.getName();
	}
}
