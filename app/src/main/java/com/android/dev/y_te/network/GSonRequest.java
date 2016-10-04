package com.android.dev.y_te.network;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by NguyenMinhTuan on 1/8/16.
 */
public class GSonRequest<T> extends Request<T> {
    public static final int TIMEOUT_REQUEST_DATA = 30 * 1000;
    private final Gson gson = new Gson();
    private final Class<T> clazz;
    private final Map<String, String> headers;
    private final JSONObject params;
    private final Listener<T> listener;

    /**
     * Make a GET request and return a parsed object from JSON.
     *
     * @param isPost            POST is true, GET is fail
     * @param url               URL of the request to make
     * @param clazz             Relevant class object, for Gson's reflection
     * @param ctx               Context of View
     * @param params            Map of request body
     * @param listener          Callback success
     * @param errorListener     Callback fail
     */

    public GSonRequest(boolean isPost,String url, Class<T> clazz, Context ctx, JSONObject params,
                       Listener<T> listener, ErrorListener errorListener) {

        super(isPost ? Method.POST : Method.GET,
                url,
                errorListener);
        if (params == null){
            params = new JSONObject();
        }
        this.setRetryPolicy(new DefaultRetryPolicy(
                TIMEOUT_REQUEST_DATA,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        this.clazz = clazz;
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
//        Log.d("REQUEST", "URL: \n" + getOriginUrl() + "\nHEADER: \n" + headers + "\nPARAMS: \n" + params);
        this.headers = headers;
        this.listener = listener;
        this.params = params;
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        try {
            return this.params.toString().getBytes(getParamsEncoding());
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("Encoding not supported: " + "UTF-8", uee);
        }
    }

    @Override
    public String getBodyContentType() {
        return "application/json";
    }


    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers != null ? headers : super.getHeaders();
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(
                    gson.fromJson(json, clazz),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }
}
