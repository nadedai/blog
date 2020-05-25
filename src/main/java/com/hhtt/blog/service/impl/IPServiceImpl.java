package com.hhtt.blog.service.impl;

import com.hhtt.blog.mapper.IPMapper;
import com.hhtt.blog.pojo.IP;
import com.hhtt.blog.service.IPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hhtt
 * @date 2020/5/24 17:56
 * description:
 */
@Service
public class IPServiceImpl implements IPService {
    private final IPMapper ipMapper;

    public IPServiceImpl(IPMapper ipMapper) {
        this.ipMapper = ipMapper;
    }

    @Override
    public int findByBlogID(int blogID) {
        return ipMapper.find(null,blogID).size();
    }

    @Override
    public int find(String id, int blogID) {
        return ipMapper.find(id,blogID).size();
    }

    @Override
    public int insert(IP ip) {
        return ipMapper.insert(ip);
    }
}
