package com.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.bean.fc.FcBuilding;
import com.study.bean.fc.FcEstate;
import com.study.mapper.FcBuildingMapper;
import com.study.service.base.FcBuildingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 楼宇信息表 服务实现类
 * </p>
 *
 * @author lian
 * @since 2021-05-30
 */
@Service
public class FcBuildingServiceImpl extends ServiceImpl<FcBuildingMapper, FcBuilding> implements FcBuildingService {
    @Autowired
    private FcBuildingMapper fcBuildingMapper;
    @Override
    public List<FcBuilding> selectBuilding(Integer buildingNumber, String estateCode) {
        // 创建一个集合，把查询到的FcBuilding对象都放入集合中
        List<FcBuilding> fcBuildings = new ArrayList<>();
        for (int i = 1; i <= buildingNumber; i++) {
            FcBuilding fcBuilding = new FcBuilding();
            fcBuilding.setEstateCode(estateCode);
            fcBuilding.setBuildingCode("B"+i);
            fcBuilding.setBuildingName("第"+i+"号楼");
            fcBuildings.add(fcBuilding);
            fcBuildingMapper.insert(fcBuilding);
        }
        return fcBuildings;

    }
    // 根据id更新楼宇信息
    @Override
    public Integer updateBuilding(FcBuilding fcBuilding) {
        int result = fcBuildingMapper.updateById(fcBuilding);
        return result;
    }

    @Override
    public List<FcBuilding> selectBuildingByEstate(String estateCode) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("estate_code",estateCode);
        queryWrapper.select("building_name","building_code");
        List buildings = fcBuildingMapper.selectList(queryWrapper);
        return buildings;
    }
}
