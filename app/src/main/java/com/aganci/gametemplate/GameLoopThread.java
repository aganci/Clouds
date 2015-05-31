package com.aganci.gametemplate;

import android.graphics.Canvas;
import android.util.Log;

public class GameLoopThread extends Thread {
    private boolean running;
    private GameView gameView;

    public GameLoopThread(GameView gameView) {
        this.gameView = gameView;
    }

    @Override
    public void run() {
        while(running) {
            Log.d("GameLoopThread", "running");

            Canvas canvas = gameView.getHolder().lockCanvas();

            if (canvas == null) {
                continue;
            }

            gameView.render(canvas);

            gameView.getHolder().unlockCanvasAndPost(canvas);

            try {
                sleep(10);
            } catch (InterruptedException e) {
            }
        }

        Log.d("GameLoopThread", "ended");
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
