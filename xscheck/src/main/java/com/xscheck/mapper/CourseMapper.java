package com.xscheck.mapper;

import com.xscheck.pojo.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {
//    动态查询所有的课程
    @SelectProvider(type = DynaSql.class,method = "findAllCourse")
    List<Course> findAllCourse(Course course);

//    查询课程total
    @SelectProvider(type = DynaSql.class,method = "findCourseTotal")
    int findCourseTotal(Course course);

//    添加课程
    @Insert("insert into course(coursename,majorclass,tname,schedule,credit,period,type,acadyearterm) " +
            "values(#{coursename},#{majorclass},#{tname},#{schedule},#{credit},#{period},#{type},#{acadyearterm})")
    void addCourse(Course course);

//    修改课程信息
    @Update("update course set coursename=#{coursename},majorclass=#{majorclass},tname=#{tname},schedule=#{schedule}," +
            "credit=#{credit},period=#{period},type=#{type},acadyearterm=#{acadyearterm} where id=#{id}")
    void updateCourse(Course course);

//    删除课程信息
    @Delete("delete from course where id=#{id}")
    void deleteCourse(int id);

//    查询所有学年学期
    @Select("select distinct acadyearterm from course")
    List<String> getAcadyearterm();

//    学生根据学年学期获取自己的课程
    @Select("select * from course where majorclass=#{majorclass} and acadyearterm=#{acadyearterm}")
    List<Course> getStudentCourse(String majorclass,String acadyearterm);
//    学生根据学年学期获取自己的课程的总数total
    @Select("select count(id) from course where majorclass=#{majorclass} and acadyearterm=#{acadyearterm}")
    int getStudentCourseTotal(String majorclass,String acadyearterm);

    //   教师根据学年学期获取自己的课程安排
    @Select("select * from course where tno=#{tno} and acadyearterm=#{acadyearterm}")
    List<Course> getTeacherCourse(int tno,String acadyearterm);
    //    教师根据学年学期获取自己的课程的总数total
    @Select("select count(id) from course where tno=#{tno} and acadyearterm=#{acadyearterm}")
    int getTeacherCourseTotal(int tno,String acadyearterm);
}
