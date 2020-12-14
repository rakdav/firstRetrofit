package com.example.firstretrofit;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("error")
    private boolean error;
    @SerializedName("uid")
    private String uid;
    @SerializedName("user")
    private User user;

    public Result(boolean error, String uid, User user) {
        this.error = error;
        this.uid = uid;
        this.user = user;
    }

    public boolean isError() {
        return error;
    }

    public String getUid() {
        return uid;
    }

    public User getUser() {
        return user;
    }
}
