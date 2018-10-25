package com.lyf.mybatisplusstudy.sys.service.impl;

import com.lyf.mybatisplusstudy.sys.entity.Student;
import com.lyf.mybatisplusstudy.sys.mapper.StudentMapper;
import com.lyf.mybatisplusstudy.sys.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2018-10-25
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
