package com.hhtt.blog.controller;

import com.hhtt.blog.Constant;
import com.hhtt.blog.pojo.User;
import com.hhtt.blog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author hhtt
 * @date 2020/5/18 16:46
 * description:登陆管理
 */

@Controller
@RequestMapping("/login")
public class LoginController {
    private final UserService userService;
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String loginPage(){
        return Constant.LOGIN_HTML;
    }

    @PostMapping("login")
    public String login(String username, String password,
                        HttpSession session,
                        HttpServletRequest req,
                        HttpServletResponse rep){
        User user = userService.checkUser(username,password);
        if(user != null){
            session.setAttribute("user",user);
            Cookie usernameC=new Cookie("username",username);
            usernameC.setMaxAge(3600*24*7);
            Cookie passwordC=new Cookie("password",password);
            passwordC.setMaxAge(3600*24*7);
            rep.addCookie(passwordC);
            rep.addCookie(usernameC);
            user.setPassword(null);
            return "redirect:/index";
        }
        else {
            req.setAttribute("msg","用户名或密码错误");
            return Constant.LOGIN_HTML;
        }
    }

    @GetMapping("logout")
    public String logout(HttpSession session,
                         @CookieValue("username") String username,
                         @CookieValue("password") String password,
                         HttpServletResponse rep){
        if(username != null){
            Cookie usernameC=new Cookie("username",null);
            rep.addCookie(usernameC);
        }
        if(password != null){
            Cookie passwordC=new Cookie("password",null);
            rep.addCookie(passwordC);
        }
        session.removeAttribute("user");
        return "redirect:";
    }
}
