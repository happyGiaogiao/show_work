package com.codercm.bk.ysk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Project {
    private int pid;
    private int sid;
//    private String address;
    private String title;
    private String description;
    private String cname;
    private String content;
    private String date;
}
