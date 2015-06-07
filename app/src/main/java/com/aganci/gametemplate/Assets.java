package com.aganci.gametemplate;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.AudioManager;
import android.media.SoundPool;
import android.view.animation.Animation;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class Assets {
	private static HashMap<String, Bitmap> images = new HashMap<String, Bitmap>();
	private static SoundPool soundPool = new SoundPool(25, AudioManager.STREAM_MUSIC, 0);

	public static int shotId;


	public static void init(AssetManager assets) {
		images.put("cloud-1", loadBitmap("cloud-1.png", assets));
		images.put("cloud-2", loadBitmap("cloud-2.png", assets));
		images.put("cloud-3", loadBitmap("cloud-3.png", assets));
		images.put("cloud-4", loadBitmap("cloud-4.png", assets));

		shotId = loadSound("shot.wav", assets);

		images.put("bird-frame-1", loadBitmap("bird-frame-1.png", assets));
		images.put("bird-frame-2", loadBitmap("bird-frame-2.png", assets));
		images.put("bird-frame-3", loadBitmap("bird-frame-3.png", assets));
	}

	public static void playShot() {
		soundPool.play(shotId, 1, 1, 1, 0, 1);
	}

	public static Bitmap getImage(String name) {
		return images.get(name);
	}


	private static Bitmap loadBitmap(String filename, AssetManager assets) {
		InputStream inputStream = null;
		try {
			inputStream = assets.open(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Options options = new Options();
		options.inPreferredConfig = Config.ARGB_8888;
		return BitmapFactory.decodeStream(inputStream, null, options);
	}

	private static int loadSound(String filename, AssetManager assets) {
		int soundID = 0;
		try {
			return soundPool.load(assets.openFd(filename), 1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return soundID;
	}

}