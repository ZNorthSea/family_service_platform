package com.study.mapper;

import com.study.bean.tbl.TblCompany;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 企业档案 Mapper 接口
 * </p>
 *
 * @author lian
 * @since 2021-05-30
 */
@Component
public interface TblCompanyMapper extends BaseMapper<TblCompany> {

    List<TblCompany> selectCompany();
}
