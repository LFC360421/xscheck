package com.xscheck.mapper;


import com.xscheck.pojo.Admin;
import com.xscheck.pojo.Student;
import com.xscheck.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface LoginMapper {
//    根据账号密码查找admin用户
    @Select("select adminno,password from admin where adminno=#{lno} and password=#{password}")
    Admin findAdmin(int lno,String password);
//  管理员用户修改密码
    @Update("update admin set password=#{password} where adminno=#{adminno}")
    int updateAdmin(int adminno);
//根据账号密码查找学生用户
    @Select("select sno,sname,sex,password,phone,majorclass from student where sno=#{lno} and password=#{password}")
    Student findStudent(int lno,String password);
//    学生修改密码
    @Update("update student set password=#{password} where sno=#{sno}")
    void updateStudentPasswd(Student student);
// 根据账号密码查找老师用户
    @Select("select tno,tname,sex,password,phone,education,department from teacher where tno=#{lno} and password=#{password}")
    Teacher findTeacher(int lno,String password);
//  老师修改密码
    @Update("update teacher set password=#{password} where tno=#{tno}")
    void updateTeacherPassword(Teacher teacher);

}
