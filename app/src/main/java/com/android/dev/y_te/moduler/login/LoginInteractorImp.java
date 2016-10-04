package com.android.dev.y_te.moduler.login;

import com.android.dev.y_te.app.Myapp;
import com.android.dev.y_te.constants.ApiConstants;
import com.android.dev.y_te.constants.Appconstants;
import com.android.dev.y_te.network.GSonRequest;
import com.android.dev.y_te.resquest.UserRespone;
import com.android.dev.y_te.untils.Init;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Created by fcsdev on 10/2/16.
 */

public class LoginInteractorImp implements LoginInteractor, Appconstants {
    GSonRequest<UserRespone> gsonResquest;
    JSONObject jsonParam;

    //    (boolean isPost,String url, Class<T> clazz, Context ctx, JSONObject params,
//    Response.Listener<T> listener, ErrorListener errorListener)
    @Override
    public void setLogin(String userName, String password) {
        jsonParam = new JSONObject();
        try {
            jsonParam.put("username", userName);
            jsonParam.put("password", password);

        } catch (Exception e) {
            Init.e(e.getMessage());
        }

        gsonResquest = new GSonRequest<>(IS_POST, ApiConstants.NETWORK_API + ApiConstants.USER_LOGIN,
                UserRespone.class, Myapp.getContext(), jsonParam, new Response.Listener<UserRespone>() {
            @Override
            public void onResponse(UserRespone response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }


}
