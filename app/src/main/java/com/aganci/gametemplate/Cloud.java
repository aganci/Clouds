package com.aganci.gametemplate;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Cloud {
    Bitmap bitmap;
    private GameView gameView;
    float y = Float.MIN_VALUE;
    float x;
    float velocity = Float.MIN_VALUE;

    public Cloud(GameView gameView) {
        this.gameView = gameView;
        int index = RandomNumberGenerator.getRandIntBetween(1, 4);
        bitmap = Assets.loadBitmap("cloud-" + String.valueOf(index) + ".png");
        x = -bitmap.getWidth();
    }

    public void render(Canvas canvas) {
        canvas.drawBitmap(bitmap, x, y, gameView.getPaint());
    }

    public void update(long delta) {
        if (y == Float.MIN_VALUE) {
            y = RandomNumberGenerator.getRandInt(gameView.getHeight() - 1);
            velocity = RandomNumberGenerator.getRandIntBetween(1, 100);
        }

        x += delta / velocity;

        if (x >= gameView.getWidth()) {
            x = -bitmap.getWidth();
        }
    }
}
