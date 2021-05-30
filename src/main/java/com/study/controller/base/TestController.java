package com.study.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: zhaotj
 * @Date: 2021/5/30 0030 - 05 - 30 - 21:07
 * @Description: com.study.controller.base
 * @version: 1.0
 */
@Controller
public class TestController {
    @RequestMapping("/auth/login")
    @ResponseBody
    public String test(){
        System.out.println("test");
        return "1";
    }
}
