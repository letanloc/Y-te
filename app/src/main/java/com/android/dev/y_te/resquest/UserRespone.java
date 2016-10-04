package com.android.dev.y_te.resquest;

import com.android.dev.y_te.base.BaseRespone;
import com.android.dev.y_te.model.Users;
import com.google.gson.annotations.SerializedName;

/**
 * Created by fcsdev on 10/2/16.
 */

public class UserRespone extends BaseRespone {
    @SerializedName("message")
    private Users users;
    public Users getUsers() {
        return users;
    }
    public void setUsers(Users users) {
        this.users = users;
    }
}
