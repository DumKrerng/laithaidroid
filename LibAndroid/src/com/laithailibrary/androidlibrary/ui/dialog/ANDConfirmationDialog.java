package com.laithailibrary.androidlibrary.ui.dialog;

import android.content.*;
import com.laithailibrary.androidlibrary.exception.*;
import com.laithailibrary.androidlibrary.ui.activity.*;
import com.laithailibrary.androidlibrary.ui.dialog.support.*;

public class ANDConfirmationDialog extends ANDDialog {

	public ANDConfirmationDialog(String p_tag, IANDActivity p_activity, String p_strTitle, String p_strMessage, Runnable p_runOnNegativeButton,
		Runnable p_runOnPositiveButton) {

		super(p_activity, p_strTitle, p_strMessage, ANDDialogType.Confirm);

		init(p_tag, p_runOnNegativeButton, p_runOnPositiveButton);
	}

	public ANDConfirmationDialog(String p_tag, IANDActivity p_activity, String p_strMessage, Runnable p_runOnNegativeButton,
		Runnable p_runOnPositiveButton) {

		super(p_activity, "Confirmation", p_strMessage, ANDDialogType.Confirm);

		init(p_tag, p_runOnNegativeButton, p_runOnPositiveButton);
	}

	public ANDConfirmationDialog(String p_tag, IANDActivity p_activity, String p_strTitle, String p_strMessage, Runnable p_runOnPositiveButton) {
		super(p_activity, p_strTitle, p_strMessage, ANDDialogType.Confirm);

		init(p_tag, null, p_runOnPositiveButton);
	}

	public void init(final String p_tag, final Runnable p_runOnNegativeButton, final Runnable p_runOnPositiveButton) {
		try {
			if(p_runOnNegativeButton != null) {
				setNegativeButton("ไม่", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						try {
							p_runOnPositiveButton.run();

						} catch(Exception exception) {
							ANDLog.severe(p_tag, exception);
						}
					}
				});
			} else {
				setNegativeButton("ไม่", null);
			}

			setPositiveButton("ใช่", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					try {
						p_runOnPositiveButton.run();

					} catch(Exception exception) {
						ANDLog.severe(p_tag, exception);
					}
				}
			});

			ANDDialogManager.show(this);

		} catch(Exception exc) {
			ANDLog.severe(p_tag, exc);
		}
	}
}
