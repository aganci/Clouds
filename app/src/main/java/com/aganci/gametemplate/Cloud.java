package com.aganci.gametemplate;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

public class Cloud {
    Bitmap bitmap;
    private GameView gameView;
    float y = Integer.MIN_VALUE;
    float x;
    float velocity = Float.MIN_VALUE;

    public Cloud(GameView gameView) {
        this.gameView = gameView;
    }

    public void render(Canvas canvas) {
        canvas.drawBitmap(bitmap, x, y, gameView.getPaint());
    }

    public void update(long delta) {
        if (y == Integer.MIN_VALUE) {
            randomize();
        }

        x += delta / velocity;

        if (x >= gameView.getWidth()) {
            randomize();
        }
    }

    public boolean hasHit(float xhit, float yhit) {
        RectF rect = new RectF(x, y, x + bitmap.getWidth(), y + bitmap.getHeight());
        return rect.contains( xhit, yhit);
    }

    public void randomize() {
        int index = RandomNumberGenerator.getRandIntBetween(1, 4);
        bitmap = Assets.getImage("cloud-" + String.valueOf(index));
        x = -bitmap.getWidth();
        y = RandomNumberGenerator.getRandInt(gameView.getHeight() - 1);
        velocity = RandomNumberGenerator.getRandIntBetween(5, 50);
    }
}
