package com.xscheck.service.impl;


import com.xscheck.mapper.LoginMapper;
import com.xscheck.pojo.Admin;
import com.xscheck.pojo.Student;
import com.xscheck.pojo.Teacher;
import com.xscheck.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

//    根据账号密码查找admin用户
    @Override
    public Admin findAdmin(int lno,String password) {
        return loginMapper.findAdmin(lno, password);}

    @Override
    public void updateAdmin(int adminno) {
        loginMapper.updateAdmin(adminno);
    }
//根据账号密码查找学生用户
    @Override
    public Student findStudent(int lno,String password) {
        return loginMapper.findStudent(lno,password);
    }
//学生修改密码
    @Override
    public void updateStudentPasswd(Student student) {
        loginMapper.updateStudentPasswd(student);
    }

    //根据账号密码查找老师用户
    @Override
    public Teacher findTeacher(int lno, String password) {
        return loginMapper.findTeacher(lno, password);
    }

    @Override
    public void updateTeacherPassword(Teacher teacher) {
        loginMapper.updateTeacherPassword(teacher);
    }
}
