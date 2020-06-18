package com.xscheck.service;

import com.xscheck.pojo.Course;

import java.util.List;

public interface CourseService {
    //    动态查询所有的课程
    List<Course> findAllCourse(Course course);
    //    查询课程total
    int findCourseTotal(Course course);
    //    添加课程
    void addCourse(Course course);
    //    修改课程信息
    void updateCourse(Course course);
    //    删除课程信息
    void deleteCourse(List<Integer> list);
    //    查询所有学年学期
    List<String> getAcadyearterm();
    //    学生根据学年学期获取自己的课程
    List<Course> getStudentCourse(String majorclass,String acadyearterm);
    //    学生根据学年学期获取自己的课程的总数total
    int getStudentCourseTotal(String majorclass,String acadyearterm);
    //    教师根据学年学期获取自己的课程安排
    List<Course> getTeacherCourse(int tno,String acadyearterm);
    //    教师根据学年学期获取自己的课程的总数total
    int getTeacherCourseTotal(int tno,String acadyearterm);
}
