package com.example.map;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

}
