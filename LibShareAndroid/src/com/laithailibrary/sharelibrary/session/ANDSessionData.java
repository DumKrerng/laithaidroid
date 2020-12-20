package com.laithailibrary.sharelibrary.session;

import java.io.*;
import com.laithailibrary.sharelibrary.clientInfo.*;
import com.laithailibrary.sharelibrary.exception.*;

public class ANDSessionData implements ISessionData, Externalizable {

	private ANDSessionID m_sessionid = null;
	private ANDClientInfo m_clientinfo = null;

	private String m_strProName = "";
	private String m_strProVer = "";

	private static final long serialVersionUID = 1;

	public ANDSessionData() {}

	public ANDSessionData(ANDSessionID p_sessionid, ANDClientInfo p_clientinfo, String p_strProName, String p_strProVer) {
		m_sessionid = p_sessionid;
		m_clientinfo = p_clientinfo;
		m_strProName = p_strProName;
		m_strProVer = p_strProVer;
	}

	public ANDSessionData(String p_strANDSessionID, String p_strMAC) throws ANDException {
		m_sessionid = new ANDSessionID(p_strANDSessionID);
		m_clientinfo = new ANDClientInfo(p_strMAC);
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		try {
			out.writeObject(m_sessionid);
			out.writeObject(m_clientinfo);
			out.writeUTF(m_strProName);
			out.writeUTF(m_strProVer);

		} catch (Exception exception) {
			out.close();

			throw new IOException(exception);
		}
	}

	public void readExternal(ObjectInput in) throws IOException {
		try {
			m_sessionid = (ANDSessionID)in.readObject();
			m_clientinfo = (ANDClientInfo)in.readObject();
			m_strProName = in.readUTF();
			m_strProVer = in.readUTF();

		} catch (Exception exception) {
			in.close();

			throw new IOException(exception);
		}
	}

	public ANDSessionID getANDSessionID() {
		return m_sessionid;
	}

	public ANDSessionID getSessionID() {
		return m_sessionid;
	}

	public ANDClientInfo getANDClientInfo() {
		return m_clientinfo;
	}

	public ANDClientInfo getClientInfo() {
		return m_clientinfo;
	}

	public String getProName() {
		return m_strProName;
	}

	public String getProVer() {
		return m_strProVer;
	}
}
