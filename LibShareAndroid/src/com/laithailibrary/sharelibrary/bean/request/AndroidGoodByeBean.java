package com.laithailibrary.sharelibrary.bean.request;

import com.laithailibrary.sharelibrary.bean.request.support.*;
import com.laithailibrary.sharelibrary.exception.*;
import com.laithailibrary.sharelibrary.session.*;

public class AndroidGoodByeBean extends AndroidRequest {

	private static final long serialVersionUID = 1;

	public AndroidGoodByeBean() {}

	public AndroidGoodByeBean(ANDSessionData p_sessiondata) throws ANDException {
		super(AndroidRequestHeader.GOODBYE, "SayGoodbye");

		setANDSessionData(p_sessiondata);
	}
}
