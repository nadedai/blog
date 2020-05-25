package com.hhtt.blog.service;

import com.hhtt.blog.mapper.UserMapper;
import com.hhtt.blog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhtt
 * @date 2020/5/17 14:42
 * description:
 */
public interface UserService {

    public User checkUser(String username,String password);

}
