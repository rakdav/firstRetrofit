package com.example.firstretrofit;

import java.util.Date;

public class User {
    private String name;
    private String email;
    private Date created_at;
    private Date update_at;

    public User(String name, String email, Date created_at, Date update_at) {
        this.name = name;
        this.email = email;
        this.created_at = created_at;
        this.update_at = update_at;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }
}
