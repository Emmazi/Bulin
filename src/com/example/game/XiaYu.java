/**
 * 
 */
package com.example.game;


import com.example.bulin.R;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;

/**
 * @project_name£ºdemo2
 * @type_name£ºXiaYu
 * @Description£º
 * @author£ºqinranran
 * @date£º2013-5-23 ÏÂÎç1:00:15
 * @version 
 */
public class XiaYu extends View{
	private Animation myAnimation_Translate;
	private Paint paint;
	private Context context;

	private int width = 0;
	private int height = 0;
	/**
	 * @param context
	 */
	public XiaYu(Context context) {
		this(context, null);
	}
	public XiaYu(Context context,AttributeSet attr)   
	{   
		super(context,attr);
		this.context = context;
		init();
		
		invalidate();
	}   
	
	public void setWh(int width,int height){
		this.width = width;
		this.height = height;
	}

	
	private void init(){
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
			canvas.drawBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.raindrop_l), 
					width, 0, paint);
		super.onDraw(canvas);
	}
}
