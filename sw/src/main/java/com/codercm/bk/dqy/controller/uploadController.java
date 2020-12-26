//package com.codercm.bk.dqy.controller;
//
//import com.codercm.bk.ysk.result.Result;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.ResourceUtils;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//@Controller
//public class uploadController {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(uploadController.class);
//    @RequestMapping("/test")
//    @CrossOrigin
//    @ResponseBody
//    public Result test(){
//        LOGGER.info("上传成功");
//        return new Result(200);
//    }
//
//    @GetMapping(value = "/fileUpDqy")
//    @CrossOrigin
//    @ResponseBody
//    public String upload() {
//        return "未上传文件";
//    }
//
//    @PostMapping(value = "/fileUpDqy")
//    @CrossOrigin
//    @ResponseBody
//    public String upload(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
//        LOGGER.info("上传失败");
//        if (file.isEmpty()) {
//            LOGGER.info("上传失败");
//            return "上传失败，请选择文件";
//        }
//
//        String fileName = file.getOriginalFilename();
//        String filePath = ResourceUtils.getURL("classpath:").getPath()+"/myfile/";
//        File dest = new File(filePath + fileName);
//        System.out.println(filePath + fileName);
//        try {
//            file.transferTo(dest);
//            LOGGER.info("上传成功");
//            return "上传成功";
//        } catch (IOException e) {
//            LOGGER.error(e.toString(), e);
//        }
//        return "上传失败！";
//    }
//}
