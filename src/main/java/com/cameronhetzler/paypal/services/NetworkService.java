package com.cameronhetzler.paypal.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.common.FileHelper;
import com.cameronhetzler.paypal.common.LoggingLayer;
import com.cameronhetzler.paypal.database.DAO;
import com.cameronhetzler.paypal.exceptions.NetworkCodes;
import com.cameronhetzler.paypal.exceptions.NetworkException;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class NetworkService extends LoggingLayer {
	
	private static Logger LOGGER = Logger.getLogger(NetworkService.class);

	protected Properties mainProperties = FileHelper.readPropertiesFile();
	protected Connection connection;
	
	public void open() throws NetworkException {
		
		if (connection != null) {
			
			throw new NetworkException("Connection already open.", NetworkCodes.OPEN_CONNECTION);
		}
		
		try {
			connection = DAO.getConnection(mainProperties);
		} catch (Exception e) {
			
		}
		
		try {
			connection.setAutoCommit(false);
		} catch (Exception e) {
			connection = null;
			throw new NetworkException("Could not set auto commit to false", NetworkCodes.AUTO_COMMIT);
		}
	}
	
	public void commit() throws NetworkException {
		
		if (connection == null) {
			// throw something
		}
		
		try {
			if (connection.isClosed()) {
				connection = null;
				// throw something
			}
		} catch (SQLException e) {
			connection = null;
			// throw something
		}
		
		try {
			connection.commit();
		} catch (SQLException e) {
			// throw something
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// log
			}
			connection = null;
		}
	}

	@Override
	protected String getClassName() {
		// TODO Auto-generated method stub
		return this.getClassName();
	}

	@Override
	protected String getSimpleClassName() {
		// TODO Auto-generated method stub
		return this.getSimpleClassName();
	}

	@Override
	protected Logger getLogger() {
		// TODO Auto-generated method stub
		return LOGGER;
	}
}
