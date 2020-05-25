package com.hhtt.blog.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author hhtt
 * @date 2020/5/18 11:48
 * description:
 */
public class Comment {
    private int id;
    private int blogID;
    private int userID;
    private String content;
    private String ip;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getBlogID() {
        return blogID;
    }

    public void setBlogID(int blogID) {
        this.blogID = blogID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", blogID=" + blogID +
                ", content='" + content + '\'' +
                ", ip='" + ip + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
