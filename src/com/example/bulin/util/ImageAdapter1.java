package com.example.bulin.util;


import com.example.bulin.R;
import com.example.bulin.R.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;


@SuppressWarnings("deprecation")
public class ImageAdapter1 extends BaseAdapter {
    private static int ITEM_WIDTH;
    private static  int ITEM_HEIGHT;

    private final int mGalleryItemBackground;
    private final Context mContext;

	public static int SCREEN_WIDTH;
	public static int SCREEN_HEIGHT;
	
    public final Integer[] mImageIds = {
            R.drawable.zisu_bg,
            R.drawable.zisu_bg,
            R.drawable.zisu_bg,
            R.drawable.zisu_bg,
            R.drawable.zisu_bg,
            R.drawable.zisu_bg
    };

//    private final float mDensity;

    public ImageAdapter1(Context c) {
        mContext = c;
        ITEM_WIDTH=720;
        ITEM_HEIGHT=500;
        // See res/values/attrs.xml for the <declare-styleable> that defines
        // Gallery1.
        TypedArray a = c.obtainStyledAttributes(R.styleable.Gallery1);
        mGalleryItemBackground = a.getResourceId(
                R.styleable.Gallery1_android_galleryItemBackground, 0);
        a.recycle();

//        mDensity = c.getResources().getDisplayMetrics().density;
    }


	public int getCount() {
        return Integer.MAX_VALUE;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            convertView = new ImageView(mContext);

            imageView = (ImageView) convertView;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new Gallery.LayoutParams(
                    (int) (ITEM_WIDTH ),
                    (int) (ITEM_HEIGHT)));
        
            // The preferred Gallery item background
            imageView.setBackgroundResource(mGalleryItemBackground);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mImageIds[position % mImageIds.length]);

        return imageView;
    }
}
