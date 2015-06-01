package com.aganci.gametemplate;

import android.app.Activity;
import android.content.res.AssetManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class GameMainActivity extends Activity {
    GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Assets.init(getAssets());
        gameView = new GameView(this);
        setContentView(gameView);
    }
}
