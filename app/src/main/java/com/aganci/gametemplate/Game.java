package com.aganci.gametemplate;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Game {
    private GameView gameView;
    Paint paint = new Paint();

    int x = 0;
    int y = 0;

    public Game(GameView gameView) {
        this.gameView = gameView;
    }

    public void render(Canvas canvas) {
        paint.setColor(Color.GREEN);
        canvas.drawRect(x, y, x + 100, y + 200, paint);
    }

    public void update(long delta) {
        x += delta / 10;
        if (x >= gameView.getWidth()) {
            x = 0;
        }

        y += delta / 10;
        if (y >= gameView.getHeight()) {
            y = 0;
        }
    }
}
