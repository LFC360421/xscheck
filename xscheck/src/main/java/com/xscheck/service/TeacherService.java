package com.xscheck.service;

import com.xscheck.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    //显示所有老师信息
    List<Teacher> findAllTeacher(Teacher teacher);
    //查询total总数
    int findTeacherTotal(Teacher teacher);
    //添加老师信息
    void addTeacher(Teacher teacher);
    //修改老师信息
    void updateTeacher(Teacher teacher);
    //删除老师信息
    void deleteTeacher(List<Integer> list);
}
