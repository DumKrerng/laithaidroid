package com.laithailibrary.androidlibrary.ui.activity;

import android.app.*;
import android.content.*;

public interface IANDActivity {
	public ContextWrapper getContextWrapper();
	public Activity getActivity();
	public String getName();
}
