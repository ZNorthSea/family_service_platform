package com.study.service.impl;

import com.study.bean.tbl.TblCompany;
import com.study.mapper.TblCompanyMapper;
import com.study.service.base.TblCompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 企业档案 服务实现类
 * </p>
 *
 * @author lian
 * @since 2021-05-30
 */
@Service
public class TblCompanyServiceImpl extends ServiceImpl<TblCompanyMapper, TblCompany> implements TblCompanyService {
    @Autowired
    private TblCompanyMapper tblCompanyMapper;
    @Override
    public List<TblCompany> selectCompany() {
        return tblCompanyMapper.selectCompany() ;
    }
}
