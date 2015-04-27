package com.example.bulin.fragment;

import java.util.List;

import com.example.bulin.R;
import com.example.game.SnowView;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.Toast;

public class Cultivate extends Fragment implements OnClickListener {

	private View mMainView;

	private SnowView rain = null;
	
	// Button to controll whether to rain
	private Button rain_control;
	public static Button view_plant_btn;
	// judge whether to begin rain
	private boolean issnow = true;

	private Button scan;
	private Button my;
	private Button tree;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		LayoutInflater inflater = getActivity().getLayoutInflater();
		mMainView = inflater.inflate(R.layout.fragment_cult,
				(ViewGroup) getActivity().findViewById(R.id.viewpager), false);

		rain = (SnowView) mMainView.findViewById(R.id.snow);
		rain.israin = false;
		rain.LoadSnowImage();
		rain.SetView(1500, 1300);
		rain.addRandomSnow();
		
		// DisplayMetrics dm = new DisplayMetrics();
		// mMainView.getContext().getApplicationContext().getMetrics(dm);
		// Fragment.getDefaultDisplay().getMetrics(dm);
		// rain.SetView(dm.heightPixels, dm.widthPixels);
		
		rain_control = (Button) mMainView.findViewById(R.id.button_rain);
		rain_control.setOnClickListener(this);
		view_plant_btn = (Button) mMainView.findViewById(R.id.view_plant_btn);

		scan = (Button) mMainView.findViewById(R.id.cen_scan_btn);
		scan.setOnClickListener(this);
		my = (Button) mMainView.findViewById(R.id.cen_my_btn);
		my.setOnClickListener(this);
		tree = (Button) mMainView.findViewById(R.id.cen_tree_btn);
		tree.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button_rain:
			if (issnow) {
				issnow = false;
				rain.israin = true;
				rain_control.setBackgroundResource(R.drawable.raindrop_l);
				mRedrawHandler.sleep(600);
			} else {
				issnow = true;
				rain.israin = false;
				rain_control.setBackgroundResource(R.drawable.raindrop_a);
				view_plant_btn.setBackgroundResource(R.drawable.plant0);
				SnowView.count = 0;
			}
			break;
		case R.id.button_cut:
			break;
		case R.id.button_sun:
			break;
		case R.id.cult_my_btn:
			break;
		case R.id.cult_scan_btn:
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_MAIN);
			intent.addCategory(Intent.CATEGORY_LAUNCHER);
			List<ResolveInfo> lists = getActivity().getPackageManager()
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
				Intent in = getActivity().getPackageManager().getLaunchIntentForPackage(
						"cn.easyar.sightplus");

				startActivity(in);
			}else
			{
				Toast.makeText(getActivity().getApplicationContext(), "请自行下载 视+ 软件进行扫描",
					     Toast.LENGTH_SHORT).show();	
			}

			break;
		case R.id.cult_tree_btn:
			break;

		}
	}
	
	/*
	 * 负责做界面更新工作 ，开始浇水
	 */
	private RefreshHandler mRedrawHandler = new RefreshHandler();

	class RefreshHandler extends Handler {
		
		@Override
		public void handleMessage(Message msg) {
			// rain.addRandomSnow();
			rain.invalidate();
			sleep(100);
		}

		public void sleep(long delayMillis) {
			this.removeMessages(0);
			sendMessageDelayed(obtainMessage(0), delayMillis);
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.v("huahua", "fragment4-->onCreateView()");

		ViewGroup p = (ViewGroup) mMainView.getParent();
		if (p != null) {
			p.removeAllViewsInLayout();
			Log.v("huahua", "fragment4-->移除已存在的View");
		}

		return mMainView;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

		Log.v("huahua", "fragment4-->onDestroy()");
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

		Log.v("huahua", "fragment4-->onPause()");

	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.v("huahua", "fragment4-->onResume()");

	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.v("huahua", "fragment4-->onStart()");

	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.v("huahua", "fragment4-->onStop()");
	}

}
