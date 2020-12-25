package com.codercm.bk.ysk.service;

import com.codercm.bk.ysk.dao.UserDAO;
import com.codercm.bk.ysk.entity.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserFileService {
    @Autowired
    UserDAO userDAO;
    public void SaveFile(UserFile userFile) {
        //进行三目运算判断，文件是否是图片
        String isImg = userFile.getType().startsWith("image")?"是":"否";
        System.out.println(isImg);
        userFile.setIsImg(isImg);
        userFile.setDownCounts(0);
        userFile.setUploadTime(new Date());
        userDAO.SaveFile(userFile);
    }
}
