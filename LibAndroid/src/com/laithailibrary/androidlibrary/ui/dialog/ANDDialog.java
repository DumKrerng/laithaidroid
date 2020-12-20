package com.laithailibrary.androidlibrary.ui.dialog;

import android.app.*;
import com.laithailibrary.androidlibrary.exception.*;
import com.laithailibrary.androidlibrary.ui.activity.*;
import com.laithailibrary.androidlibrary.ui.dialog.support.*;

public class ANDDialog extends AlertDialog.Builder {

	private IANDActivity m_activity;
	private String m_strTitle = "";
	private String m_strMassage = "";
	private ANDDialogType m_dialogtype = ANDDialogType.Info;

	private AlertDialog m_showable = null;
	private Runnable m_runnable = null;

//	public boolean showing = false;

	public ANDDialog(IANDActivity p_activity, String p_strTitle, String p_strMessage, ANDDialogType p_dialogtype) {
		super(p_activity.getContextWrapper());

		try {
			m_activity = p_activity;
			m_strTitle = p_strTitle;
			m_strMassage = p_strMessage;
			m_dialogtype = p_dialogtype;

		  setTitle(p_strTitle);
		  setMessage(p_strMessage);

		} catch(Exception exception) {
			ANDLog.severe("", exception);
		}
	}

	public void buildDialog() {
		m_showable = super.create();
	}

	public AlertDialog getShowing() {
		if(m_showable == null) {
			buildDialog();
		}

		return m_showable;
	}

	public IANDActivity getANDActivity() {
		return m_activity;
	}

	public void setRunnable(Runnable p_runnable) {
		m_runnable = p_runnable;
	}

	public Runnable getRunnable() {
		return m_runnable;
	}

	public String getTitle() {
		return m_strTitle;
	}

	public String getMassage() {
		return m_strMassage;
	}

	public ANDDialogType getANDDialogType() {
		return m_dialogtype;
	}

//	public boolean isClose() {
//		if(showing) {
//			return false;
//		}
//
//		return true;
//	}
}
