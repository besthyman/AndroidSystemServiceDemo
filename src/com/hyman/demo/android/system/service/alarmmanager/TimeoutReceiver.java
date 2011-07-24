package com.hyman.demo.android.system.service.alarmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class TimeoutReceiver extends BroadcastReceiver {
	private static final String TAG = "TimeoutReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d(TAG, "onReceive");
	}

}
