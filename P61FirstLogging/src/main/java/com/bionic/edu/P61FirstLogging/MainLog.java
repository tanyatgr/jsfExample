package com.bionic.edu.P61FirstLogging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainLog {
	private static final Logger log = LogManager.getLogger();

	public static void main(String[] args) {
		LogMethods obj = new LogMethods();
		obj.callLogging();
		if (log.isDebugEnabled()) {
			log.debug("Debug message from a main method");
		}

		try {
			obj.callException();
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}

		String text = obj.getTrace("test");
		if (log.isDebugEnabled()) {
			log.debug(text);
		}
		text = obj.getTrace("redivider");
		if (log.isDebugEnabled()) {
			log.debug(text);
		}

	}
}
