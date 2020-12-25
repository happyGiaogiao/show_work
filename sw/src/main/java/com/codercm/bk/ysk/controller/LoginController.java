package com.codercm.bk.ysk.controller;

import com.codercm.bk.ysk.entity.User;
import com.codercm.bk.ysk.entity.admin;
import com.codercm.bk.ysk.result.Result;
import com.codercm.bk.ysk.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@Controller

public class LoginController {
    @Autowired
    UserService userService;
    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/login")
    public Result login(@RequestBody User requestUser, HttpSession session){
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.login(username,requestUser.getPassword());

       if (null==user){
            return new Result(401);
        }else if(user.isStatus()==false){
            return new Result(400);
        }else{
           return new Result(200,user.getSid(),user.getRealname(),user.getAvatar());
       }

    }
    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/mlogin")
    public Result mlogin(@RequestBody admin admin){

        admin a = userService.mlogin(admin.getUsername(), admin.getPassword());
        if(null == a) {
            return new Result(400);
        }else {
            return new Result(200);
        }
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/logout")
    public Result logout(){
            return new Result(200);
    }
}
