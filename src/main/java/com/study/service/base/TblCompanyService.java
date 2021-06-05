package com.study.service.base;

import com.study.bean.tbl.TblCompany;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 企业档案 服务类
 * </p>
 *
 * @author lian
 * @since 2021-05-30
 */
public interface TblCompanyService extends IService<TblCompany> {

    List<TblCompany> selectCompany();
}
