package com.codercm.bk.ysk.dao;

import com.codercm.bk.ysk.entity.User;
import com.codercm.bk.ysk.entity.UserFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDAO {
    User login(@Param("username") String username,@Param("password") String password);

    //根据Id查询该用户的所有文件
    List<UserFile> getFilesByUserId(Integer id);

    //保存文件信息
    void SaveFile(UserFile userFile);

    //根据Id查询对应文件
    UserFile getFilesById(Integer id);

    //更新
    void update(UserFile userFile);

    //根据Id删除记录
    void delete(Integer id);
}
