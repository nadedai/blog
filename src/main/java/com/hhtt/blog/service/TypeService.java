package com.hhtt.blog.service;
import com.hhtt.blog.pojo.Type;
import com.hhtt.blog.util.PageRequest;
import com.hhtt.blog.util.PageResult;

import java.util.List;

/**
 * @author hhtt
 * @date 2020/5/19 12:54
 * description:
 */
public interface TypeService {

    int saveType(Type type);
    Type getType(Type type);
    Type getType(String name);
    PageResult findPage(PageRequest pageRequest);
    List<Type> findALl();
    int updateType(Type type);
    int deleteType(Type type);
}
