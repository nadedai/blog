package com.hhtt.blog.service;

import com.hhtt.blog.pojo.Comment;

import java.util.List;

/**
 * @author hhtt
 * @date 2020/5/23 14:43
 * description:
 */
public interface CommentService {
    List<Comment> findAllByBlogID(Integer blogID);
    int insert(Comment comment);
}
