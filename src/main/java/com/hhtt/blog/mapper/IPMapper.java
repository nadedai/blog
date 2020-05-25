package com.hhtt.blog.mapper;

import com.hhtt.blog.pojo.IP;

import java.util.List;

/**
 * @author hhtt
 * @date 2020/5/24 17:51
 * description:
 */
public interface IPMapper {
    List<IP> find(String ip,Integer blogID);
    int insert(IP ip);
}
