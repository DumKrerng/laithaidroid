package com.laithailibrary.sharelibrary.exception;

public class ANDException extends Exception {

	private String m_strMessage;
	private Throwable m_throwable;

	private static final long serialVersionUID = 2;

	public ANDException(String p_strMessage, Throwable p_throwable) {
		super(p_strMessage, p_throwable, false, true);

		m_strMessage = p_strMessage;
		m_throwable = p_throwable;

		m_throwable.printStackTrace();
	}

	public ANDException(String p_strMessage) {
		super(p_strMessage);

		m_strMessage = p_strMessage;

		printStackTrace();
	}

	public ANDException(Exception p_exception) {
		super(p_exception.getMessage(), p_exception.getCause(), false, true);

		m_strMessage = p_exception.getMessage();
		m_throwable = p_exception.getCause();
	}
}
