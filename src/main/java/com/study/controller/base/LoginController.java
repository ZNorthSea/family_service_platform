package com.study.controller.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.study.bean.tbl.TblUserRecord;
import com.study.service.base.LoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: zhaotj
 * @Date: 2021/5/30 0030 - 05 - 30 - 21:07
 * @Description: com.study.controller.base
 * @version: 1.0
 */
@Controller
@CrossOrigin(originPatterns = "*",allowedHeaders = "*",methods = {},allowCredentials = "true")
public class LoginController {
    @Autowired
    private LoginServer loginServer;

    @RequestMapping("/auth/2step-code")
    @ResponseBody
    public boolean test(){
        System.out.println("test");
        return true;
    }
    @RequestMapping("/auth/login")
    @ResponseBody
    public Object login(@RequestParam("username") String username,@RequestParam("password") String password){ ;
        System.out.println(username+"   "+password);
        TblUserRecord tblUserRecord = loginServer.login(username,password);
        System.out.println(tblUserRecord);
        return JSONObject.parse(JSONObject.toJSONString(tblUserRecord));
    }
}
