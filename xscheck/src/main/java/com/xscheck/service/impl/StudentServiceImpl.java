package com.xscheck.service.impl;

import com.xscheck.mapper.StudentMapper;
import com.xscheck.pojo.Student;
import com.xscheck.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    //显示所有学生信息
    @Override
    public List<Student> findAllStudent(Student student) {
        return studentMapper.findAllStudent(student);
    }

    //查询total总数
    @Override
    public int findStudentTotal(Student student) {
        return studentMapper.findStudentTotal(student);
    }

    //添加学生信息
    @Override
    public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }

    //修改学生信息
    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }
    //删除学生信息
    @Override
    public void deleteStudent(List<Integer> list) {
        for(int i=0;i<list.size();i++) {
            studentMapper.deleteStudent(list.get(i));
        }
    }

    @Override
    public List<Student> dataStudent() {
        return studentMapper.dataStudent();
    }
}
