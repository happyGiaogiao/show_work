package com.yang.ysk.dao;

import com.yang.ysk.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDAO {
    User login(@Param("username") String username,@Param("password") String password);
}
