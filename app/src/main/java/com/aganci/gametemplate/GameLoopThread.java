package com.aganci.gametemplate;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;

public class GameLoopThread extends Thread {
    public static final int FPS = 60;
    private final Bitmap gameBitmap;
    private final Canvas gameCanvas;

    private boolean running;
    private GameView gameView;

    public GameLoopThread(GameView gameView) {
        this.gameView = gameView;
        gameBitmap = Bitmap.createBitmap(gameView.getWidth(), gameView.getHeight(), Bitmap.Config.RGB_565);
        gameCanvas = new Canvas(gameBitmap);
    }

    @Override
    public void run() {
        long delta = 0;
        while(running) {
            long beforeRender = System.nanoTime();
            render(delta);
            long duration = (System.nanoTime() - beforeRender) / 1000000;
            long sleepTime = Math.max(2, (1000 / FPS) - duration);
            delta = sleepTime + duration;

            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
    }

    private void render(long delta) {
        gameView.update(delta);
        gameView.render(gameCanvas);

        Canvas canvas = gameView.getHolder().lockCanvas();
        if (canvas == null) {
            return;
        }
        canvas.drawBitmap(gameBitmap, 0f, 0f, gameView.getPaint());
        gameView.getHolder().unlockCanvasAndPost(canvas);
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
