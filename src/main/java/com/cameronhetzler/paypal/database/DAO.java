package com.cameronhetzler.paypal.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.SQL.SQL;
import com.cameronhetzler.paypal.common.Constants;
import com.cameronhetzler.paypal.result.Result;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class DAO {
	
	static final Logger LOGGER = Logger.getLogger(DAO.class.getPackageName());
	
	/**
	 * 
	 * @param externalAppender
	 */
	public static void setAppender(Appender externalAppender) {
		LOGGER.removeAllAppenders();
		LOGGER.addAppender(externalAppender);
	}
	
	public static Connection getConnection() {
		return getConnection("jdbc:mysql://192.168.1.2:3306");
	}
	
	public static Connection getConnection(String url) {
		return getConnection(url, "testdb", "dbuser", "");
	}
	
	public static Connection getConnection(Properties info) {

		String url = "jdbc:mysql://" + info.getProperty(Constants.HOSTNAME) + ":" + info.getProperty(Constants.PORT);
		String dbname = info.getProperty(Constants.DB_NAME);
		String user = info.getProperty(Constants.USERID);
		String pword = info.getProperty(Constants.PWORD);
		
		return getConnection(url, dbname, user, pword);
	}
	
	public static Connection getConnection(String url, String dbname, String user, String password) {
		
		Connection conn = null;
		
		try {
			LOGGER.info("*** Connecting to " + url + "/" + dbname + " with user: " + user + " ***");
			conn = DriverManager.getConnection(url + "/" + dbname, user, password);
			
			if (conn == null) {
				throw new Exception();
			}
			LOGGER.info("DB connection success.");
		} catch (Exception e) {
			LOGGER.error("ERROR obtaining a connection to DB.");
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 
	 * @param dbProperties
	 * @param query
	 * @param updateParams
	 * @param generatedKeys
	 * @return
	 */
	public static Result executeUpdate(Properties dbProperties, SQL query,
			ArrayList<Object> updateParams, String[] generatedKeys) {
		return executeUpdate(getConnection(dbProperties), query, updateParams, generatedKeys);
	}
	
	/**
	 * 
	 * @param dbProperties
	 * @param query
	 * @param updateParams
	 * @param generatedKeys
	 * @return
	 */
	public static Result executeUpdate(Connection connection, SQL query,
			ArrayList<Object> updateParams, String[] generatedKeys) {
		Result result = new Result();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Map<Integer, Map<String, Object>> resultTable = null;
		
		try {
			
			LOGGER.info("Attempting to obtain connection...");
			
			if (connection != null) {
				LOGGER.info("Obtained connection.");
				
				if (generatedKeys != null) {
					preparedStatement = connection.prepareStatement(query.getSQL(), generatedKeys);
				} else {
					preparedStatement = connection.prepareStatement(query.getSQL());
				}
				
				LOGGER.info("SQL to update -> " + query);
				String params = "";
				for (Object listParam : updateParams) {
					params += listParam + ",";
				}
				LOGGER.info("SQL params -> " + params);
				
				int i = 1;
				
				for (Object param : updateParams) {
					if (param instanceof String) {
						preparedStatement.setString(i, (String)param);
					} else if (param instanceof Integer) {
						preparedStatement.setInt(i, (Integer)param);
					} else if (param instanceof Long) {
						preparedStatement.setLong(i, (Long)param);
					} else if (param instanceof Timestamp) {
						preparedStatement.setTimestamp(i, new Timestamp((Long)param));
					}
					++i;
				}
				
				LOGGER.info("Attempting to execute query...");
				preparedStatement.execute();
				LOGGER.info("Executed query.");
				
				LOGGER.info("Getting generated keys...");
				ResultSet insertedKeys = preparedStatement.getGeneratedKeys();
				
				if (insertedKeys != null) {
					
					LOGGER.info("Generated keys retrieved.");
					
					resultTable = new HashMap<Integer, Map<String, Object>>();
					int rowcnt = 0;
					Map<String, Object> colprop = new HashMap<String, Object>();
					
					while (insertedKeys.next()) {
						
						ResultSetMetaData metaData = insertedKeys.getMetaData();
						int colCount = metaData.getColumnCount();
						
						for (i = 1; i <= colCount; ++i) {
							
							String colName = metaData.getColumnLabel(i).toUpperCase();
							int type = metaData.getColumnType(i);
							
							switch (type) {
								case Types.VARCHAR:
									colprop.put(colName, insertedKeys.getString(i));
									break;
								case Types.INTEGER:
									colprop.put(colName, insertedKeys.getInt(i));
									break;
								case Types.BIGINT:
									colprop.put(colName, insertedKeys.getInt(i));
									break;
								case Types.TIMESTAMP:
									colprop.put(colName, insertedKeys.getTimestamp(i));
									break;
								default:
									colprop.put(colName, insertedKeys.getString(i));
									break;
							}
						}
						resultTable.put(rowcnt++, colprop);
					}
				} else {
					LOGGER.info("Generated keys [null]");
				}
			} else {
				LOGGER.error("Connection is null, Query cannot be executed: " + query);
				result.append("Connection is null, Query cannot be executed: " + query);
				result.error();
			}
		} catch (Exception e) {
			LOGGER.error("Exception occurred executing update query: " + query);
			result.append("Exception occurred executing update query: " + query);
			result.setThrowable(e);
			result.error();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;
				} catch (SQLException e) {
					LOGGER.error(e.getMessage(), e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				} catch (SQLException e) {
					LOGGER.error(e.getMessage(), e);
				}
			}
			if (connection != null) {
				try {
					connection.close();
					connection = null;
				} catch (SQLException e) {
					LOGGER.error(e.getMessage(), e);
				}
			}
		}
		LOGGER.info("Exiting with results.");
		result.success();
		result.setPayload(resultTable);
		return result;
	}
	
	/**
	 * 
	 * @param dbProperties
	 * @param query
	 * @param updateParams
	 * @return
	 */
	public static Result executeSelect(Properties dbProperties, SQL query,
			ArrayList<Object> updateParams) {
		
		return executeSelect(getConnection(dbProperties), query, updateParams);
	}
	
	/**
	 * 
	 * @param dbProperties
	 * @param query
	 * @param updateParams
	 * @return
	 */
	public static Result executeSelect(Connection connection, SQL query,
			ArrayList<Object> updateParams) {
		
		Result result = new Result();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<HashMap<String, Object>> resultRecords = new ArrayList<HashMap<String, Object>>();
		try {
			
			if (connection != null) {
				
				LOGGER.info("Obtained connection.");
				preparedStatement = connection.prepareStatement(query.getSQL());
				
				if (updateParams != null) {
					
					int i = 1;
					
					for (Object param : updateParams) {
						
						if (param instanceof String) {
							preparedStatement.setString(i, (String)param);
						} else if (param instanceof Integer) {
							preparedStatement.setInt(i, (Integer)param);
						} else if (param instanceof Long) {
							preparedStatement.setLong(i, (Long)param);
						} else if (param instanceof Timestamp) {
							preparedStatement.setTimestamp(i,  new Timestamp((Long)param));
						}
						++i;
					}
				}
				
				LOGGER.info("Attempting to execute query...");
				resultSet = preparedStatement.executeQuery();
				LOGGER.info("Executed query.");
				
				ResultSetMetaData metaData = resultSet.getMetaData();
				int colCount = metaData.getColumnCount();
				
				while (resultSet.next()) {
					
					HashMap<String, Object> resultRecord = new HashMap<String, Object>();
					
					for (int i = 1; i <= colCount; ++i) {
						
						String colName = metaData.getColumnLabel(i).toUpperCase();
						
						if (colName.contains(".")) {
							colName = colName.substring(colName.indexOf(".") + 1, colName.length());
						}
						
						int colType = metaData.getColumnType(i);
						
						switch (colType) {
							case Types.VARCHAR:
								resultRecord.put(colName, resultSet.getString(colName));
								break;
							case Types.INTEGER:
								resultRecord.put(colName, resultSet.getInt(colName));
								break;
							case Types.BIGINT:
								resultRecord.put(colName, resultSet.getInt(colName));
								break;
							case Types.TIMESTAMP:
								resultRecord.put(colName, resultSet.getTimestamp(colName));
								break;
							default:
								resultRecord.put(colName, resultSet.getString(colName));
								break;
						}
						
					}
					resultRecords.add(resultRecord);
				} 
			} else {
				LOGGER.error("Connection is null, Query cannot be executed: " + query);
				result.append("Connection is null, Query cannot be executed: " + query);
				result.error();
			}
		} catch (Exception e) {
			LOGGER.error("Exception occurred executing update query: " + query);
			result.append("Exception occurred executing update query: " + query);
			result.setThrowable(e);
			result.error();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;
				} catch (SQLException e) {
					LOGGER.error(e.getMessage(), e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				} catch (SQLException e) {
					LOGGER.error(e.getMessage(), e);
				}
			}
			if (connection != null) {
				try {
					connection.close();
					connection = null;
				} catch (SQLException e) {
					LOGGER.error(e.getMessage(), e);
				}
			}
		}
		LOGGER.info("Exiting with results.");
		result.success();
		result.setPayload(resultRecords);
		return result;
	}
}
