package com.hhtt.blog.service.impl;

import com.hhtt.blog.mapper.ImgMapper;
import com.hhtt.blog.pojo.Img;
import com.hhtt.blog.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhtt
 * @date 2020/5/22 20:55
 * description:
 */
@Service
public class ImgServiceImpl implements ImgService {
    private final ImgMapper imgMapper;

    public ImgServiceImpl(ImgMapper imgMapper) {
        this.imgMapper = imgMapper;
    }

    @Override
    public List<Img> findAll() {
        return imgMapper.findAll(null,null,null,null);
    }

    @Override
    public Img findByMd5(String md5) {
        List<Img> imgs = imgMapper.findAll(null, md5, null, null);
        if(imgs.size() <= 0){
            return null;
        }
        return imgs.get(0);
    }

    @Override
    public int insert(Img img) {
        return imgMapper.insert(img);
    }
}
