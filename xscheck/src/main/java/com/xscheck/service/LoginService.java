package com.xscheck.service;

import com.xscheck.pojo.Admin;
import com.xscheck.pojo.Student;
import com.xscheck.pojo.Teacher;

public interface LoginService {
//    根据账号密码查找admin用户
    Admin findAdmin(int lno,String password);
    void updateAdmin(int adminno);
//    根据账号密码查找学生用户
    Student findStudent(int lno,String password);
//    学生修改密码
    void updateStudentPasswd(Student student);
//    根据账号密码查找老师用户
    Teacher findTeacher(int lno,String password);
//    老师修改密码
    void updateTeacherPassword(Teacher teacher);
}
