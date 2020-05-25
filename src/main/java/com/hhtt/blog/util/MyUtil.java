package com.hhtt.blog.util;

import com.hhtt.blog.Constant;
import com.hhtt.blog.config.MyConfig;
import com.hhtt.blog.pojo.Img;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hhtt
 * @date 2020/5/22 11:11
 * description:
 */
@Slf4j
public class MyUtil {
    /**
     * 获取定长字符串
     */
    public static String getLenText(String content,int len){
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        content  = p.matcher(content).replaceAll("");
        if(content.length() < len){
            return content;
        }
        else {
            return content.substring(0,len);
        }
    }

    public static String getUrl(String content){
        // 按指定模式在字符串查找
        String pattern = "(https|ftp|file|http)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(content);
//        m.group(0)
        if (m.find( )) {
            String str = m.group(0);
            str = str.substring(str.lastIndexOf('.'));
            if(str.contains(".jpg") || str.contains(".png") || str.contains(".gif")){
                return m.group(0);
            }
        }
        return "";
    }


    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip ==null || ip.length() ==0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip ==null || ip.length() ==0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip ==null || ip.length() ==0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static void createPath(String path){
        File file=new File(path);
        file.setWritable(true, false);
        if(!file.exists()){//如果文件夹不存在
            log.info("createPath"+path);
            file.mkdir();//创建文件夹
        }
    }

    public static boolean fileExist(String path){
        File file = new File(path);
        return file.exists();
    }
}
