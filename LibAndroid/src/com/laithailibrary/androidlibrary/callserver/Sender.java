package com.laithailibrary.androidlibrary.callserver;

import java.io.*;
import java.net.*;
import com.laithailibrary.androidlibrary.exception.*;
import com.laithailibrary.androidlibrary.ui.activity.*;
import com.laithailibrary.androidlibrary.ui.dialog.*;
import com.laithailibrary.androidlibrary.utilities.*;
import com.laithailibrary.sharelibrary.bean.request.*;
import com.laithailibrary.sharelibrary.bean.result.*;
import com.laithailibrary.sharelibrary.bean.result.support.*;
import com.laithailibrary.sharelibrary.session.*;

public class Sender {

	private IANDActivity m_activity;

	private static final int s_intTryLimit = 5;
	private static final int s_intTrySleep_Millisecond = 3000;

	private Sender() {}

	public Sender(IANDActivity p_activity) {
		m_activity = p_activity;
	}

	public void sendHelloToServer(String p_strMAC) {
		try {
			ANDLog.info("Sender", "Hello");

			AndroidHelloBean bean = new AndroidHelloBean(p_strMAC);

			Socket socket = AndroidUtilities.getSocket();
			OutputStream output = socket.getOutputStream();
			ObjectOutputStream objOutputStream = new ObjectOutputStream(output);
			objOutputStream.writeObject(bean);
			objOutputStream.flush();

			InputStream input = socket.getInputStream();
			ObjectInputStream objInputStream = new ObjectInputStream(input);
			ANDSessionData sessiondata = (ANDSessionData)objInputStream.readObject();

			AndroidUtilities.setANDSessionData(sessiondata);

			objOutputStream.close();
			objInputStream.close();

		} catch (Exception exception) {
			new ANDExceptionDialog(m_activity, exception);

		} finally {
			AndroidUtilities.closeSocket();
		}
	}

	public void sendGoodByeToServer(ANDSessionData p_sessiondata) {
		try {
			ANDLog.info("Sender", "Good Bye");

			AndroidGoodByeBean bean = new AndroidGoodByeBean(p_sessiondata);

			Socket socket = AndroidUtilities.getSocket();
			OutputStream output = socket.getOutputStream();
			ObjectOutputStream objOutputStream = new ObjectOutputStream(output);
			objOutputStream.writeObject(bean);
			objOutputStream.flush();

			objOutputStream.close();

		} catch (Exception exception) {
			ANDLog.severe("Sender : Good Bye", exception.getMessage());

		} finally {
			AndroidUtilities.closeSocket();
		}
	}

	public AndroidResult sendRequest(AndroidRequest p_request) {
		try {
			String strRequestName = p_request.getRequestName();

			ANDLog.info("Sender", strRequestName);

			p_request.setANDSessionData(AndroidUtilities.getANDSessionData());

			Socket socket = AndroidUtilities.getSocket();
			OutputStream output = socket.getOutputStream();
			ObjectOutputStream objOutputStream = new ObjectOutputStream(output);
			objOutputStream.writeObject(p_request);
			objOutputStream.flush();

			InputStream input = socket.getInputStream();
			ObjectInputStream objInputStream = new ObjectInputStream(input);
			Object objResult = objInputStream.readObject();

			objOutputStream.close();
			objInputStream.close();

			AndroidResult beanResult = new AndroidResult();

			if(!(objResult instanceof AndroidResult)) {
				beanResult.setRequestName(strRequestName);
				beanResult.setExceptionError("Bean result error!!!");

			} else {
				beanResult = (AndroidResult)objResult;

				if(beanResult.getHeader() == AndroidResultHeader.EXCEPTION_ERROR) {
					new ANDInfoDialog("Sender : " + p_request.getRequestName(), m_activity, beanResult.getMessage());
					ANDLog.severe("Sender : " + p_request.getRequestName(), beanResult.getMessage());
				}
			}

			return beanResult;

		} catch (Exception exception) {
			new ANDExceptionDialog(m_activity, exception);

		} finally {
			AndroidUtilities.closeSocket();
		}

		return new AndroidResult();
	}

	public AndroidResult sendRequest_NoneCloseSocket(AndroidRequest p_request) {
		try {
			String strRequestName = p_request.getRequestName();

			ANDLog.info("Sender", strRequestName);

			p_request.setANDSessionData(AndroidUtilities.getANDSessionData());

			Socket socket = AndroidUtilities.getSocket();
			OutputStream output = socket.getOutputStream();
			ObjectOutputStream objOutputStream = new ObjectOutputStream(output);
			objOutputStream.writeObject(p_request);
			objOutputStream.flush();

			InputStream input = socket.getInputStream();
			ObjectInputStream objInputStream = new ObjectInputStream(input);
			Object objResult = objInputStream.readObject();

			objOutputStream.close();
			objInputStream.close();

			AndroidResult beanResult = new AndroidResult();

			if(!(objResult instanceof AndroidResult)) {
				beanResult.setRequestName(strRequestName);
				beanResult.setExceptionError("Bean result error!!!");

			} else {
				beanResult = (AndroidResult)objResult;

				if(beanResult.getHeader() == AndroidResultHeader.EXCEPTION_ERROR) {
					new ANDInfoDialog("Sender : " + p_request.getRequestName(), m_activity, beanResult.getMessage());
					ANDLog.severe("Sender : " + p_request.getRequestName(), beanResult.getMessage());
				}
			}

			return beanResult;

		} catch (Exception exception) {
			new ANDExceptionDialog(m_activity, exception);
		}

		return new AndroidResult();
	}
}
