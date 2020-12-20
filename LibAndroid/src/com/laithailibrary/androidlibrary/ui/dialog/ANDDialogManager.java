package com.laithailibrary.androidlibrary.ui.dialog;

import java.util.*;
import android.app.*;
import android.content.*;
import android.widget.*;
import com.laithailibrary.androidlibrary.exception.*;
import com.laithailibrary.androidlibrary.ui.dialog.support.*;

public class ANDDialogManager {

	private static ImageView s_imageloading = null;

	private static final List<ANDDialog> s_lsANDDialogs = new ArrayList<>();

	public static void setImageLoading(ImageView p_imageloading) {
		s_imageloading = p_imageloading;
	}

	public static ImageView getImageLoading() {
		return s_imageloading;
	}

	private ANDDialogManager() {}

	public static void show(ANDDialog p_dialog) {
		try {
			ANDLog.info("ANDDialog-" + p_dialog.getANDDialogType() + '-' + p_dialog.getTitle(), p_dialog.getMassage());

			p_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
				@Override
				public void onDismiss(DialogInterface p_dialog) {
					if(s_lsANDDialogs.size() > 0) {
						s_lsANDDialogs.remove(0);

						show();
					}
				}
			});

			s_lsANDDialogs.add(p_dialog);

			if(s_lsANDDialogs.size() == 1) {
				show();
			}
		} catch(Exception exception) {
			ANDLog.print("ANDError", exception.getMessage());
		}
	}

	private static void show() {
		try {
			if(s_lsANDDialogs.size() <= 0) {
				return;
			}

			ANDDialog dialog_last = s_lsANDDialogs.get(s_lsANDDialogs.size() - 1);

			if(dialog_last.getANDDialogType() == ANDDialogType.Exception) {
				s_lsANDDialogs.clear();

				s_lsANDDialogs.add(dialog_last);
			}

			final ANDDialog dialog = s_lsANDDialogs.get(0);
			dialog.setCancelable(false);

			final AlertDialog showable = dialog.getShowing();

			showable.show();

			final Runnable runnable = dialog.getRunnable();

			if(runnable != null) {
				dialog.setNegativeButton("", null);
				dialog.setPositiveButton("", null);

				new Thread(new Runnable() {
					public void run() {
						try {
							runnable.run();

						} catch (Exception exc) {
							ANDLog.print("ANDError", exc.getMessage());

						} finally {
							showable.dismiss();
						}
					}
				}).start();
			}
		} catch(Exception exception) {
			ANDLog.print("ANDError", exception.getMessage());
		}
	}
}
