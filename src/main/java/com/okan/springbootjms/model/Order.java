package com.okan.springbootjms.model;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private String content;
    private Date timeStamp;

    public Order() {
    }

    public Order(String content, Date timestamp) {
        this.content = content;
        this.timeStamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timeStamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timeStamp = timestamp;
    }

    @Override
    public String toString() {
        return "Order{" +
                "content='" + content + '\'' +
                ", timestamp=" + timeStamp +
                '}';
    }
}
