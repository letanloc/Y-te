package com.android.dev.y_te.data;

import android.content.SharedPreferences;

import com.android.dev.y_te.app.Myapp;
import com.android.dev.y_te.constants.Appconstants;
import com.android.dev.y_te.model.Users;
import com.google.gson.Gson;

/**
 * Created by fcsdev on 10/2/16.
 */

public class SharePreData implements Appconstants {
    private static SharedPreferences shared = Myapp.getContext().getSharedPreferences(USER_DATA, 0);
    private static SharedPreferences.Editor editor;
    private static Gson gson;

    public static boolean setIsLogin(Users users) {
        editor = shared.edit();
        editor.putBoolean(IS_LOGIN, true);
        gson = new Gson();
        String json = gson.toJson(users);
        editor.putString(USER, json);
        return editor.commit();
    }

    public static boolean getIsLogin() {
        return shared.getBoolean(IS_LOGIN, false);
    }

    public static Users getUsers() {
        String stUsers = shared.getString(IS_LOGIN, null);
        gson = new Gson();
        Users userObj = gson.fromJson(stUsers, Users.class);
        return userObj;
    }


}
