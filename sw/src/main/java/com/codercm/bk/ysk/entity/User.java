package com.codercm.bk.ysk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private int sid;
    private String username;
    private String password;
    private String realname;
    private boolean status;
    private String avatar;
}
