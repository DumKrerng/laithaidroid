package com.laithailibrary.sharelibrary.session;

import java.io.*;
import com.laithailibrary.sharelibrary.exception.*;

public class ANDSessionID implements ISessionID, Comparable<ISessionID>, Externalizable {

	private String m_strSessionID = "";

	private static String APPTYPE = "Android";
	private String m_strSessionID_01 = "";
	private String m_strSessionID_02 = "";

	private int m_intSubNumber = 0;

	private static final long serialVersionUID = 3;

	public ANDSessionID() {}

	public ANDSessionID(String p_strSessionID) throws ANDException {
		try {
			m_strSessionID = p_strSessionID;

			String[] strSessionIDs = m_strSessionID.split("-");

			int index = 0;

			if(!p_strSessionID.startsWith(APPTYPE)) {
				m_strSessionID = APPTYPE + '-' + m_strSessionID;
			}

			for(String strTemp : strSessionIDs) {
				if(strTemp.compareTo(APPTYPE) != 0) {
					if(index == 1) {
						m_strSessionID_01 = strTemp;

					} else if(index == 2) {
						m_strSessionID_02 = strTemp;
					}
				}

				index++;
			}
		} catch (Exception exception) {
			throw new ANDException(exception);
		}
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		try {
			out.writeUTF(m_strSessionID);
			out.writeUTF(m_strSessionID_01);
			out.writeUTF(m_strSessionID_02);
			out.writeInt(m_intSubNumber);

		} catch (Exception exception) {
			out.close();

			throw new IOException(exception);
		}
	}

	public void readExternal(ObjectInput in) throws IOException {
		try {
			m_strSessionID = in.readUTF();
			m_strSessionID_01 = in.readUTF();
			m_strSessionID_02 = in.readUTF();
			m_intSubNumber = in.readInt();

		} catch (Exception exception) {
			in.close();

			throw new IOException(exception);
		}
	}

	public String getAppType() {
		return APPTYPE;
	}

	public String getSessionID() {
		return m_strSessionID;
	}

	public String getSessionID_01() {
		return m_strSessionID_01;
	}

	public String getSessionID_02() {
		return m_strSessionID_02;
	}

	public void incrementSubNumber() {
		m_intSubNumber++;
	}

	public String toString() {
		return m_strSessionID;
	}

	public int compareTo(ISessionID p_sessionid) {
		return this.toString().compareTo(p_sessionid.toString());
	}
}
