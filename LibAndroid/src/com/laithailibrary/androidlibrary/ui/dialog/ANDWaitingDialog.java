package com.laithailibrary.androidlibrary.ui.dialog;

import com.laithailibrary.androidlibrary.exception.*;
import com.laithailibrary.androidlibrary.ui.activity.*;
import com.laithailibrary.androidlibrary.ui.dialog.support.*;

public class ANDWaitingDialog {

	private ANDWaitingDialog() {}

	public ANDWaitingDialog(IANDActivity p_activity, String p_strTitle, String p_strMessage, Runnable p_runnable) {
		try {
			ANDDialog dialog = new ANDDialog(p_activity, p_strTitle, "", ANDDialogType.Waiting);
			dialog.setNegativeButton("", null);
			dialog.setPositiveButton("", null);
			dialog.setCancelable(false);

			if(ANDDialogManager.getImageLoading() != null) {
				dialog.setView(ANDDialogManager.getImageLoading());

			} else {
				if(p_strMessage.length() <= 0) {
					p_strMessage = "Loading. . . ";
				}
			}

			dialog.setMessage(p_strMessage);
			dialog.setRunnable(p_runnable);

			ANDDialogManager.show(dialog);

		} catch(Exception exception) {
			ANDLog.severe(p_strTitle, exception);
		}
	}
}
