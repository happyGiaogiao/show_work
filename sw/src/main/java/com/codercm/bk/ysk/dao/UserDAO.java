package com.codercm.bk.ysk.dao;

import com.codercm.bk.ysk.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserDAO {
    User login(@Param("username") String username,@Param("password") String password);
    admin mlogin(@Param("username") String username, @Param("password") String password);

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

    List<User> getUser();
    List<Course> getCourse();
    void newCourse(@Param("cname") String cname);
    void deleteCourse(@Param("cname") String cname);
    void deleteProject(@Param("pid") int pid);
    void upload2(int sid, String title, String description, String cname, String content, String date);
    void upload3(int pid,int sid, String title, String description, String cname, String content, String date);

    void statusChange(@Param("username") String username,@Param("status") boolean status);

    List<Project> getWorkBypage(Integer page, Integer size);
    List<Bproject> getWorkBypage2(Integer page, Integer size);
    List<Project> getWorkBysid(Integer page, Integer size,int sid);
    List<Project> getWorkByCname(Integer page, Integer size,String cname);
    Project getoneWork(int pid);

    Long getTotal();
    Long getTotal2(int sid);
    Long getTotal3(String cname);

    void insertAvatar(String username,String avatar);
}
