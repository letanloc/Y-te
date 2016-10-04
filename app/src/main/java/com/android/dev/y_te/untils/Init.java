package com.android.dev.y_te.untils;

import android.util.Log;
import android.widget.Toast;

import com.android.dev.y_te.app.Myapp;

/**
 * Created by fcsdev on 10/1/16.
 */

public class Init {
    //    public static View id(int id) {
//            Activity   activity=(Activity)Myapp.getInstance().getApplicationContext();
//        return  activity.findViewById(id);
//    }
    public static void sToast(String msg) {
        Toast.makeText(Myapp.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void lToast(String msg) {
        Toast.makeText(Myapp.getContext(), msg, Toast.LENGTH_LONG).show();
    }

    public static void e(String msg) {
        Log.e("DEFAUT::", msg);
    }

}
