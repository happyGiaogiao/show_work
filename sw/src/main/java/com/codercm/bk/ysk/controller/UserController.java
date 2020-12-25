package com.codercm.bk.ysk.controller;

import com.codercm.bk.ysk.entity.*;
import com.codercm.bk.ysk.result.Result;
import com.codercm.bk.ysk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/getUser")
    public List<User> getUser(){
        return userService.getUser();
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/works")
    public Page getWorkBypage(@RequestParam(defaultValue = "1") Integer currentPage,@RequestParam("cname") String cname){
        System.out.println("1");
        if (cname.equals("全部作品")){
            System.out.println("2");
            return userService.getWorkBypage(currentPage, 5);
        }else {
            System.out.println("3");
            return userService.getWorkByCname(currentPage, 5,cname);
        }
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/work")
    public Project getoneWork(@RequestParam("pid") int pid){
       return userService.getoneWork(pid);
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/mWorks")
    public Page getWorkBypage2(@RequestParam(defaultValue = "1") Integer currentPage){
            return userService.getWorkBypage2(currentPage, 8);
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/oneWorks")
    public Page getWorkBysid(@RequestParam(defaultValue = "1") Integer currentPage,@RequestParam("sid") int sid){
        return userService.getWorkBysid(currentPage,5,sid);
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/getCourse")
    public List<Course> getCourse(){
        return userService.getCourse();
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/addCourse")
    public void newCourse(@RequestBody newCourse newCourse){
         userService.newCourse(newCourse.getCname());
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/deleteCourse")
    public void deleteCourse(@RequestBody newCourse newCourse){
        userService.deleteCourse(newCourse.getCname());
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/deleteProject")
    public void deleteProject(@RequestBody deleteProject deleteProject){
        userService.deleteProject(deleteProject.getPid());
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/statusChange")
    public void statusChange(@RequestBody statusChange statusChange){
         userService.statusChange(statusChange.getUsername(),statusChange.isStatus());
    }
}
