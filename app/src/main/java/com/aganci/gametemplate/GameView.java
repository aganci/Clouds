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

    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);

        thread = new GameLoopThread(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
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
        } catch (InterruptedException e) {
        }
    }

    public void render(Canvas canvas) {
        Paint paint = new Paint();

        paint.setColor(Color.RED);
        canvas.drawRect(0, 0, getRight(), getBottom(), paint);
    }
}
