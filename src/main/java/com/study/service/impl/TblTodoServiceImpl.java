package com.study.service.impl;

import com.study.bean.tbl.TblTodo;
import com.study.mapper.TblTodoMapper;
import com.study.service.TblTodoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 待办事项 服务实现类
 * </p>
 *
 * @author lian
 * @since 2021-05-30
 */
@Service
public class TblTodoServiceImpl extends ServiceImpl<TblTodoMapper, TblTodo> implements TblTodoService {

}
