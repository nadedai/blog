package com.hhtt.blog.controller;

import com.hhtt.blog.Constant;
import com.hhtt.blog.config.InitMg;
import com.hhtt.blog.config.MyConfig;
import com.hhtt.blog.pojo.Img;
import com.hhtt.blog.service.ImgService;
import com.hhtt.blog.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author hhtt
 * @date 2020/5/19 12:38
 * description:后台管理
 */
@Controller
@RequestMapping("/mg")
public class MgController {
    private final MyConfig config;
    private final ImgService imgService;
    public MgController(ImgService imgService, MyConfig config) {
        this.imgService = imgService;
        this.config = config;
    }

    @RequestMapping
    public String mg(){
        return "redirect:/mg/blog";
    }

    @PostMapping("/fileUpload")
    @ResponseBody
    public Map<String,Object> fileUpload(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file, HttpServletRequest req) throws IOException {
        String filePath = config.AUTO_IMG_Path;
        String md5 = DigestUtils.md5DigestAsHex(file.getBytes());
        Img img = imgService.findByMd5(md5);
        //处理文件在数据库存在的情况
        if(img !=  null){
            //本地不存在
            boolean fileExist = MyUtil.fileExist(filePath + img.getName());
            if(!fileExist){

                file.transferTo(new File(filePath,img.getName()));
            }
            String url = Constant.IMG_PATH_URL+img.getName();
            return setResMap(true,url);
        }

        Map<String,Object> resultMap = null;
        try {
            String filename = UUID.randomUUID() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            file.transferTo(new File(filePath,filename));
            imgService.insert(new Img(null,filename,file.getOriginalFilename(),md5));
            resultMap = setResMap(true,Constant.IMG_PATH_URL+filename);

        } catch (Exception e) {
            resultMap = setResMap(false,null);
            e.printStackTrace();
        }
        return resultMap;
    }

    private Map<String,Object> setResMap(boolean success,String url){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        if(success){
            resultMap.put("success", 1);
            resultMap.put("message", "上传成功！");
            resultMap.put("url",url);
        }
        else {
            resultMap.put("success", 0);
            resultMap.put("message", "上传失败！");
        }
        return resultMap;
    }

}
