package com.hhtt.blog.config;

import com.hhtt.blog.util.MyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author hhtt
 * @date 2020/5/24 13:37
 * description:
 */

@Slf4j
@Component
public class InitMg implements ApplicationRunner {
    private final MyConfig myConfig;



    public InitMg(MyConfig myConfig) {
        this.myConfig = myConfig;
    }


    public void init(){
        log.info("init...");
        String osName = System.getProperties().getProperty("os.name");
        if(osName.contains("Linux")){
            log.info("当前环境为linux");
            myConfig.setAUTO_IMG_Path(myConfig.IMG_LINUX_PATH);
            myConfig.setAUTO_HOST(myConfig.LINUX_HOST);
        }
        else if(osName.contains("Windows")){
            log.info("当前环境为windows");
            myConfig.setAUTO_IMG_Path(myConfig.IMG_PATH);
            myConfig.setAUTO_HOST(myConfig.WINDOWS_HOST);
        }
        MyUtil.createPath(myConfig.AUTO_IMG_Path);
    }





    @Override
    public void run(ApplicationArguments args) {
        init();
    }
}
