package com.aganci.gametemplate;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class Game {

    ArrayList<Cloud> clouds = new ArrayList<>();
    Score score;

    public Game(GameView gameView) {
        for (int i = 0; i < 10; i++) {
            clouds.add(new Cloud(gameView));
        }
        score = new Score(gameView);
    }

    public void render(Canvas canvas) {
        for(Cloud cloud : clouds) {
            cloud.render(canvas);
        }
        score.render(canvas);
    }

    public void update(long delta) {
        for(Cloud cloud : clouds) {
            cloud.update(delta);
        }
    }

    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() != MotionEvent.ACTION_UP) {
            return true;
        }

        for(Cloud cloud : clouds) {
            if (cloud.hasHit(event.getX(), event.getY())) {
                Assets.playShot();
                cloud.randomize();
                score.increment();
                break;
            }
        }
        return true;
    }
}
