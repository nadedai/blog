package com.hhtt.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hhtt.blog.mapper.BlogMapper;
import com.hhtt.blog.pojo.Blog;
import com.hhtt.blog.pojo.Type;
import com.hhtt.blog.service.BlogService;
import com.hhtt.blog.util.PageRequest;
import com.hhtt.blog.util.PageResult;
import com.hhtt.blog.util.PageUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhtt
 * @date 2020/5/20 14:49
 * description:
 */
@Service
public class BlogServiceImpl implements BlogService {
    private final BlogMapper blogMapper;

    public BlogServiceImpl(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    @Override
    public PageResult findPage(PageRequest pageRequest, Boolean state) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,state));
    }

    @Override
    public PageResult findPage(PageRequest pageRequest, Boolean state, Type type) {
        return  PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,state,type));
    }

    @Override
    public Blog findOne(int id) {
        return blogMapper.findOne(id);
    }

    @Override
    public List<Blog> findAll(int typeId, Boolean state) {
        Type type = new Type();
        type.setId(typeId);
        return blogMapper.findAll(null,type,state,null);
    }

    @Override
    public List<Blog> findAllTop() {
        return blogMapper.findAll(null,null,null,true);
    }

    @Override
    public Blog findLast() {
        List<Blog> list =  blogMapper.findAll();
        return list.get(list.size()-1);
    }


    @Override
    public int update(int id, Blog blog) {
        return blogMapper.update(id,blog);
    }

    @Override
    public int delete(int id) {
        return blogMapper.delete(id);
    }

    @Override
    public int insert(Blog blog) {
        return blogMapper.insert(blog);
    }

    @Override
    public int updateState(int id, boolean state) {
        return blogMapper.updateState(id,state);
    }

    private PageInfo<Blog> getPageInfo(PageRequest pageRequest) {
        return getPageInfo(pageRequest,null);
    }

    private PageInfo<Blog> getPageInfo(PageRequest pageRequest,Boolean state) {
        return getPageInfo(pageRequest,state,null);
    }

    private PageInfo<Blog> getPageInfo(PageRequest pageRequest,Boolean state,Type type) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> typeMenus = blogMapper.findPage(state,type);
        return new PageInfo<>(typeMenus);
    }
}
