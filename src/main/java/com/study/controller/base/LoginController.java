package com.study.controller.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.study.bean.tbl.TblUserRecord;
import com.study.returnJson.Permission;
import com.study.returnJson.Permissions;
import com.study.returnJson.ReturnObject;
import com.study.returnJson.UserInfo;
import com.study.service.base.LoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: zhaotj
 * @Date: 2021/5/30 0030 - 05 - 30 - 21:07
 * @Description: com.study.controller.base
 * @version: 1.0
 */
@RestController
@CrossOrigin(originPatterns = "*",allowedHeaders = "*",methods = {},allowCredentials = "true")
public class LoginController {
    @Autowired
    private LoginServer loginServer;

    @RequestMapping("/auth/2step-code")
    public boolean test(){
        return true;
    }
    @RequestMapping("/auth/login")
    @ResponseBody
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){ ;
        TblUserRecord tblUserRecord = loginServer.login(username,password);
        tblUserRecord.setToken(tblUserRecord.getUserName());
        //获取session,并将用户数据写入到session中
        session.setAttribute("userRecord",tblUserRecord);
        ReturnObject returnObject = new ReturnObject(tblUserRecord);
        return JSONObject.toJSONString(returnObject);
    }

    @RequestMapping("/user/info")
    public String getInfo(HttpSession session){
        //获取模块信息
        TblUserRecord tblUserRecord = (TblUserRecord) session.getAttribute("userRecord");
        //截取权限
        String[] split = tblUserRecord.getTblRole().getRolePrivileges().split("-");
        //创建权限集合对象
        Permissions permissions = new Permissions();
        //向权限集合中添加权限
        List<Permission> permissionList = new ArrayList<>();
        for (String s : split) {
            permissionList.add(new Permission(s));
        }
        permissions.setPermissions(permissionList);
        //创建result对象结果集 并将权限集合对象注入
        UserInfo userInfo = new UserInfo(tblUserRecord.getUserName(),permissions);
        ReturnObject returnObject = new ReturnObject(userInfo);
        return JSONObject.toJSONString(returnObject);
    }
    @RequestMapping("/auth/logout")
    public void loginOut(HttpSession session){
        System.out.println("loginOut");
        session.invalidate();
    }
}
