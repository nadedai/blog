package com.hhtt.blog.controller;

import com.hhtt.blog.Constant;
import com.hhtt.blog.config.MyConfig;
import com.hhtt.blog.handler.NotFoundException;
import com.hhtt.blog.pojo.Blog;
import com.hhtt.blog.pojo.IP;
import com.hhtt.blog.pojo.Type;
import com.hhtt.blog.pojo.User;
import com.hhtt.blog.service.BlogService;
import com.hhtt.blog.service.CommentService;
import com.hhtt.blog.service.IPService;
import com.hhtt.blog.service.TypeService;
import com.hhtt.blog.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hhtt
 * @date 2020/5/20 14:44
 * description:博客管理
 */

@Slf4j
@Controller
public class BlogController {
    private final BlogService blogService;
    private final TypeService typeService;
    private final CommentService commentService;
    private final IPService ipService;
    public BlogController(BlogService blogService,TypeService typeService,
                          CommentService commentService,IPService ipService) {
        this.blogService = blogService;
        this.typeService = typeService;
        this.commentService = commentService;
        this.ipService = ipService;
    }

    @GetMapping("/blog/show")
    public String blogShow(Integer id, Model model, HttpServletRequest req){
        if(null == id){
            throw new  NotFoundException();
        }
        Blog blog = blogService.findOne(id);
        if(blog == null){
            throw new  NotFoundException();
        }
        //ip操作
        String ip= MyUtil.getIpAddr(req);
        int i = ipService.find(ip, blog.getId());
        if(i<=0){
            //将此ip放入观看列表中
            IP _ip = new IP();
            _ip.setIp(ip);
            _ip.setBlogID(blog.getId());
            ipService.insert(_ip);
        }
        blog.setWatched(ipService.findByBlogID(blog.getId()));
        blogService.update(blog.getId(),blog);
        blog.setCommentList(commentService.findAllByBlogID(blog.getId()));
        String markdownText = MarkdownUtils.markdownToHtml(blog.getContent());
        blog.setContent(markdownText);
        model.addAttribute("blog",blog);
        return Constant.BLOG_SHOW;
    }

    //初始化博客管理页面
    @GetMapping("/mg/blog")
    public String mgBlog(Model model, Integer page, HttpSession session){
        PageResult pageRes = blogService.findPage(PageUtils.getPageRequest(page));
        model.addAttribute("page",pageRes);
        session.setAttribute(Constant.TYPES_SESSION,typeService.findALl());
        return Constant.MG_BLOG_HTML;
    }

    @GetMapping("/mg/blog/input")
    public String blogInput(Model model){
        model.addAttribute("types",typeService.findALl());
        return Constant.MG_BLOG_INPUT_HTML;
    }

    @GetMapping("mg/blog/delete")
    public String delete(Blog blog, Model model, RedirectAttributes attributes){
        int res = blogService.delete(blog.getId());
        if(res > 0){
            attributes.addFlashAttribute("msg","删除成功");
            return "redirect:/mg/blog";
        }
        model.addAttribute("msg","删除失败");
        return Constant.MG_BLOG_HTML;
    }

    //博客保存或发布
    @PostMapping("mg/blog/save")
    public String blogSave(Blog blog,HttpSession session){
        saveBlog(blog,session);
        return Constant.MG_BLOG_INPUT_HTML;
    }

    @PostMapping("mg/blog/save/push")
    public String blogPush(Blog blog,HttpSession session){
        saveBlog(blog,session);
        return "redirect:/index";
    }

    @PostMapping("mg/blog/save/ajax")
    @ResponseBody
    public Map<String,String> blogAjax(Blog blog,HttpSession session){
        Map<String,String> map = new HashMap<>();

        map.put("blogID",String.valueOf(saveBlog(blog,session)));
        map.put("success","1");
        return map;
    }

    @GetMapping("mg/blog/edit")
    public String blogEdit(int id,Model model,HttpSession session){
        model.addAttribute("blog",blogService.findOne(id));
        return Constant.MG_BLOG_INPUT_HTML;
    }

    @GetMapping("/mg/blog/push")
    public String blogPush(int id,RedirectAttributes attributes){
        Blog blog = blogService.findOne(id);
        if(blog == null){
            attributes.addAttribute("msg","发布失败 检查博客是否存在");
        }
        else {
            int res = blogService.updateState(id,true);
            if(res > 0){
                attributes.addAttribute("msg","发布成功");
            }
            else {
                attributes.addAttribute("msg","发布失败");
            }
        }
        return "redirect:/mg/blog";
    }

    @GetMapping("/mg/blog/unPush")
    public String blogUnPush(int id,RedirectAttributes attributes){
        Blog blog = blogService.findOne(id);
        if(blog == null){
            attributes.addAttribute("msg","发布失败 检查博客是否存在");
        }
        else {
            int res = blogService.updateState(id,false);
            if(res > 0){
                attributes.addAttribute("msg","发布成功");
            }
            else {
                attributes.addAttribute("msg","发布失败");
            }
        }
        return "redirect:/mg/blog";
    }



    private int saveBlog(Blog blog,HttpSession session){
        log.warn("blog"+blog);
        Type type = typeService.getType(blog.getType().getName());
        blog.setType(type);
        blog.setIntroduction(MyUtil.getLenText( blog.getIntroduction(),75));
//        blog.setFirstPicture(MyUtil.getUrl(blog.getContent()));
        if(!blog.getFirstPicture().equals("")){
            log.info(blog.getFirstPicture());
            blog.setFirstPicture(blog.getFirstPicture().split("[?]")[0]);
        }
        blog.setUser((User)session.getAttribute("user"));
        //新博客 直接插入
        if(blog.getId() == 0){
            blog.setCreateDate(new Date());
            int res = blogService.insert(blog);
            if(res > 0){
                blog.setId(blogService.findLast().getId());
            }
        }
        else{
            blog.setUpdateDate(new Date());
            blogService.update(blog.getId(),blog);
        }
        return blog.getId();
    }
}
