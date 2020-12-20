package com.laithailibrary.androidlibrary.exception;

public class ANDLog {

	private ANDLog() {}

	public static void info(String p_tag, String p_msg) {
		android.util.Log.i(p_tag, p_msg);
	}

	public static void severe(String p_tag, String p_msg) {
		android.util.Log.e(p_tag, p_msg);
	}

	public static void severe(String p_tag, String p_msg, Throwable p_throwable) {
		android.util.Log.e(p_tag, p_msg, p_throwable);
	}

	public static void severe(String p_tag, Throwable p_throwable) {
		android.util.Log.e(p_tag, p_throwable.getMessage(), p_throwable);
	}

	public static void print(String p_tag, String p_msg) {
		android.util.Log.v(p_tag, p_msg);
	}

	public static void debug(String p_tag, String p_msg) {
		android.util.Log.d(p_tag, p_msg);
	}

	public static void debug(String p_tag, String p_msg, Throwable p_throwable) {
		android.util.Log.d(p_tag, p_msg, p_throwable);
	}
}
