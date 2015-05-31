package com.aganci.gametemplate;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;


import java.io.IOException;
import java.io.InputStream;

public class Assets {
	public static Bitmap loadBitmap(String filename) {
		InputStream inputStream = null;
		try {
			inputStream = GameMainActivity.assets.open(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Options options = new Options();
		options.inPreferredConfig = Config.ARGB_8888;
		return BitmapFactory.decodeStream(inputStream, null, options);
	}
}