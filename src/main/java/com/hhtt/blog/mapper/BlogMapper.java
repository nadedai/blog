package com.hhtt.blog.mapper;

import com.hhtt.blog.pojo.Blog;
import com.hhtt.blog.pojo.Comment;
import com.hhtt.blog.pojo.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hhtt
 * @date 2020/5/20 14:42
 * description:
 */
public interface BlogMapper {
    List<Blog> findPage(Boolean state);
    List<Blog> findPage(Boolean state,Type type);
    List<Blog> findAll(Integer id,Type type,Boolean state,Boolean top);
    List<Blog> findAll(Comment comment);
    Blog findOne(int id);
    List<Blog> findAll();
    int delete(int id);
    int insert(Blog blog);
    int update(int id,Blog blog);
    int updateState(int id,boolean state);
}
