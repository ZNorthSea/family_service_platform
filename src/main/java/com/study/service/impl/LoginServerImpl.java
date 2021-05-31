package com.study.service.impl;

import com.study.bean.tbl.TblUserRecord;
import com.study.mapper.TblUserRecordMapper;
import com.study.service.base.LoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: zhaotj
 * @Date: 2021/5/30 0030 - 05 - 30 - 23:03
 * @Description: com.study.service.impl
 * @version: 1.0
 */
@Service
public class LoginServerImpl implements LoginServer {
    @Autowired
    private TblUserRecordMapper tblUserRecordMapper;
    @Override
    public TblUserRecord login(String username,String password) {
        TblUserRecord tblUserRecord = tblUserRecordMapper.login(username,password);
        System.out.println(tblUserRecord);
        return tblUserRecord;
    }
}
