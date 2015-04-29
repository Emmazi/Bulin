package com.example.bulin;

import com.example.bulin.util.Globals;
import com.example.bulin.util.ImageAdapter1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;

public class ScrollDyeActivity extends Activity implements OnClickListener {

	private Gallery mGallery;// Set the picture
	private int index = 0;// record the picture's position
	private ImageView[] mImageViewIds;// Little pot ImageView[]
	private static final int IMAGE_COUNT = 6;// Pot's number
	private Button return_view_btn;
	private Button collect_view_btn;
	private boolean isSelect = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scroll_dye);
		Globals.init(this);

		findViews();
		mImageViewIds[0].setImageDrawable(getBaseContext().getResources()
				.getDrawable(R.drawable.ic_dot_focused));
		ImageAdapter1 adapter = new ImageAdapter1(ScrollDyeActivity.this);
		mGallery.setAdapter(adapter);
		// Timer timer = new Timer();
		// timer.schedule(task, 2000, 2000);
		mGallery.setOnItemSelectedListener(onItemSelectedListener);
		int position = getIntent().getIntExtra("position", 0);
		mGallery.setSelection(position);
		// mGallery.setSelection(adapter.mImageIds.length * 100000000);
		mGallery.setOnItemClickListener(onItemClickListener);
		mGallery.setVerticalScrollBarEnabled(false);
		mGallery.setBackgroundColor(getResources().getColor(
				android.R.color.black));
		return_view_btn = (Button) findViewById(R.id.return_view_btn);
		return_view_btn.setOnClickListener(this);
		collect_view_btn = (Button) findViewById(R.id.collect_view_btn);
		collect_view_btn.setOnClickListener(this);
	}

	private void findViews() {
		mGallery = (Gallery) findViewById(R.id.gallery);
		mImageViewIds = new ImageView[] { (ImageView) findViewById(R.id.dot_1),
				(ImageView) findViewById(R.id.dot_2),
				(ImageView) findViewById(R.id.dot_3),
				(ImageView) findViewById(R.id.dot_4),
				(ImageView) findViewById(R.id.dot_5),
				(ImageView) findViewById(R.id.dot_6) };
	}

	//
	// private TimerTask task = new TimerTask() {
	//
	// @Override
	// public void run() {
	// Message message = new Message();
	// message.what = 2;
	// index = mGallery.getSelectedItemPosition();
	// index++;
	// handler.sendMessage(message);
	// }
	// };
	//
	// /**
	// * 开一个线程执行耗时操作
	// */
	// private Handler handler = new Handler() {
	//
	// @Override
	// public void handleMessage(Message msg) {
	// super.handleMessage(msg);
	// switch (msg.what) {
	// case 2:
	// mGallery.setSelection(index);
	// break;
	// default:
	// break;
	// }
	// }
	//
	// };
	/**
	 * 设置小圆点显示，position会一直增加，如果要循环显示图片，需要对position取余，否则数组越界
	 */
	private OnItemSelectedListener onItemSelectedListener = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			int pos = position % IMAGE_COUNT;
			mImageViewIds[pos].setImageDrawable(getBaseContext().getResources()
					.getDrawable(R.drawable.ic_dot_focused));
			// if (pos > 0) {
			// mImageViewIds[pos - 1].setImageDrawable(getBaseContext()
			// .getResources().getDrawable(R.drawable.ic_dot_normal));
			// }
			// if (pos < (IMAGE_COUNT - 1)) {
			// mImageViewIds[pos + 1].setImageDrawable(getBaseContext()
			// .getResources().getDrawable(R.drawable.ic_dot_normal));
			// }
			// if (pos == 0) {
			// mImageViewIds[IMAGE_COUNT - 1]
			// .setImageDrawable(getBaseContext().getResources()
			// .getDrawable(R.drawable.ic_dot_normal));
			// }
			for (int i = 0; i < pos; i++) {
				mImageViewIds[i].setImageDrawable(getBaseContext()
						.getResources().getDrawable(R.drawable.ic_dot_normal));
			}
			for (int j = pos + 1; j < IMAGE_COUNT; j++) {
				mImageViewIds[j].setImageDrawable(getBaseContext()
						.getResources().getDrawable(R.drawable.ic_dot_normal));
			}
			collect_view_btn.setBackgroundResource(R.drawable.collect_view_a);
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub

		}
	};

	/**
	 * 点击事件，点击图片进入SecondActivity
	 */
	private OnItemClickListener onItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
				long arg3) {
			collect_view_btn.setBackgroundResource(R.drawable.collect_view_b);
			// finish();
		}
	};

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.collect_view_btn:
			if (!isSelect) {
				collect_view_btn
						.setBackgroundResource(R.drawable.collect_view_b);
				isSelect = true;
			} else {
				collect_view_btn
						.setBackgroundResource(R.drawable.collect_view_a);
				isSelect =false;
			}
			break;
		case R.id.return_view_btn:
			finish();
			break;

		}
	}

}
