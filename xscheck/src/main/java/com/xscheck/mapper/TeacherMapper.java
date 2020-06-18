package com.xscheck.mapper;

import com.xscheck.pojo.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {
    //动态查询老师信息
   @SelectProvider(type = DynaSql.class,method = "findAllTeacher")
    List<Teacher> findAllTeacher(Teacher teacher);

    //查询total总数
    @SelectProvider(type = DynaSql.class,method = "findTeacherTotal")
    int findTeacherTotal(Teacher teacher);

    //添加老师信息
    @Insert("insert into teacher(tno,tname,sex,phone,password,education,department) values (#{tno},#{tname},#{sex},#{phone},#{password},#{education},#{department})")
    void addTeacher(Teacher teacher);

    //修改老师信息
    @Update("update teacher set tname=#{tname},sex=#{sex},phone=#{phone},education=#{education},department=#{department} where tno=#{tno}")
    int updateTeacher(Teacher teacher);

    //删除老师信息
    @Delete("delete from teacher where tno=#{tno}")
    void deleteTeacher(int tno);


}
