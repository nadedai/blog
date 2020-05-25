package com.hhtt.blog.service.impl;

import com.hhtt.blog.mapper.UserMapper;
import com.hhtt.blog.pojo.User;
import com.hhtt.blog.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author hhtt
 * @date 2020/5/18 16:37
 * description:
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User checkUser(String username, String password) {
        return userMapper.findByUsernameAndPassword(username,password);
    }
}
