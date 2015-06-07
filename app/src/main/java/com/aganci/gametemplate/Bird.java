package com.aganci.gametemplate;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

import java.sql.Array;

public class Bird {
    float x = 0;
    float y = Float.MIN_VALUE;
    float velocity = 0;
    Bitmap[] frames;
    int frameIndex = 0;
    int time = 0;

    private GameView gameView;

    public Bird(GameView gameView) {
        this.gameView = gameView;
        frames = new Bitmap[] {
            Assets.getImage("bird-frame-1"),
            Assets.getImage("bird-frame-2"),
            Assets.getImage("bird-frame-3")};
    }

    public void update(long delta) {
        if (y == Float.MIN_VALUE) {
            randomize();
        }

        x -= delta / velocity;

        if (x < -frames[0].getWidth()) {
            randomize();
        }

        time += delta;

        frameIndex = ((time / 300) % 3);
    }

    public void render(Canvas canvas) {
        canvas.drawBitmap(frames[frameIndex], x, y, gameView.getPaint());
    }

    public void randomize() {
        x = gameView.getWidth() + 1;
        y = RandomNumberGenerator.getRandInt(gameView.getHeight() - 1);
        velocity = RandomNumberGenerator.getRandIntBetween(5, 20);
    }

    public boolean hasHit(float xhit, float yhit) {
        RectF rect = new RectF(x, y, x + frames[0].getWidth(), y + frames[0].getHeight());
        return rect.contains( xhit, yhit);
    }
}
