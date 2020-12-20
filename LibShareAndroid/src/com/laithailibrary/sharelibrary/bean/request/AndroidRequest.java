package com.laithailibrary.sharelibrary.bean.request;

import com.laithailibrary.sharelibrary.bean.*;
import com.laithailibrary.sharelibrary.exception.*;
import com.laithailibrary.sharelibrary.session.*;

public class AndroidRequest extends AndroidBean {

	private static final String HEADER = "@$HEADER$@";
	private static final String NAME = "@$NAME$@";
	private static final String ANDSESSIONDATA = "@$ANDSessionData$@";

	private static final long serialVersionUID = 1;

	public AndroidRequest() {}

	public AndroidRequest(int p_intHeader) throws ANDException {
		try {
			addObject(HEADER, p_intHeader);

		} catch(Exception exception) {
			throw new ANDException(exception);
		}
	}

	public AndroidRequest(int p_intHeader, String p_strRequestName) throws ANDException {
		try {
			addObject(HEADER, p_intHeader);
			addObject(NAME, p_strRequestName);

		} catch(Exception exception) {
			throw new ANDException(exception);
		}
	}

	public int getHeader() throws ANDException {
		return (Integer)getObject(HEADER);
	}

	public String getRequestName() {
		try {
			return (String)getObject(NAME);

		} catch(Exception exception) {
		}

		return "";
	}

	public void setANDSessionData(ANDSessionData p_sessiondata) throws ANDException {
		try {
			addObject(ANDSESSIONDATA, p_sessiondata);

		} catch(Exception exception) {
			throw new ANDException(exception);
		}
	}

	public ANDSessionData getANDSessionData() throws ANDException {
		return (ANDSessionData)getObject(ANDSESSIONDATA);
	}
}
