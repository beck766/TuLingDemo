package com.beck.tuling.model.http.entity;

/**
 * Created by beck on 2018/1/22.
 * TuLingRequest
 */

public class TuLingRequest {
    /**
     * key : APIKEY
     * info : 今天天气怎么样
     * loc : 北京市中关村
     * userid : 123456
     */

    private String key;
    private String info;
    private String loc;
    private String userid;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
