
package com.android.dev.y_te.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Users {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("username")
    @Expose
    private Object username;
    @SerializedName("dayofbirth")
    @Expose
    private Object dayofbirth;
    @SerializedName("gender")
    @Expose
    private Object gender;
    @SerializedName("password")
    @Expose
    private Object password;
    @SerializedName("phone")
    @Expose
    private Object phone;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The _id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The username
     */
    public Object getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
    public void setUsername(Object username) {
        this.username = username;
    }

    /**
     * 
     * @return
     *     The dayofbirth
     */
    public Object getDayofbirth() {
        return dayofbirth;
    }

    /**
     * 
     * @param dayofbirth
     *     The dayofbirth
     */
    public void setDayofbirth(Object dayofbirth) {
        this.dayofbirth = dayofbirth;
    }

    /**
     * 
     * @return
     *     The gender
     */
    public Object getGender() {
        return gender;
    }

    /**
     * 
     * @param gender
     *     The gender
     */
    public void setGender(Object gender) {
        this.gender = gender;
    }

    /**
     * 
     * @return
     *     The password
     */
    public Object getPassword() {
        return password;
    }

    /**
     * 
     * @param password
     *     The password
     */
    public void setPassword(Object password) {
        this.password = password;
    }

    /**
     * 
     * @return
     *     The phone
     */
    public Object getPhone() {
        return phone;
    }

    /**
     * 
     * @param phone
     *     The phone
     */
    public void setPhone(Object phone) {
        this.phone = phone;
    }

}
