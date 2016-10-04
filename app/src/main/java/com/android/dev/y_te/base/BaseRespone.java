
package com.android.dev.y_te.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public  abstract class BaseRespone {

    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("message")
    @Expose
    private String message;


    /**
     * @return The code
     */

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
