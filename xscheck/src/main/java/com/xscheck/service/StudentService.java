package com.xscheck.service;

import com.xscheck.pojo.Student;

import java.util.List;

public interface StudentService {
    //显示所有学生信息
    List<Student> findAllStudent(Student student);
    //查询total总数
    int findStudentTotal(Student student);
    //添加学生信息
    void addStudent(Student student);
    //修改学生信息
    void updateStudent(Student student);
    //删除学生信息
    void deleteStudent(List<Integer> list);
    //导出学生的信息
    List<Student> dataStudent();
}
