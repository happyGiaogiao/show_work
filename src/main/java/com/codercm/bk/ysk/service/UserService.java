package com.codercm.bk.ysk.service;

import com.codercm.bk.ysk.dao.UserDAO;
import com.codercm.bk.ysk.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;
    public User login(String username, String password) {
        return userDAO.login(username, password);
    }
    public admin mlogin(String username, String password) {
        return userDAO.mlogin(username, password);
    }
    public List<User> getUser(){
        return userDAO.getUser();
    }
    public List<Course> getCourse(){
        return userDAO.getCourse();
    }
    public void newCourse(String cname){
        userDAO.newCourse(cname);
    }
    public void deleteCourse(String cname){
        userDAO.deleteCourse(cname);
    }
    public void deleteProject(int pid){
        userDAO.deleteProject(pid);
    }


    public void upload2(int sid, String title, String description, String cname, String content, String date) {
         userDAO.upload2(sid,title,description,cname,content,date);
    }
    public void upload3(int pid,int sid, String title, String description, String cname, String content, String date) {
        userDAO.upload3(pid,sid,title,description,cname,content,date);
    }
    public void insertAvatar(String username,String avatar){
        System.out.println("???");
        userDAO.insertAvatar(username,avatar);
    }

    public void  statusChange(String username,boolean status){ userDAO.statusChange(username,status);};


    @Transactional
    public Project getoneWork(int pid){
        Project project = userDAO.getoneWork(pid);
        return project;
    }
    @Transactional
    public Page getWorkBypage(Integer page, Integer size) {
        Integer rePage = page;
        Page pageEntity = new Page();
        // 默认从0开始
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
         //获取当前也用户信息
        List<Project> projects = userDAO.getWorkBypage(page, size);
        pageEntity.setData(projects);
        // 获取当前用户总量
        Long total = userDAO.getTotal();
        pageEntity.setTotal(total);
        //int pn =(int)((total)/5+1);
        pageEntity.setPageSize(size);
        pageEntity.setCurrentPage(rePage);
         return pageEntity;
    }

    @Transactional
    public Page getWorkBypage2(Integer page, Integer size) {
        Integer rePage = page;
        Page pageEntity = new Page();
        // 默认从0开始
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        //获取当前也用户信息
        List<Bproject> projects = userDAO.getWorkBypage2(page, size);
        pageEntity.setData(projects);
        // 获取当前用户总量
        Long total = userDAO.getTotal();
        pageEntity.setTotal(total);
        //int pn =(int)((total)/5+1);
        pageEntity.setPageSize(size);
        pageEntity.setCurrentPage(rePage);
        return pageEntity;
    }

    @Transactional
    public Page getWorkBysid(Integer page, Integer size,int sid) {
        Integer rePage = page;
        Page pageEntity = new Page();
        // 默认从0开始
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        //获取当前也用户信息
        List<Project> projects = userDAO.getWorkBysid(page,size,sid);
        pageEntity.setData(projects);
        // 获取当前用户总量
        Long total = userDAO.getTotal2(sid);
        pageEntity.setTotal(total);
        //int pn =(int)((total)/5+1);
        pageEntity.setPageSize(size);
        pageEntity.setCurrentPage(rePage);
        return pageEntity;
    }

    @Transactional
    public Page getWorkByCname(Integer page, Integer size,String cname) {
        Integer rePage = page;
        Page pageEntity = new Page();
        // 默认从0开始
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        //获取当前也用户信息
        List<Project> projects = userDAO.getWorkByCname(page,size,cname);
        pageEntity.setData(projects);
        // 获取当前用户总量
        Long total = userDAO.getTotal3(cname);
        pageEntity.setTotal(total);
        //int pn =(int)((total)/5+1);
        pageEntity.setPageSize(size);
        pageEntity.setCurrentPage(rePage);
        return pageEntity;
    }
    }
