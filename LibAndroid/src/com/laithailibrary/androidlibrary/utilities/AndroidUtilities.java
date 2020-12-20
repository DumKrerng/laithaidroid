package com.laithailibrary.androidlibrary.utilities;

import com.laithailibrary.androidlibrary.exception.*;
import com.laithailibrary.sharelibrary.exception.*;
import com.laithailibrary.sharelibrary.session.*;
import java.net.*;

public class AndroidUtilities {

	private static String s_strServerAddress = "";
	private static int s_intServerPort = 0;
	private static int s_intSocketTimeout = 0;

	private static ANDSessionData s_sessiondata = null;

	private static Socket s_socket = null;
	private static SocketAddress s_address = null;

	private static final long serialVersionUID = 5;

	private AndroidUtilities() {}

	public static Socket getSocket() {
		try {
			if(s_socket == null) {
				s_socket = new Socket();
				s_address = new InetSocketAddress(s_strServerAddress, s_intServerPort);
			}

			if(s_socket.isClosed()) {
				s_socket = new Socket();
				s_socket.connect(s_address, s_intSocketTimeout);

			} else {
				if(!s_socket.isConnected()) {
					s_socket.connect(s_address, s_intSocketTimeout);
				}
			}

			return s_socket;

		} catch(Exception exception) {
			new ANDException(exception);
			ANDLog.severe("GetSocket", exception);
		}

		return null;
	}

	public static void closeSocket() {
		try {
			if(s_socket != null) {
				if(!s_socket.isClosed()) {
					s_socket.close();
				}
			}
		} catch(Exception exception) {
			new ANDException(exception);
		}
	}

	public static void setServerAddress(String p_strServerAddress, int p_intServerPort, int p_intSocketTimeout) {
		s_strServerAddress = p_strServerAddress;
		s_intServerPort = p_intServerPort;
		s_intSocketTimeout = p_intSocketTimeout;
	}

	public static void setServerAddress(String p_strServerAddress) {
		s_strServerAddress = p_strServerAddress;
	}

	public static String getServerAddress() {
		return s_strServerAddress;
	}

	public static void setServerPort(int p_intServerPort) {
		s_intServerPort = p_intServerPort;
	}

	public static int getServerPort() {
		return s_intServerPort;
	}
	
	public static void setSocketTimeout(int p_intSocketTimeout) {
		s_intSocketTimeout = p_intSocketTimeout;
	}

	public static int getSocketTimeout() {
		return s_intSocketTimeout;
	}

	public static void setANDSessionData(ANDSessionData p_sessiondata)  {
		s_sessiondata = p_sessiondata;
	}

	public static ANDSessionData getANDSessionData() {
		return s_sessiondata;
	}
}
