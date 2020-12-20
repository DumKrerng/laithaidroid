package com.laithailibrary.sharelibrary.bean.request;

import com.laithailibrary.sharelibrary.bean.request.support.*;
import com.laithailibrary.sharelibrary.exception.*;

public class AndroidHelloBean extends AndroidRequest {

	private static final String MAC = "MAC";

	private static final long serialVersionUID = 1;

	public AndroidHelloBean() {}

	public AndroidHelloBean(String p_strMAC) throws ANDException {
		super(AndroidRequestHeader.HELLO, "SayHello");

		try {
			addObject(MAC, p_strMAC);

		} catch(Exception exception) {
		  throw new ANDException(exception);
		}
	}

	public String getMAC() throws ANDException {
		return (String)getObject(MAC);
	}
}
