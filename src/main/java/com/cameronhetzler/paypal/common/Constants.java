package com.cameronhetzler.paypal.common;

import java.util.LinkedList;
import java.util.List;

public class Constants {
	
	// Meta
	public static final String NULL = "";

	// Connection helpers
	public static final String ENVIRONMENT = "ENV";
	public static final String SANDBOX = "sandbox";
	public static final String LIVE = "live";
	public static final String CLIENT_ID = "clientid";
	public static final String CLIENT_SECRET = "clientsecret";
	public static final String ROOT_DIR = "root_dir";

	// Flow helpers
	public static final String CLASSIFICATION = "classification";
	public static final String SERVICE = "service";

	// Spec helpers
	public static final String USD = "USD";

	// File helpers
	public static final String JSON = ".json";
	public static final String CURRENCY_FILE = "currency_";
	public static final String BILLINGINFO_FILE = "billinginfo_";
	public static final String MERCHANTINFO_FILE = "merchantinfo_";
	public static final String TAX_FILE = "tax_";
	public static final String ITEM_FILE = "item_";
	public static final String INVOICE_FILE = "invoice_";
	public static final String PAYMENTMENTDEFINITION_FILE = "paymentdefinition_";

	// Folder helpers
	public static final String INVOICE_FOLDER = "/invoices";
	public static final String CURRENCY_FOLDER = "/currencies";
	public static final String TAX_FOLDER = "/taxes";
	public static final String BILLINGINFO_FOLDER = "/billinginfos";
	public static final String ITEM_FOLDER = "/items";
	
	// Properties
	public static final String HOSTNAME = "hostname";
	public static final String PORT = "port";
	public static final String DB_NAME = "dbname";
	public static final String USERID = "user";
	public static final String PWORD = "pword";

	public static final List<PayPalSpecs> PayPalSpecs = new LinkedList<PayPalSpecs>();
	public static final List<Services> SupportedServices = new LinkedList<Services>();
	
	// Files
	private static String formatFileDir(String dir, String filename, String meta, String ext) {
		if (ALTERNATE_DIR == FS_TYPE.CURR_DIR)
			return filename + meta + ext;
		else if (ALTERNATE_DIR == FS_TYPE.ROOT_DIR)
			return dir + filename + meta + ext;
		else if (ALTERNATE_DIR == FS_TYPE.EXT_DIR)
			return FS_PAR_DIR + dir + filename + meta + ext;
		return NULL;
	}
	public static String PROP_FILE() {
		return formatFileDir(FS_DIR_IN, PROP_FILE, NULL, FS_EXT_PROP);
	}
	
	// File Names
	public static final String PROP_FILE = "config";
	
	// File Directories
	public static final String FS_DIR_IN = "input/";
	public static final String FS_DIR_OUT = "output/";
	public static final String FS_DIR_LOG = "log/";
	public static final String FS_PAR_DIR = "../";
	public static final String FS_CUR_DIR = "./";
	public static enum FS_TYPE {
		CURR_DIR, ROOT_DIR, EXT_DIR
	}
	public static boolean CHANGE_DIR_TYPE() {
		if (ALTERNATE_DIR == FS_TYPE.CURR_DIR) {
			ALTERNATE_DIR = FS_TYPE.ROOT_DIR;
			return true;
		} else if (ALTERNATE_DIR == FS_TYPE.ROOT_DIR) {
			ALTERNATE_DIR = FS_TYPE.EXT_DIR;
			return true;
		} else if (ALTERNATE_DIR == FS_TYPE.EXT_DIR) {
			ALTERNATE_DIR = FS_TYPE.CURR_DIR;
			return false;
		}
		return false;
	}
	
	// File Extensions
	private static FS_TYPE ALTERNATE_DIR = FS_TYPE.CURR_DIR;
	public static final String FS_EXT_PROPERTIES = ".properties";
	public static final String FS_EXT_PROP = FS_EXT_PROPERTIES;
	public static final String FS_EXT_CSV = ".csv";
	public static final String FS_EXT_LOG = ".log";
	public static final String FS_EXT_ERROR = ".error";
	public static final String FS_EXT_COMPLETED = ".completed";
	public static final String FS_EXT_COMPLETE = FS_EXT_COMPLETED;
	public static final String FS_EXT_COMP = FS_EXT_COMPLETED;
	public static final String FS_EXT_ERR = FS_EXT_ERROR;
	public static final String FS_EXT_OPT = ".opt";
	public static final String FS_IN = "IN";
	public static final String FS_OUT = "OUT";
	public static final String FS_LOG = "LOG";
}
