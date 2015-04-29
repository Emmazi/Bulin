package com.example.bulin;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
			
			break;
		case R.id.cen_my_btn:
			break;
		case R.id.cen_scan_btn:
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_MAIN);
			intent.addCategory(Intent.CATEGORY_LAUNCHER);
			List<ResolveInfo> lists = getPackageManager()
					.queryIntentActivities(intent, 0);

			Boolean isSightPlusExists = false;
			// 获取launcher中应用列表的名称和图标
			for (int i = 0; i < lists.size(); i++) {
				if (lists.get(i).activityInfo.packageName
						.equals("cn.easyar.sightplus")) {
					isSightPlusExists = true;
				} else {
					//SightPlus is not exists
					System.out.println("----SightPlus is not exists----");
				}
			}
			// 从当前应用跳转到另一个应用中
			if (isSightPlusExists) {
				Intent isn = getPackageManager().getLaunchIntentForPackage(
						"cn.easyar.sightplus");

				startActivity(isn);
			}else
			{
				Toast.makeText(getApplicationContext(), "请自行下载 视+ 软件进行扫描",
					     Toast.LENGTH_SHORT).show();	
			}
			
			break;
		case R.id.cen_tree_btn:
			Intent inc = new Intent(CentreActivity.this, CollectionActivity.class);
			startActivity(inc);
			overridePendingTransition(R.anim.fade, R.anim.hold);
			break;
		
		}
	}

	
}
