package com.hhtt.blog.mapper;

import com.hhtt.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hhtt
 * @date 2020/5/17 14:30
 * description:
 */
@Mapper
public interface UserMapper {
    List<User> findAll();
    User findByUsernameAndPassword(String username,String password);
}
