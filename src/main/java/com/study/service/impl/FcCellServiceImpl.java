package com.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.bean.fc.FcCell;
import com.study.mapper.FcCellMapper;
import com.study.service.base.FcCellService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.velueObject.CellMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 房间信息表 服务实现类
 * </p>
 *
 * @author lian
 * @since 2021-05-30
 */
@Service
public class FcCellServiceImpl extends ServiceImpl<FcCellMapper, FcCell> implements FcCellService {

    @Autowired
    private FcCellMapper fcCellMapper;
    @Override
    public List<FcCell> insertCell(CellMessage[] cellMessages) {
        List<FcCell> lists = new ArrayList<>();
        for (CellMessage cellMessage : cellMessages) {
            for (int i = 1; i <= cellMessage.getStopFloor(); i++){
                for (int j = cellMessage.getStartCellId(); j <= cellMessage.getStopCellId(); j++){
                    FcCell fcCell = new FcCell();
                    fcCell.setFloorNumber(i);
                    fcCell.setUnitCode(cellMessage.getUnitCode());
                    fcCell.setCellCode(i+"0"+j);
                    fcCell.setCellName("C"+i+j);
                    fcCellMapper.insert(fcCell);
                    lists.add(fcCell);
                }
            }
        }
        return lists;
    }

    @Override
    public List<FcCell> selectCellByUnit(String unitCode) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("unit_code","unitCode");
        queryWrapper.select("cell_code","cell_name");
        return fcCellMapper.selectList(queryWrapper);
    }
}
