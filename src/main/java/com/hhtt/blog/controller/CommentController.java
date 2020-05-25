package com.hhtt.blog.controller;

import com.hhtt.blog.pojo.Comment;
import com.hhtt.blog.pojo.User;
import com.hhtt.blog.service.CommentService;
import com.hhtt.blog.util.MyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author hhtt
 * @date 2020/5/23 16:02
 * description:
 */
@Slf4j
@Controller
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment")
    public ModelAndView postComment(Comment comment, HttpSession session, HttpServletRequest req, ModelAndView modelAndView){
        if(session.getAttribute("user") != null){
            comment.setUserID(((User)session.getAttribute("user")).getId());
        }

        comment.setIp(MyUtil.getIpAddr(req));
        comment.setCreateTime(new Date());
        commentService.insert(comment);
        modelAndView.addObject("id",comment.getBlogID());
        modelAndView.setViewName("redirect:/blog/show");
        return modelAndView;
    }


}
