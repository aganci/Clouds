package com.aganci.gametemplate;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

public class Score {
    public int value = 0;
    private GameView gameView;

    public Score(GameView gameView) {
        this.gameView = gameView;
    }

    public void increment() {
        value += 1;
    }

    public void render(Canvas canvas) {
        Paint paint = gameView.getPaint();

        paint.setTypeface(Typeface.SANS_SERIF);
        paint.setTextSize(30);
        paint.setColor(Color.GRAY);
        canvas.drawText("Killed " + value, gameView.getWidth() - 120f, 35f, paint);
    }
}
