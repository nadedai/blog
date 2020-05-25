package com.hhtt.blog.mapper;

import com.hhtt.blog.pojo.Comment;

import java.util.List;

/**
 * @author hhtt
 * @date 2020/5/23 14:36
 * description:
 */
public interface CommentMapper {
    List<Comment> findAll();
    List<Comment> find(int blogId);
    int insert(Comment comment);
}
