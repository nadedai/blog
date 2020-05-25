package com.hhtt.blog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author hhtt
 * @date 2020/5/23 21:48
 * description:
 */
@Configuration
public class MyConfig {
    @Value("${my.linux.host}")
    public String LINUX_HOST;
    @Value("${my.windows.host}")
    public String WINDOWS_HOST;
    @Value("${my.imgPath}")
    public String IMG_PATH;
    @Value("${my.linux.imgPath}")
    public String IMG_LINUX_PATH;

    public String AUTO_IMG_Path;
    public String AUTO_HOST;
    public String WEB_IMG_PATH;

    public void setAUTO_IMG_Path(String AUTO_IMG_Path) {
        this.AUTO_IMG_Path = AUTO_IMG_Path;
    }

    public void setAUTO_HOST(String AUTO_HOST) {
        this.AUTO_HOST = AUTO_HOST;
    }

    public String getWEB_IMG_PATH() {
        if(WEB_IMG_PATH == null || WEB_IMG_PATH.equals("")){
            String osName = System.getProperties().getProperty("os.name");
            if(osName.contains("Linux")){
                WEB_IMG_PATH = "file:" + IMG_LINUX_PATH;
            }
            else if(osName.contains("Windows")){
                WEB_IMG_PATH = "file:" + IMG_PATH;
            }
        }
        return WEB_IMG_PATH;
    }

}
