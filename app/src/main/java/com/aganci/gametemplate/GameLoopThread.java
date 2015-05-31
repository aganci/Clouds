package com.aganci.gametemplate;

import android.util.Log;

public class GameLoopThread extends Thread {
    private boolean running;

    @Override
    public void run() {
        while(running) {
            Log.d("GameLoopThread", "running");

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
