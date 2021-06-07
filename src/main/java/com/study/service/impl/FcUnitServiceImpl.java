package com.study.service.impl;

import com.study.bean.fc.FcUnit;
import com.study.mapper.FcUnitMapper;
import com.study.service.base.FcUnitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.velueObject.UnitMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 单元信息表 服务实现类
 * </p>
 *
 * @author lian
 * @since 2021-05-30
 */
@Service
public class FcUnitServiceImpl extends ServiceImpl<FcUnitMapper, FcUnit> implements FcUnitService {
    @Autowired
    private FcUnitMapper fcUnitMapper;
    @Override
    public List<FcUnit> selectUnit(UnitMessage unitMessage) {
        // 定义返回值集合 并往里面添加FcUnite对象
        List<FcUnit> fcUnits = new ArrayList<>();
        for (int i = 1; i <= unitMessage.getUnitCount();i++) {
            // 先向集合中添加数据，然后返回对象 ==> 查询功能的实现
            FcUnit fcUnit = new FcUnit();
            fcUnit.setBuildingCode(unitMessage.getBuildingCode());
            fcUnit.setUnitCode("U"+i);
            fcUnit.setUnitName("第"+i+"单元");
            fcUnitMapper.insert(fcUnit);
            fcUnits.add(fcUnit);
        }
        return fcUnits;
    }

    @Override
    public Integer updateUnit(FcUnit fcUnit) {
        int result = fcUnitMapper.updateById(fcUnit);
        return result;
    }
}
