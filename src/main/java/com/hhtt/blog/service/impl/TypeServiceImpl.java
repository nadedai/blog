package com.hhtt.blog.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hhtt.blog.mapper.TypeMapper;
import com.hhtt.blog.pojo.Type;
import com.hhtt.blog.service.TypeService;
import com.hhtt.blog.util.PageRequest;
import com.hhtt.blog.util.PageResult;
import com.hhtt.blog.util.PageUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhtt
 * @date 2020/5/19 12:56
 * description:
 */
@Service
public class TypeServiceImpl implements TypeService {
    final TypeMapper typeMapper;

    public TypeServiceImpl(TypeMapper typeMapper) {
        this.typeMapper = typeMapper;
    }

    @Override
    public int saveType(Type type) {
        if(getType(type) != null){
            return 0;
        }
        return typeMapper.save(type);
    }

    @Override
    public Type getType(Type type) {
        return typeMapper.findOne(type);
    }

    @Override
    public Type getType(String name) {
        Type t = new Type();
        t.setName(name);
        return typeMapper.findOne(t);
    }


    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    @Override
    public List<Type> findALl() {
        return typeMapper.findAll();
    }


    @Override
    public int updateType(Type type) {
        return typeMapper.updateName(type);
    }

    @Override
    public int deleteType(Type type) {
        return typeMapper.deleteOne(type);
    }

    private PageInfo<Type> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Type> typeMenus = typeMapper.findAll();
        return new PageInfo<Type>(typeMenus);
    }
}
