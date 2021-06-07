package com.study.service.base;

import com.study.bean.fc.FcUnit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.velueObject.UnitMessage;

import java.util.List;

/**
 * <p>
 * 单元信息表 服务类
 * </p>
 *
 * @author lian
 * @since 2021-05-30
 */
public interface FcUnitService extends IService<FcUnit> {

    List<FcUnit> selectUnit(UnitMessage unitMessage);

    Integer updateUnit(FcUnit fcUnit);
}
