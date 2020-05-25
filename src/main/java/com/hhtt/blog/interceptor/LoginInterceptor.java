package com.hhtt.blog.interceptor;

import com.hhtt.blog.pojo.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hhtt
 * @date 2020/5/19 11:02
 * description:登陆拦截器
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user =(User) request.getSession().getAttribute("user");
        if(user == null){
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
