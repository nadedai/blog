package com.hhtt.blog.mapper;

import com.hhtt.blog.pojo.Img;

import java.util.List;

/**
 * @author hhtt
 * @date 2020/5/22 20:53
 * description:
 */
public interface ImgMapper {
    List<Img> findAll(Integer id,String md5,String name,String rowName);
    int insert(Img img);
}
