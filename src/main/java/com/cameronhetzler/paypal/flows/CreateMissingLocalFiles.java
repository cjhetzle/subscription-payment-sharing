package com.cameronhetzler.paypal.flows;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.common.Constants;
import com.cameronhetzler.paypal.common.Services;
import com.cameronhetzler.paypal.exceptions.ServicesException;
import com.cameronhetzler.paypal.payload.Payload;
import com.cameronhetzler.paypal.result.Result;

public class CreateMissingLocalFiles extends ApplicationFlow {

	private static final String CLASSNAME = CreateMissingLocalFiles.class.getName();
	private static final String CLASSNAME_SIMPLE = CreateMissingLocalFiles.class.getSimpleName();
	private static final Logger LOGGER = Logger.getLogger(CLASSNAME);

	private String rootDir;

	public Logger getLogger() {
		// TODO Auto-generated method stub
		return LOGGER;
	}

	public String getClassName() {
		// TODO Auto-generated method stub
		return CLASSNAME;
	}

	public String getSimpleClassName() {

		return CLASSNAME_SIMPLE;
	}

	@Override
	protected Result parseAndSetElements(Payload request) {
		final String methodName = "parseAndSetElements";
		Long entryTime = entering(methodName, request);
		Result result = new Result(getSimpleClassName() + "." + methodName);

		result.append(super.parseAndSetElements(request));

		Map<String, Object> table = request.getTable();

		if (!table.containsKey(Constants.ROOT_DIR)) {
			table.put(Constants.ROOT_DIR, "./");
		}
		rootDir = (String) table.get(Constants.ROOT_DIR);
		result.append("Set rootDir to: " + rootDir);

		result.success();
		exiting(methodName, entryTime, result);
		return result;
	}

	@Override
	protected Result executeApplicationFlow(Payload request) throws ServicesException {
		final String methodName = "executeApplicationFlow";
		Long entryTime = entering(methodName, request);
		Result result = new Result(methodName);

		for (Services service : Constants.SupportedServices) {
			result.append(createLocalServiceFiles(rootDir, service));
		}

		exiting(methodName, entryTime, result);
		return result;
	}

	private Result createLocalServiceFiles(String rootDir, Services service) {
		final String methodName = "createLocalServiceFiles";
		Long entryTime = entering(methodName, rootDir, service);
		Result result = new Result(methodName);

		result.success();
		exiting(methodName, entryTime, result);
		return result;
	}

}
