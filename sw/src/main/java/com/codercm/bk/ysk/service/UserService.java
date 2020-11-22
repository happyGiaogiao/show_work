package com.codercm.bk.ysk.service;

import com.codercm.bk.ysk.dao.UserDAO;
import com.codercm.bk.ysk.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;
    public User login(String username, String password) {
        return userDAO.login(username, password);
    }
}
