package com.android.dev.y_te.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by fcsdev on 10/1/16.
 */

public class Myapp extends Application {

    public static Myapp instance;

    public static Myapp getInstance() {
        if (instance == null) {
            instance = new Myapp();
        }
        return instance;
    }

    public static Context getContext() {
        return instance.getApplicationContext();
    }

//    public static Activity getActivity() {
//
//        return
//    }


    @Override
    public void onCreate() {
        super.onCreate();
        if (instance == null) {
            instance = this;
        }
    }
}
