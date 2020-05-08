package com.cameronhetzler.paypal.SQL;

public interface SQL {
	public String getSQL();
	
	public int getParameterCount();
	
	public String getName();
}
