package com.laithailibrary.sharelibrary.bean.result;

import com.laithailibrary.sharelibrary.bean.*;
import com.laithailibrary.sharelibrary.bean.result.support.*;
import com.laithailibrary.sharelibrary.exception.*;

public class AndroidResult extends AndroidBean {

	private static final String HEADER = "@$HEADER$@";
	private static final String NAME = "@$NAME$@";
	private static final String MESSAGE = "@$MESSAGE$@";

	private static final long serialVersionUID = 1;

	public AndroidResult() {
		try {
			addObject(HEADER, AndroidResultHeader.UNSUCCESSFUL);

		} catch(Exception exception) {

		}
	}

	public AndroidResult(int p_intHeader) throws ANDException {
		try {
			addObject(HEADER, p_intHeader);

		} catch(Exception exception) {
			throw new ANDException(exception);
		}
	}

	public int getHeader() throws ANDException {
		return (Integer)getObject(HEADER);
	}

	public void setRequestName(String p_strMessage) throws ANDException {
		addObject(NAME, p_strMessage);
	}

	public String getRequestName() throws ANDException {
		return (String)getObject(NAME);
	}

	public void setMessage(String p_strMessage) throws ANDException {
		addObject(MESSAGE, p_strMessage);
	}

	public String getMessage() throws ANDException {
		if(hasObject(MESSAGE)) {
			return (String)getObject(MESSAGE);
		}

		return "";
	}

	public void setSuccessful(String p_strSuccessful) throws ANDException {
		addObject(HEADER, AndroidResultHeader.SUCCESSFUL);
		addObject(MESSAGE, p_strSuccessful);
	}

	public void setExceptionError(String p_strError) throws ANDException {
		addObject(HEADER, AndroidResultHeader.EXCEPTION_ERROR);
		addObject(MESSAGE, p_strError);
	}
}
