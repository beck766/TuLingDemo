package com.beck.tuling.model.http.entity;

import java.util.Date;

/**
 * Created by beck on 2018/1/22.
 * TuLingResponse
 */

public class TuLingResponse {
    /**
     * code : 200000
     * text : 亲，已帮你找到图片
     * url : http://m.image.so.com/i?q=%E5%B0%8F%E7%8B%97
     */

    private int code;
    private String text;
    private String url;
    private Type type;
    private Date date;

    public enum Type {
        INCOMING, OUTCOMING
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
