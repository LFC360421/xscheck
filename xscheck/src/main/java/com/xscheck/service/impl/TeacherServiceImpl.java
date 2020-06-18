package com.xscheck.service.impl;

import com.xscheck.mapper.TeacherMapper;
import com.xscheck.pojo.Teacher;
import com.xscheck.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

//动态查询老师信息
    @Override
    public List<Teacher> findAllTeacher(Teacher teacher) {
        return teacherMapper.findAllTeacher(teacher);
    }
//查询total总数
    @Override
    public int findTeacherTotal(Teacher teacher) {
        return teacherMapper.findTeacherTotal(teacher);
    }
//添加老师信息
    @Override
    public void addTeacher(Teacher teacher) {
         teacherMapper.addTeacher(teacher);
    }
//修改老师信息
    @Override
    public void updateTeacher(Teacher teacher) {
         teacherMapper.updateTeacher(teacher);
    }
//删除老师信息
    @Override
    public void deleteTeacher(List<Integer> list) {
        for(int i=0;i<list.size();i++) {
            teacherMapper.deleteTeacher(list.get(i));
        }
    }
}
