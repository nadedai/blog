package com.hhtt.blog.service;

import com.hhtt.blog.pojo.IP;

/**
 * @author hhtt
 * @date 2020/5/24 17:55
 * description:
 */
public interface IPService {
    int findByBlogID(int blogID);
    int find(String id,int blogID);
    int insert(IP ip);
}
