package com.study.controller.base;

import com.alibaba.fastjson.JSONObject;
import com.study.bean.fc.FcEstate;
import com.study.bean.tbl.TblCompany;
import com.study.returnJson.ReturnObject;
import com.study.service.base.FcEstateService;
import com.study.service.base.TblCompanyService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: zhaotj
 * @Date: 2021/6/2 0002 - 06 - 02 - 12:33
 * @Description: com.study.controller.base
 * @version: 1.0
 */
@RestController
@CrossOrigin(originPatterns = "*",allowedHeaders = "*",methods = {},allowCredentials = "true")
public class EstateController {
    @Autowired
    private TblCompanyService tblCompanyService;
    @RequestMapping("/estate/selectCompany")
    public String selectCompany(){
        List<TblCompany> tblCompanies =  tblCompanyService.selectCompany();
        return JSONObject.toJSONString(new ReturnObject(tblCompanies));
    }

    @Autowired
    private FcEstateService fcEstateService;
    @RequestMapping("/estate/insertEstate")
    public String insertEstate(FcEstate fcEstate){
        int result = fcEstateService.insertEstate(fcEstate);
        System.out.println("result = "+result);
        if (result == 1){
            return JSONObject.toJSONString(new ReturnObject("1","房产插入成功"));
        } else {
            return JSONObject.toJSONString(new ReturnObject("0","房产插入失败"));
        }
    }

}
