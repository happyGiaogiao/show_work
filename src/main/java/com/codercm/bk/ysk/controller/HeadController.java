package com.codercm.bk.ysk.controller;


import com.codercm.bk.ysk.entity.Headupp;
import com.codercm.bk.ysk.entity.userAvatar;
import com.codercm.bk.ysk.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
@Controller

public class HeadController {
    @Autowired
    UserService userService;
    private static final Logger LOGGER = LoggerFactory.getLogger(HeadController.class);
    @PostMapping(value = "/HeadUp")
    @CrossOrigin
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
        LOGGER.info("上传");
        if (file.isEmpty()) {
            LOGGER.info("上传失败");
            return "上传失败，请选择文件";
        }

        String fileName = file.getOriginalFilename();
        String filePath = ResourceUtils.getURL("classpath:").getPath()+"/myfile/";
        File dest = new File(filePath + fileName);
        System.out.println(filePath + fileName);
        try {
            file.transferTo(dest);
            LOGGER.info("上传成功");
            String imgURL = "http://192.168.43.85:8443/api/file/" + file.getOriginalFilename();
           // userService.insertAvatar(sid,imgURL);
            return imgURL;

        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "上传失败！";
    }

    @PostMapping(value = "/HeadUpp")
    @CrossOrigin
    @ResponseBody
    public String HeadUpp(@RequestBody Headupp headupp){
        userService.insertAvatar(headupp.getUsername(),headupp.getAvatar());
       String avatar=headupp.getAvatar();
        System.out.println(avatar);
        return avatar;
    }

}
