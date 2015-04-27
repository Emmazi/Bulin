package com.example.game;

import java.util.Random;




import com.example.bulin.R;
import com.example.bulin.fragment.Cultivate;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

public class SnowView extends View {
	int MAX_SNOW_COUNT = 30;
	// 雪花图片
	Bitmap bitmap_snows = null;
	// 画笔
	private final Paint mPaint = new Paint();
	// 随即生成器
	private static final Random random = new Random();
	// 花的位置
	private Snow[] snows = new Snow[MAX_SNOW_COUNT];
	// 屏幕的高度和宽度
	int view_height = 0;
	int view_width = 0;
	int MAX_SPEED = 55;
	
	//
	public static int count = 0;
	// stop rain
	public boolean israin = false;
	// first 
	public boolean isFirst = true;

	/**
	 * 构造器
	 * 
	 * 
	 */
	public SnowView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public SnowView(Context context, AttributeSet attrs) {
		super(context, attrs);

	}

	/**
	 * 加载天女散花的花图片到内存中
	 * 
	 */
	public void LoadSnowImage() {
		Resources r = this.getContext().getResources();
		bitmap_snows = ((BitmapDrawable) r.getDrawable(R.drawable.raindrop_l))
				.getBitmap();
	}

	/**
	 * 设置当前窗体的实际高度和宽度
	 * 
	 */
	public void SetView(int height, int width) {
		view_height = height - 100;
		view_width = width - 50;

	}

	/**
	 * 随机的生成花朵的位置
	 * 
	 */
	public void addRandomSnow() {
		
		for (int i = 0; i < MAX_SNOW_COUNT; i++) {
			System.out.println(random.nextInt(view_width)+"-----");
			System.out.println(random.nextInt(MAX_SPEED)+"-----");
			snows[i] = new Snow(random.nextInt(view_width), 0,
					random.nextInt(MAX_SPEED));
		}
	}

	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		for (int i = 0; i < MAX_SNOW_COUNT; i += 1) {
			if (israin) {
				if (snows[i].coordinate.x >= view_width
						|| snows[i].coordinate.y >= view_height) {
					count++;
					snows[i].coordinate.y = 0;
					snows[i].coordinate.x = random.nextInt(view_width);
					System.out.println(count+"----------");
					if(count % 5 == 2){
						Cultivate.view_plant_btn.setBackgroundResource(R.drawable.plant02);
					}
					else if(count % 5  == 1)
					{
						Cultivate.view_plant_btn.setBackgroundResource(R.drawable.plant01);
					}
				}
				// 雪花下落的速度
				snows[i].coordinate.y += snows[i].speed + 15;
				isFirst = false;
			} else {
				//no more new snows from the screen start position.
				// 雪花下落的速度
				if(!isFirst){
					snows[i].coordinate.y += snows[i].speed + 15;
				}
			}
			// // 随机产生一个数字，让雪花有水平移动的效果
			// int tmp = MAX_SPEED/2 - random.nextInt(MAX_SPEED);
			// //为了动画的自然性，如果水平的速度大于雪花的下落速度，那么水平的速度我们取下落的速度。
			// snows[i].coordinate.x += snows[i].speed < tmp ? snows[i].speed :
			// tmp;
			canvas.drawBitmap(bitmap_snows, snows[i].coordinate.x,// ((float)
																	// snows[i].coordinate.x)
					((float) snows[i].coordinate.y) - 140, mPaint);

		}

	}
}
