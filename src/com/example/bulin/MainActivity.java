package com.example.bulin;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Thread t = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(2548);
				} catch (Exception e) {
				}
				// 切换界面
				Intent in = new Intent(MainActivity.this, CentreActivity.class);
				startActivity(in);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				// 切换后将自己关闭
				finish();
			}
		};
		t.start();
	}

}
