package com.codercm.bk.ysk.controller;

import com.codercm.bk.ysk.entity.User;
import com.codercm.bk.ysk.entity.UserFile;
import com.codercm.bk.ysk.service.UserFileService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller

public class FileController {
    @Autowired
    private UserFileService userFileService;

    @PostMapping(value ="/fileUp")
    @ResponseBody
    @CrossOrigin
    public String upload(MultipartFile aaa, HttpSession session, RedirectAttributes attributes) throws IOException {

            //获取当前登入的对象
            User user = (User) session.getAttribute("user");

            //获取文件的原始名称
            String oldFileName = aaa.getOriginalFilename();

            //获取文件的后缀
            String extension = "." + FilenameUtils.getExtension(aaa.getOriginalFilename());

            //生成新的文件名称
            String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + UUID.randomUUID().toString().replace("-","").substring(6) + extension;

            //获取文件大小
            long size = aaa.getSize();

            //文件类型
            String type = aaa.getContentType();

            //处理根据日期生成目录
            String realPath = ResourceUtils.getURL("classpath:").getPath() + "/static/files";
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String dateDirPath = realPath + "/" + format;
            File dataDir = new File(dateDirPath);
            if (!dataDir.exists()){
                dataDir.mkdirs();
            }

            //处理文件上传
            aaa.transferTo(new File(dataDir,newFileName));

            UserFile userFile = new UserFile();
            userFile.setOldFileName(oldFileName);
            userFile.setNewFileName(newFileName);
            userFile.setExt(extension);
            userFile.setSize(String.valueOf(size));
            userFile.setType(type);
            userFile.setPath("/files/"+format);
            userFile.setUserId(user.getId());

            //将文件存入数据库
            userFileService.SaveFile(userFile);

        return "redirect:/file/showAll";
    }

}
