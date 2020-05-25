package com.hhtt.blog;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Configuration;

/**
 * @author hhtt
 * @date 2020/5/18 22:12
 * description:
 */
@Configuration
public class Constant {

    public static String test;
    public static String IMG_PATH_URL = "/img/";
    public static String INDEX_HTML = "common/index";
    public static String LOGIN_HTML = "common/login";
    public static String BLOG_SHOW = "common/blog_show";
    public static String MG_BLOG_HTML = "mg/blog";
    public static String MG_BLOG_INPUT_HTML = "mg/blog-input";
    public static String MG_TYPE_HTML = "mg/types";
    public static String MG_TYPE_INPUT_HTML = "mg/types-input";

    public static String TYPES_SESSION = "types";

    public static int PAGE_DEFAULT_SIZE = 10;



}
