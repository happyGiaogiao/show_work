package com.codercm.bk.ysk.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Result {

    //响应码
    private int code;
    private int sid;
    private String realname;
    private String avatar;

    public Result(int code) {
        this.code = code;
    }
}
