package com.android.dev.y_te.moduler.login;

/**
 * Created by fcsdev on 10/2/16.
 */

public interface LoginPresenter<T> {
    void setView(T view);
    void setLogin(String userName, String password);
}
