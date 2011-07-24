package com.hyman.demo.android.system.service.alarmmanager;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

import com.hyman.demo.android.system.service.R;

public class AlarmManagerActivity extends Activity {
	private static final String TAG = "AlarmManagerActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alarmmanager);
	}

	public void setTimeoutClick(View src) {
		Log.d(TAG, "setTimeoutClick");
		Intent intent = new Intent(this, TimeoutReceiver.class);
		intent.setAction("short");
		PendingIntent sender = PendingIntent.getBroadcast(this, 0, intent, 0);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.SECOND, 5);

		AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);
		alarm.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
	}

	public void setIntervalClick(View src) {
		Log.d(TAG, "setIntervalClick");
		Intent intent = new Intent(this, IntervalReceiver.class);
		intent.setAction("repeating");
		PendingIntent sender = PendingIntent.getBroadcast(this, 0, intent, 0);
		long firstime = SystemClock.elapsedRealtime();

		AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
		am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, firstime,
				5 * 1000, sender);
	}

	public void calcelClick(View src) {
		Log.d(TAG, "calcelClick");
		Intent intent = new Intent(this, IntervalReceiver.class);
		intent.setAction("repeating");
		PendingIntent sender = PendingIntent.getBroadcast(this, 0, intent, 0);
		AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);
		alarm.cancel(sender);
	}
}
