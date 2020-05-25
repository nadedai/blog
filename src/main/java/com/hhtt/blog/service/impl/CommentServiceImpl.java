package com.hhtt.blog.service.impl;

import com.hhtt.blog.mapper.CommentMapper;
import com.hhtt.blog.pojo.Comment;
import com.hhtt.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhtt
 * @date 2020/5/23 14:44
 * description:
 */
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;

    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<Comment> findAllByBlogID(Integer blogID) {
        return commentMapper.find(blogID);
    }

    @Override
    public int insert(Comment comment) {
        return commentMapper.insert(comment);
    }
}
