package com.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.bean.fc.FcEstate;
import com.study.mapper.FcEstateMapper;
import com.study.service.base.FcEstateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 楼盘信息 服务实现类
 * </p>
 *
 * @since 2021-05-30
 */
@Service
public class FcEstateServiceImpl extends ServiceImpl<FcEstateMapper, FcEstate> implements FcEstateService {
    @Autowired
    private FcEstateMapper fcEstateMapper;
    @Override
    public Integer insertEstate(FcEstate fcEstate) {
        QueryWrapper queryWrapper = new QueryWrapper();
        //根据浏览器请求的房产地址到数据库中查询,如果返回的对象为null,说明为新用户返回1.
        // 如果返回的对象不为空,则说明用户已经存在,返回0
        queryWrapper.eq("estate_code",fcEstate.getEstateCode());
        FcEstate fcEstateFind = fcEstateMapper.selectOne(queryWrapper);
        int result = 0;
        if (null != fcEstateFind){
            return result;
        }else {
            result = fcEstateMapper.insert(fcEstate);
            return result;
        }
    }
}
