package com.laithailibrary.androidlibrary.ui.dialog;

import android.content.*;
import com.laithailibrary.androidlibrary.exception.*;
import com.laithailibrary.androidlibrary.ui.activity.*;
import com.laithailibrary.androidlibrary.ui.dialog.support.*;

public class ANDInfoDialog extends ANDDialog {

	public ANDInfoDialog(String p_tag, IANDActivity p_activity, String p_strMessage) {
		super(p_activity, "Info", p_strMessage, ANDDialogType.Info);

		init(p_tag, p_strMessage);
	}

	public ANDInfoDialog(String p_tag, IANDActivity p_activity, String p_strTitle, String p_strMessage) {
		super(p_activity, p_strTitle, p_strMessage, ANDDialogType.Info);

		init(p_tag, p_strMessage);
	}

	private void init(String p_tag, String p_strMessage) {
		try {
			setPositiveButton("ปิด", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					//do things
				}
			});

			ANDDialogManager.show(this);

		} catch(Exception exc) {
			ANDLog.severe("", exc);
		}
	}
}
