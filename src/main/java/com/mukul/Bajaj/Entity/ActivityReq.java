package com.mukul.Bajaj.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

public class ActivityReq {

    private String activity;
    private Long count;
    private String username;

    public ActivityReq() {}

    public ActivityReq(String activity, Long count, String username) {
        this.activity = activity;
        this.count = count;
        this.username = username;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
