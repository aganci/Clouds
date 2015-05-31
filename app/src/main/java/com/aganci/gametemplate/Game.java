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

        x++;
        if (x >= gameView.getWidth()) {
            x = 0;
        }

        y++;
        if (y >= gameView.getHeight()) {
            y = 0;
        }
    }
}
