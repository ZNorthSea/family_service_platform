package com.study.service.base;

import com.study.bean.fc.FcCell;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.velueObject.CellMessage;

import java.util.List;

/**
 * <p>
 * 房间信息表 服务类
 * </p>
 *
 * @author lian
 * @since 2021-05-30
 */
public interface FcCellService extends IService<FcCell> {

    List<FcCell> insertCell(CellMessage[] cellMessages);

    List<FcCell> selectCellByUnit(String unitCode);
}
