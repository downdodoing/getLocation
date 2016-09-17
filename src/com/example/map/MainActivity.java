package com.example.map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

public class MainActivity extends Activity implements AMapLocationListener {
	private TextView t1, t2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		t1 = (TextView) findViewById(R.id.text1);
		t2 = (TextView) findViewById(R.id.text2);

		AMapLocationClient mAMapLoationClient = new AMapLocationClient(this);
		mAMapLoationClient.setLocationListener(this);
		AMapLocationClientOption option = new AMapLocationClientOption();
		// 设置为高精度定位
		option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
		// 设置定位间隔
		option.setInterval(2000);
		// 设置是否返回地址信息
		option.setNeedAddress(true);
		// 设置是否只定一次位
		option.setOnceLocation(false);
		option.setWifiActiveScan(true);

		mAMapLoationClient.setLocationOption(option);
		mAMapLoationClient.startLocation();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onLocationChanged(AMapLocation aMapLocation) {
		if (null != aMapLocation) {
			// 获得經度
			double longitude = aMapLocation.getLongitude();
			// 获得纬度
			double latitude = aMapLocation.getLatitude();
			t1.setText("经度：" + longitude);
			t2.setText("纬度：" + latitude);
		}
	}

}
