package com.cameronhetzler.paypal.common;

import java.util.LinkedList;
import java.util.List;

public class Constants {

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
	
	public static final List<PayPalSpecs> PayPalSpecs = new LinkedList<PayPalSpecs>();
	public static final List<Services> SupportedServices = new LinkedList<Services>();
}
