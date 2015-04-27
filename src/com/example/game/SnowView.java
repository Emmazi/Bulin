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
	// ѩ��ͼƬ
	Bitmap bitmap_snows = null;
	// ����
	private final Paint mPaint = new Paint();
	// �漴������
	private static final Random random = new Random();
	// ����λ��
	private Snow[] snows = new Snow[MAX_SNOW_COUNT];
	// ��Ļ�ĸ߶ȺͿ��
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
	 * ������
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
	 * ������Ůɢ���Ļ�ͼƬ���ڴ���
	 * 
	 */
	public void LoadSnowImage() {
		Resources r = this.getContext().getResources();
		bitmap_snows = ((BitmapDrawable) r.getDrawable(R.drawable.raindrop_l))
				.getBitmap();
	}

	/**
	 * ���õ�ǰ�����ʵ�ʸ߶ȺͿ��
	 * 
	 */
	public void SetView(int height, int width) {
		view_height = height - 100;
		view_width = width - 50;

	}

	/**
	 * ��������ɻ����λ��
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
				// ѩ��������ٶ�
				snows[i].coordinate.y += snows[i].speed + 15;
				isFirst = false;
			} else {
				//no more new snows from the screen start position.
				// ѩ��������ٶ�
				if(!isFirst){
					snows[i].coordinate.y += snows[i].speed + 15;
				}
			}
			// // �������һ�����֣���ѩ����ˮƽ�ƶ���Ч��
			// int tmp = MAX_SPEED/2 - random.nextInt(MAX_SPEED);
			// //Ϊ�˶�������Ȼ�ԣ����ˮƽ���ٶȴ���ѩ���������ٶȣ���ôˮƽ���ٶ�����ȡ������ٶȡ�
			// snows[i].coordinate.x += snows[i].speed < tmp ? snows[i].speed :
			// tmp;
			canvas.drawBitmap(bitmap_snows, snows[i].coordinate.x,// ((float)
																	// snows[i].coordinate.x)
					((float) snows[i].coordinate.y) - 140, mPaint);

		}

	}
}
