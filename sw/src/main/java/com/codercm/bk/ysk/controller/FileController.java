package com.codercm.bk.ysk.controller;

import com.codercm.bk.ysk.entity.Project;
import com.codercm.bk.ysk.entity.User;
import com.codercm.bk.ysk.entity.UserFile;
import com.codercm.bk.ysk.entity.admin;
import com.codercm.bk.ysk.service.UserFileService;
import com.codercm.bk.ysk.service.UserService;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller

public class FileController {
    @Autowired
    UserService userService;
    private static final Logger LOGGER = LoggerFactory.getLogger(HeadController.class);
    @PostMapping(value = "/fileup")
    @CrossOrigin
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws FileNotFoundException
    {
        if (file.isEmpty()) {
            LOGGER.info("上传失败");
            return "上传失败，请选择文件";
        }
        LOGGER.info("上传");

        String fileName = file.getOriginalFilename();
        String filePath = ResourceUtils.getURL("classpath:").getPath()+"/myfile/";
        File dest = new File(filePath + fileName);
        String pathname=filePath + fileName;
        System.out.println(filePath + fileName);
        try {
            file.transferTo(dest);
            LOGGER.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "上传失败！";
    }
    @PostMapping(value = "/fileup2")
    @CrossOrigin
    @ResponseBody
    public void upload2(@RequestBody Project project){
        System.out.println(project.getPid());
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前时间为: " + ft.format(dNow));
        project.setDate(ft.format(dNow));
        if(project.getPid()==0){
            userService.upload2(project.getSid(),project.getTitle(),project.getDescription(),project.getCname(),project.getContent(),project.getDate());
        }
        userService.upload3(project.getPid(),project.getSid(),project.getTitle(),project.getDescription(),project.getCname(),project.getContent(),project.getDate());

    }

}
