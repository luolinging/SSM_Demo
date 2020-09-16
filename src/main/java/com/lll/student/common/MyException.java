package com.lll.student.common;

import lombok.Data;

/**
 * @author luo
 */
@Data
public class MyException extends RuntimeException {

    private String code;

    private String message;

    public MyException(String code, String message){
        this.setCode(code);
        this.setMessage(message);
    }

    public MyException(String message){
        this.setCode("-1");
        this.setMessage(message);
    }
}
