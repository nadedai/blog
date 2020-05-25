package com.hhtt.blog.interceptor;

import com.hhtt.blog.config.MyConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author hhtt
 * @date 2020/5/19 11:11
 * description:配置拦截器以及静态资源的访问
 */
@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {
    private final MyConfig config;

    public WebConfig(MyConfig config) {
        this.config = config;
    }

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/mg/**");
    }

    //配置静态资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations(config.getWEB_IMG_PATH());
        log.info("设置图片访问路径为:"+config.WEB_IMG_PATH);
    }
}
