package com.laithailibrary.androidlibrary.ui.dialog;

import android.content.*;
import com.laithailibrary.androidlibrary.exception.*;
import com.laithailibrary.androidlibrary.ui.activity.*;
import com.laithailibrary.androidlibrary.ui.dialog.support.*;

public class ANDExceptionDialog extends ANDDialog {

	public ANDExceptionDialog(IANDActivity p_activity, Exception p_exception) {
		super(p_activity, "Exception", p_exception.getMessage(), ANDDialogType.Exception);

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
