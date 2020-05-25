package com.hhtt.blog.service;

import com.hhtt.blog.pojo.Blog;
import com.hhtt.blog.pojo.Comment;
import com.hhtt.blog.pojo.Type;
import com.hhtt.blog.util.PageRequest;
import com.hhtt.blog.util.PageResult;

import java.util.List;

/**
 * @author hhtt
 * @date 2020/5/20 14:47
 * description:
 */
public interface BlogService {
    PageResult findPage(PageRequest pageRequest);
    PageResult findPage(PageRequest pageRequest,Boolean state);
    PageResult findPage(PageRequest pageRequest, Boolean state, Type type);

    Blog findOne(int id);
    List<Blog> findAll(int typeId,Boolean state);
    List<Blog> findAllTop();
    Blog findLast();
    int update(int id,Blog blog);
    int delete(int id);
    int insert(Blog blog);
    int updateState(int id,boolean state);
}
