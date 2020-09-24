package com.lll.student.controller;

import com.lll.student.common.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class Test {

    @RequestMapping("/test")
    public void test(){
        String test = "填充占位符";
        log.info("test:{}", test);
        log.info("test2:", test);
        try {
            throw new MyException("主动触发exception");
        }catch (Exception e){
            log.info("test3:{}", test, e);
            log.info("掉", e);
            log.info("test5:{}", e.toString());
        }

    }
}
