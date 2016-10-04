package com.android.dev.y_te.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by fcsdev on 9/30/16.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResoudId());
        actionbar();
        init();
        Content();
    }
    public  abstract int getLayoutResoudId();
     public abstract void  init();
     public abstract   void actionbar();
     public abstract void Content();
 }

