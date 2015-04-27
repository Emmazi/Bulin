package com.example.bulin;

import java.util.ArrayList;
import java.util.List;

import com.example.bulin.fragment.Cultivate;
import com.example.bulin.fragment.Dye;
import com.example.bulin.fragment.Picture;
import com.example.bulin.fragment.Research;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ViewActivity extends FragmentActivity implements OnClickListener {

	private ViewPager m_vp;
	private Picture pic;
	private Dye dye;
	private Research res;
	private Cultivate cult;

	// ҳ���б�
	private ArrayList<Fragment> fragmentList;
	// �����б�
	ArrayList<String> titleList = new ArrayList<String>();

	// ͨ��pagerTabStrip�������ñ��������
	private PagerTabStrip pagerTabStrip;

	private PagerTitleStrip pagerTitleStrip;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);


		m_vp = (ViewPager) findViewById(R.id.viewpager);

		pagerTabStrip = (PagerTabStrip) findViewById(R.id.pagertab);
		// �����»��ߵ���ɫ
		pagerTabStrip.setMinimumHeight(70);
		pagerTabStrip.setTabIndicatorColor(getResources().getColor(
				android.R.color.holo_green_dark));
		// pagerTabStrip.setTabIndicatorColorResource(R.drawable.header_green);
		// pagerTabStrip.set
		// ���ñ�������ɫ
		pagerTabStrip.setBackgroundResource(R.drawable.header);
		// pagerTabStrip.setBackgroundColor(getResources().getColor(android.R.color.white));

		pagerTabStrip.setTextColor(getResources().getColor(
				android.R.color.black));

		// pagerTitleStrip=(PagerTitleStrip) findViewById(R.id.pagertab);
		// //���ñ�������ɫ
		// pagerTitleStrip.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));

		pic = new Picture();
		dye = new Dye();
		cult = new Cultivate();
		res = new Research();

		fragmentList = new ArrayList<Fragment>();
		fragmentList.add(pic);
		fragmentList.add(res);
		fragmentList.add(dye);
		fragmentList.add(cult);

		titleList.add(" ��Ƭ�� ");
		titleList.add(" �о��� ");
		titleList.add(" Ⱦɫ�� ");
		titleList.add(" ������ ");

		m_vp.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
		// m_vp.setOffscreenPageLimit(2);
	}

	public class MyViewPagerAdapter extends FragmentPagerAdapter {

		public MyViewPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int arg0) {

			if(arg0 == 3)
			{
//				ViewActivity.my_btn.setBackgroundResource(R.drawable.time_g);
//				ViewActivity.tree_btn.setBackgroundResource(R.drawable.tree_g);
//				ViewActivity.scan_btn.setBackgroundResource(R.drawable.scan_g);
			}else{

//				ViewActivity.my_btn.setBackgroundResource(R.drawable.time_a);
//				ViewActivity.tree_btn.setBackgroundResource(R.drawable.tree_btn);
//				ViewActivity.scan_btn.setBackgroundResource(R.drawable.scan_btn);
			}
			Log.v("huahua", "a-----"+arg0);
			return fragmentList.get(arg0);
		}

		@Override
		public int getCount() {
			return fragmentList.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			// TODO Auto-generated method stub

			Log.v("huahua", "p-----"+position);
			return titleList.get(position);
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		
		}
	}
}
