package com.android.dev.y_te.moduler.login;

/**
 * Created by fcsdev on 10/2/16.
 */

public class LoginPresenterImp implements LoginPresenter<LoginView> {
    LoginView loginView;
        LoginInteractorImp interactorImp =new LoginInteractorImp();
    @Override
    public void setView(LoginView view) {
        loginView = view;
    }

    @Override
    public void setLogin(String userName, String password) {
        interactorImp.setLogin(userName,password);
    }
}
