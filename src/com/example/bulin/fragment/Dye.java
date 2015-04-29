package com.example.bulin.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.bulin.CentreActivity;
import com.example.bulin.CollectionActivity;
import com.example.bulin.R;
import com.example.bulin.ViewActivity;
import com.example.bulin.R.id;
import com.example.bulin.R.layout;
import com.example.bulin.ScrollDyeActivity;
import com.example.bulin.util.ImageControl;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Dye extends Fragment implements OnClickListener{
	private View mMainView;
	
	private int minVelocity = 0;
	private GridView pic_gv;
	Bitmap bp = null;
	float scaleWidth;
	float scaleHeight;

	private ImageControl imgControl;
	int h;
	boolean num = false;
	
	private Button scan;
	private Button my;
	private Button tree;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.v("huahua", "fragment3-->onCreate()");
		
		LayoutInflater inflater = getActivity().getLayoutInflater();
		mMainView = inflater.inflate(R.layout.fragment_dye, (ViewGroup)getActivity().findViewById(R.id.viewpager), false);
		
		scan = (Button) mMainView.findViewById(R.id.dye_scan_btn);
		scan.setOnClickListener(this);
		my = (Button) mMainView.findViewById(R.id.dye_my_btn);
		my.setOnClickListener(this);
		tree = (Button) mMainView.findViewById(R.id.dye_tree_btn);
		tree.setOnClickListener(this);
		
//		tv = (TextView)mMainView.findViewById(R.id.tv1);
//		btn = (Button)mMainView.findViewById(R.id.btn1);
//		btn.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				tv.setText("Hello Viewpager\"");
//			}
//		});
		pic_gv = (GridView) mMainView.findViewById(R.id.pic_view);
		// 生成动态数组，并且转入数据
		ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 6; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ItemImage", R.drawable.zisu_bg);// 添加图像资源的ID
			lstImageItem.add(map);
		}
		// 生成适配器的ImageItem <====> 动态数组的元素，两者一一对应
		SimpleAdapter saImageItems = new SimpleAdapter(mMainView.getContext(), // 没什么解释
				lstImageItem,// 数据来源
				R.layout.pic_item,// night_item的XML实现
				// 动态数组与ImageItem对应的子项
				new String[] { "ItemImage" },
				// ImageItem的XML文件里面的一个ImageView,两个TextView ID
				new int[] { R.id.pic_item });
		pic_gv.setAdapter(saImageItems);
		pic_gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				Intent in = new Intent(mMainView.getContext(), ScrollDyeActivity.class);
				Bundle bundle = new Bundle();
				bundle.putInt("position", position);
				in.putExtras(bundle);
				startActivity(in);
			}
		});
		// pic_gv.setOnTouchListener(this);

//		Display display = getActivity().getWindowManager().getDefaultDisplay();
//		bp = BitmapFactory.decodeResource(getResources(),
//				R.drawable.zisu_bg);
//		int width = bp.getWidth();
//		int height = bp.getHeight();
//		int w = display.getWidth();
//		int h = display.getHeight();
//		scaleWidth = ((float) w) / width;
//		scaleHeight = ((float) h) / height;
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.dye_my_btn:
			Intent inm = new Intent(getActivity(), CentreActivity.class);
			startActivity(inm);
			getActivity().finish();
			break;
		case R.id.dye_scan_btn:
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
		case R.id.dye_tree_btn:
			Intent inc = new Intent(getActivity(), CollectionActivity.class);
			startActivity(inc);
			break;

		}
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.v("huahua", "fragment3-->onCreateView()");
		
		ViewGroup p = (ViewGroup) mMainView.getParent(); 
        if (p != null) { 
            p.removeAllViewsInLayout(); 
            Log.v("huahua", "fragment3-->移除已存在的View");
        } 
		
		return mMainView;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.v("huahua", "fragment3-->onDestroy()");
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.v("huahua", "fragment3-->onPause()");
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.v("huahua", "fragment3-->onResume()");
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.v("huahua", "fragment3-->onStart()");
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.v("huahua", "fragment3-->onStop()");
	}

	
	
//	public boolean dispatchTouchEvent(MotionEvent ev) {
//		// TODO Auto-generated method stub
//		if (ev.getAction() == MotionEvent.ACTION_MOVE) {
//			// 禁止Gridview进行滑动
//			Intent in = new Intent(this, GameActivity.class);
//			startActivity(in);
//			finish();
//			return true;
//		}
//		return super.dispatchTouchEvent(ev);
//	}
}
