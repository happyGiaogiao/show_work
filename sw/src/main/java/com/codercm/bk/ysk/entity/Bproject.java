package com.codercm.bk.ysk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bproject {
    //pid,username,realname,title,description,cname,content,date
    private int pid;
    private String username;
    private String realname;
    private String title;
    private String description;
    private String cname;
    private String content;
    private String date;
}
