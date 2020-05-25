package com.hhtt.blog.service;

import com.hhtt.blog.pojo.Img;

import java.util.List;

/**
 * @author hhtt
 * @date 2020/5/22 20:52
 * description:
 */
public interface ImgService {
     List<Img> findAll();
     Img findByMd5(String md5);
     int insert(Img img);
}
