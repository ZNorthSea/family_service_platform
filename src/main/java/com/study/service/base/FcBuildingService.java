package com.study.service.base;

import com.study.bean.fc.FcBuilding;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.bean.fc.FcEstate;

import java.util.List;

/**
 * <p>
 * 楼宇信息表 服务类
 * </p>
 *
 * @author lian
 * @since 2021-05-30
 */
public interface FcBuildingService extends IService<FcBuilding> {

    List<FcBuilding> selectBuilding(Integer buildingNumber, String estateCode);

    Integer updateBuilding(FcBuilding fcBuilding);

    List<FcBuilding> selectBuildingByEstate(String estateCode);
}
