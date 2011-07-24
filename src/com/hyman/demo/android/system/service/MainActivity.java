package com.hyman.demo.android.system.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hyman.demo.android.system.service.alarmmanager.AlarmManagerActivity;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void onAlarmManagerClick(View src) {
    	Intent intent = new Intent(this, AlarmManagerActivity.class);
    	this.startActivity(intent);
    }
}