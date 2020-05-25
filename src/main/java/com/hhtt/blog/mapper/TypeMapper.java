package com.hhtt.blog.mapper;


import com.hhtt.blog.pojo.Type;

import java.util.List;

/**
 * @author hhtt
 * @date 2020/5/19 12:57
 * description:
 */
public interface TypeMapper {
    int save(Type type);
    Type findOne(Type type);
    int deleteOne(Type type);
    int updateName(Type type);
    List<Type> findAll();

}
