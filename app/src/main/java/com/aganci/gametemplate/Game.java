package com.aganci.gametemplate;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;

import java.util.ArrayList;

public class Game {
    private GameView gameView;

    ArrayList<Cloud> clouds = new ArrayList<>();

    public Game(GameView gameView) {
        this.gameView = gameView;
        for (int i = 0; i < 10; i++) {
            clouds.add(new Cloud(gameView));
        }
    }

    public void render(Canvas canvas) {
        for(Cloud cloud : clouds) {
            cloud.render(canvas);
        }
    }

    public void update(long delta) {
        for(Cloud cloud : clouds) {
            cloud.update(delta);
        }
    }
}
