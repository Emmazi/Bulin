package com.example.bulin.util;

import android.app.Activity;

public class Globals {

	public static int SCREEN_WIDTH;
	public static int SCREEN_HEIGHT;

	public static void init(Activity a) {

		SCREEN_WIDTH = a.getWindowManager().getDefaultDisplay().getWidth();
		SCREEN_HEIGHT = a.getWindowManager().getDefaultDisplay().getHeight();
	}

}
