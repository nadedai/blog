package com.hhtt.blog.controller;

import com.hhtt.blog.Constant;
import com.hhtt.blog.pojo.Blog;
import com.hhtt.blog.pojo.Type;
import com.hhtt.blog.service.BlogService;
import com.hhtt.blog.service.TypeService;
import com.hhtt.blog.util.PageResult;
import com.hhtt.blog.util.PageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hhtt
 * @date 2020/5/18 18:28
 * description:主界面管理
 */
@Controller
public class IndexController {
    private final BlogService blogService;
    private final TypeService typeService;

    public IndexController(BlogService blogService,TypeService typeService) {
        this.blogService = blogService;
        this.typeService = typeService;
    }

    @GetMapping("index")
    public String index(Model model,Integer page,String typename){
        if(typename!=null){
            Type type = typeService.getType(typename);
            if(type!=null){
                PageResult pageRes = blogService.findPage(PageUtils.getPageRequest(page), true, type);
                model.addAttribute("page", pageRes);
                model.addAttribute("typeCountMap",getTypeCountMap());
                return Constant.INDEX_HTML;
            }
        }

        initTop(model,page);
        return Constant.INDEX_HTML;
    }

    @GetMapping("/")
    public String defaultIndex(Model model,Integer page){
        initTop(model,page);
        return Constant.INDEX_HTML;
    }

    private void initTop(Model model,Integer page){
        PageResult pageRes = blogService.findPage(PageUtils.getPageRequest(page), true);
        if(page == null || page <= 1){
            //显示top博客
            //找出所有top的博客
            List<Blog> blogsTop = new ArrayList<>();
            List<Blog> blogs = blogService.findAllTop();
            for(Blog blog : blogs){
                if(blog.isTop()){
                    blogsTop.add(blog);
                    pageRes.getContent().remove(blog);
                }
            }
            model.addAttribute("blogsTop",blogsTop);
        }

        model.addAttribute("page", pageRes);
        model.addAttribute("typeCountMap",getTypeCountMap());
    }


    private  Map<Type,Integer> getTypeCountMap(){
        Map<Type,Integer> typeMap = new HashMap<>();
        List<Type> typeList = typeService.findALl();
        for(Type t : typeList){
            typeMap.put(t,blogService.findAll(t.getId(),true).size());
        }
        return typeMap;
    }

}
