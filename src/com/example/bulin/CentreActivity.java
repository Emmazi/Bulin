package com.example.bulin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CentreActivity extends Activity implements OnClickListener{

	private TextView zisu;
	private Button tree;
	private Button my;
	private Button scan;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_centre);
		
		zisu = (TextView) findViewById(R.id.intro_zisu);
		zisu.setOnClickListener(this);
		tree = (Button) findViewById(R.id.cen_tree_btn);
		tree.setOnClickListener(this);
		my = (Button) findViewById(R.id.cen_my_btn);
		my.setOnClickListener(this);
		scan = (Button) findViewById(R.id.cen_scan_btn);
		scan.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.intro_zisu:
			Intent in = new Intent(CentreActivity.this, ViewActivity.class);
			startActivity(in);
			overridePendingTransition(R.anim.fade, R.anim.hold);
			// 切换后将自己关闭
			finish();
			break;
		case R.id.cen_my_btn:
			break;
		case R.id.cen_scan_btn:
			break;
		case R.id.cen_tree_btn:
			break;
		
		}
	}

	
}
