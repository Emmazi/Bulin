package com.example.bulin.fragment;

import java.util.List;

import com.example.bulin.CentreActivity;
import com.example.bulin.CollectionActivity;
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
	private Button sun;
	private Button cut;
	
	public static Button view_plant_btn;
	// judge whether to begin rain
	private boolean issnow = true;
	private boolean iscut = true;
	private boolean isshine = true;

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
		sun = (Button) mMainView.findViewById(R.id.button_sun);
		sun.setOnClickListener(this);
		cut = (Button) mMainView.findViewById(R.id.button_cut);
		cut.setOnClickListener(this);
		
		view_plant_btn = (Button) mMainView.findViewById(R.id.view_plant_btn);

		scan = (Button) mMainView.findViewById(R.id.cult_scan_btn);
		scan.setOnClickListener(this);
		my = (Button) mMainView.findViewById(R.id.cult_my_btn);
		my.setOnClickListener(this);
		tree = (Button) mMainView.findViewById(R.id.cult_tree_btn);
		tree.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button_rain:
			SnowView.count = 0;
			if (issnow) {
				issnow = false;
				rain.israin = true;
				rain_control.setBackgroundResource(R.drawable.raindrop_l);
				mRedrawHandler.sleep(600);
			} else {
				issnow = true;
				rain.israin = false;
				rain_control.setBackgroundResource(R.drawable.raindrop_a);
				view_plant_btn.setBackgroundResource(R.drawable.plant02);
				iscut = true;
				cut.setBackgroundResource(R.drawable.cut_a);
			}
			break;
		case R.id.button_cut:
			if(iscut){
				cut.setBackgroundResource(R.drawable.cut_b);
				iscut = false;
				view_plant_btn.setBackgroundResource(R.drawable.plant01);
			}
			break;
		case R.id.button_sun:
			if(isshine){
				rain_control.setBackgroundResource(R.drawable.drop_shine);
				cut.setBackgroundResource(R.drawable.cut_shine);
				sun.setBackgroundResource(R.drawable.sun_shine);
				isshine = false;
				
			}else{
				sun.setBackgroundResource(R.drawable.sun_a);
				cut.setBackgroundResource(R.drawable.cut_a);
				rain_control.setBackgroundResource(R.drawable.raindrop_a);
				isshine = true;
			}
			break;
		case R.id.cult_my_btn:
			Intent inm = new Intent(getActivity(), CentreActivity.class);
			startActivity(inm);
			getActivity().finish();
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
			Intent inc = new Intent(getActivity(), CollectionActivity.class);
			startActivity(inc);
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
