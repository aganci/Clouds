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
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
