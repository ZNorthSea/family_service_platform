package com.study.controller.base;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.api.R;
import com.study.bean.fc.FcBuilding;
import com.study.bean.fc.FcCell;
import com.study.bean.fc.FcEstate;
import com.study.bean.fc.FcUnit;
import com.study.bean.tbl.TblCompany;
import com.study.returnJson.ReturnObject;
import com.study.service.base.*;
import com.study.velueObject.CellMessage;
import com.study.velueObject.UnitMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
        System.out.println("房产插入result = "+result);
        if (result == 1){
            return JSONObject.toJSONString(new ReturnObject("1","房产插入成功"));
        } else {
            return JSONObject.toJSONString(new ReturnObject("0","房产插入失败"));
        }
    }

    @Autowired
    private FcBuildingService fcBuildingService;
    @RequestMapping("/estate/selectBuilding")
    public String selectBuilding(Integer buildingNumber,String estateCode){
        // 获取查询到的fcBuildiing集合
        List<FcBuilding> fcBuildings = fcBuildingService.selectBuilding(buildingNumber,estateCode);
        return JSONObject.toJSONString(new ReturnObject(fcBuildings));
    }

    @RequestMapping("/estate/updateBuilding")
    public String updateBuilding(FcBuilding fcBuilding){
        Integer result = fcBuildingService.updateBuilding(fcBuilding);
        System.out.println("楼宇信息更新result = " + result);
        if (result == 1){
            return JSONObject.toJSONString(new ReturnObject("保存成功"));
        } else {
            return JSONObject.toJSONString(new ReturnObject("保存失败"));
        }
    }

    @Autowired
    private FcUnitService fcUnitService;
    @RequestMapping("/estate/selectUnit")
    public String selectUnit(@RequestBody UnitMessage[] unitMessages){
        List<FcUnit> fcUnits = new ArrayList<>();
        for (UnitMessage unitMessage : unitMessages) {
            fcUnits = fcUnitService.selectUnit(unitMessage);
        }
        return JSONObject.toJSONString(new ReturnObject(fcUnits));
    }

    
    @RequestMapping("/estate/updateUnit")
    public String updateUnit(FcUnit fcUnit){
        Integer result = fcUnitService.updateUnit(fcUnit);
        if (result == 1){
            return JSONObject.toJSONString(new ReturnObject("保存成功"));
        } else {
            return JSONObject.toJSONString(new ReturnObject("保存失败"));
        }
    }

    @Autowired
    private FcCellService fcCellService;
    @RequestMapping("/estate/insertCell")
    public String insertCell(@RequestBody CellMessage[] cellMessages){
        List<FcCell> result = fcCellService.insertCell(cellMessages);
        return JSONObject.toJSONString(new ReturnObject(result));
    }

    @RequestMapping("/estate/selectBuildingByEstate")
    public String selectBuildingByEstate(String estateCode){
        List<FcBuilding> fcEstates = fcBuildingService.selectBuildingByEstate(estateCode);
        return JSONObject.toJSONString(new ReturnObject(fcEstates));
    }

    @RequestMapping("/estate/selectUnitByBuilding")
    public String selectUnitByBuilding(String buildingCode){
        List<FcUnit> fcUnits = fcUnitService.selectUnitByBuilding(buildingCode);
        return JSONObject.toJSONString(new ReturnObject(fcUnits));
    }

    @RequestMapping("/estate/selectCellByUnit")
    public String selectCellByUnit(String unitCode){
        List<FcCell> fcCells = fcCellService.selectCellByUnit(unitCode);
        return JSONObject.toJSONString(new ReturnObject(fcCells));
    }

}
