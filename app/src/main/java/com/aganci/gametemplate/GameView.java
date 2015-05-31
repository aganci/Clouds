package com.aganci.gametemplate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    GameLoopThread thread;
    Paint paint = new Paint();
    Game game;


    public GameView(Context context) {
        super(context);
        game = new Game(this);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new GameLoopThread(this);
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        thread.setRunning(false);
        try {
            thread.join();
        }
        catch (InterruptedException e) {
        }
    }

    public void render(Canvas canvas) {
        clearScreen(canvas);
        game.render(canvas);
    }

    private void clearScreen(Canvas canvas) {
        paint.setColor(Color.rgb(126, 202, 247));
        canvas.drawRect(0, 0, getRight(), getBottom(), paint);
    }

    public void update(long delta) {
        game.update(delta);
    }

    public Paint getPaint() {
        return paint;
    }
}
