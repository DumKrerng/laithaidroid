package com.laithailibrary.sharelibrary.bean;

import java.io.*;
import java.util.*;
import com.laithailibrary.sharelibrary.exception.*;

public class AndroidBean implements Externalizable {

	private Map<String, Object> m_mapObject_ObjectName = new TreeMap<>();

	private static final long serialVersionUID = 1;

	public AndroidBean() {}

	public void writeExternal(ObjectOutput p_out) throws IOException {
		try {
			p_out.writeObject(m_mapObject_ObjectName);

		} catch (Exception exception) {
			p_out.close();

			throw new IOException(exception);
		}
	}

	public void readExternal(ObjectInput p_in) throws IOException {
		try {
			m_mapObject_ObjectName = (Map<String, Object>)p_in.readObject();

		} catch (Exception exception) {
			p_in.close();

			throw new IOException(exception);
		}
	}

	public void addObject(String p_strObjectName, Object p_object) throws ANDException {
		try {
			m_mapObject_ObjectName.put(p_strObjectName, p_object);

		} catch (Exception exception) {
			throw new ANDException(exception);
		}
	}

	public boolean hasObject(String p_strObjectName) throws ANDException {
		if(m_mapObject_ObjectName.containsKey(p_strObjectName)) {
			return true;
		}

		return false;
	}

	public Object getObject(String p_strObjectName) throws ANDException {
		try {
			return m_mapObject_ObjectName.get(p_strObjectName);

		} catch (Exception exception) {
			throw new ANDException(exception);
		}
	}

	public boolean isInvalid() {
		if(m_mapObject_ObjectName.size() <= 0) {
			return true;
		}

		return false;
	}
}
