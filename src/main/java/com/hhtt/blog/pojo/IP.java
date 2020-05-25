package com.hhtt.blog.pojo;

/**
 * @author hhtt
 * @date 2020/5/24 17:49
 * description:
 */
public class IP {
    public int id;
    public String ip;
    public int blogID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getBlogID() {
        return blogID;
    }

    public void setBlogID(int blogID) {
        this.blogID = blogID;
    }
}
