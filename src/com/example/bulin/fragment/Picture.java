package com.example.bulin.fragment;

import java.util.List;

import com.example.bulin.R;
import com.example.bulin.R.id;
import com.example.bulin.R.layout;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Picture extends Fragment implements OnClickListener {

	private View mMainView;

	private Button scan;
	private Button my;
	private Button tree;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.v("huahua", "fragment1-->onCreate()");

		LayoutInflater inflater = getActivity().getLayoutInflater();
		mMainView = inflater.inflate(R.layout.fragment_pic,
				(ViewGroup) getActivity().findViewById(R.id.viewpager), false);

		scan = (Button) mMainView.findViewById(R.id.pic_scan_btn);
		scan.setOnClickListener(this);
		my = (Button) mMainView.findViewById(R.id.pic_my_btn);
		my.setOnClickListener(this);
		tree = (Button) mMainView.findViewById(R.id.pic_tree_btn);
		tree.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.pic_my_btn:
			break;
		case R.id.pic_scan_btn:
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
					// SightPlus is not exists

					System.out.println("----SightPlus is not exists----");
				}
			}
			// 从当前应用跳转到另一个应用中
			if (isSightPlusExists) {
				Intent in = getActivity().getPackageManager()
						.getLaunchIntentForPackage("cn.easyar.sightplus");

				startActivity(in);
			} else {
				Toast.makeText(getActivity().getApplicationContext(),
						"请自行下载 视+ 软件进行扫描", Toast.LENGTH_SHORT).show();
			}

			break;
		case R.id.pic_tree_btn:
			break;

		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.v("huahua", "fragment1-->onCreateView()");

		ViewGroup p = (ViewGroup) mMainView.getParent();
		if (p != null) {
			p.removeAllViewsInLayout();
			Log.v("huahua", "fragment1-->移除已存在的View");
		}

		return mMainView;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.v("huahua", "fragment1-->onDestroy()");
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.v("huahua", "fragment1-->onPause()");
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.v("huahua", "fragment1-->onResume()");
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.v("huahua", "fragment1-->onStart()");
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.v("huahua", "fragment1-->onStop()");
	}

}
