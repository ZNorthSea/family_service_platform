package com.study.service.base;

import com.study.bean.tbl.TblUserRecord;

/**
 * @Auther: zhaotj
 * @Date: 2021/5/30 0030 - 05 - 30 - 23:02
 * @Description: com.study.service.base
 * @version: 1.0
 */
public interface LoginServer {

    TblUserRecord login(String username,String password);
}
