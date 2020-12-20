package com.laithailibrary.sharelibrary.clientInfo;

import java.io.*;
import com.laithailibrary.sharelibrary.exception.*;
import com.laithailibrary.sharelibrary.session.*;

public class ANDClientInfo implements IClientInfo, Externalizable {

	private String m_strMAC = "";

	private static final long serialVersionUID = 1;

	public ANDClientInfo() {}

	public ANDClientInfo(String p_strMAC) throws ANDException {
		try {
			m_strMAC = p_strMAC;

		} catch (Exception exception) {
			throw new ANDException(exception);
		}
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		try {
			out.writeUTF(m_strMAC);

		} catch (Exception exception) {
			out.close();

			throw new IOException(exception);
		}
	}

	public void readExternal(ObjectInput in) throws IOException {
		try {
			m_strMAC = in.readUTF();

		} catch (Exception exception) {
			in.close();

			throw new IOException(exception);
		}
	}

	public String getMAC() {
		return m_strMAC;
	}
}
