package com.xscheck.service.impl;

import com.xscheck.mapper.CourseMapper;
import com.xscheck.pojo.Course;
import com.xscheck.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;

//    动态查询所有的课程
    @Override
    public List<Course> findAllCourse(Course course) {
        return courseMapper.findAllCourse(course);
    }

//    查询课程的总数total
    @Override
    public int findCourseTotal(Course course) {
        return courseMapper.findCourseTotal(course);
    }

//    添加课程
    @Override
    public void addCourse(Course course) {
        courseMapper.addCourse(course);
    }

//    修改课程
    @Override
    public void updateCourse(Course course) {
        courseMapper.updateCourse(course);
    }

//    删除课程
    @Override
    public void deleteCourse(List<Integer> list) {
        for(int i=0;i<list.size();i++) {
            courseMapper.deleteCourse(list.get(i));
        }
    }
//查询所有学年学期
    @Override
    public List<String> getAcadyearterm() {
        return courseMapper.getAcadyearterm();
    }
    //    学生根据学年学期获取自己的课程
    @Override
    public List<Course> getStudentCourse(String majorclass, String acadyearterm) {
        return courseMapper.getStudentCourse(majorclass,acadyearterm);
    }
    //    学生根据学年学期获取自己的课程的总数total
    @Override
    public int getStudentCourseTotal(String majorclass, String acadyearterm) {
        return courseMapper.getStudentCourseTotal(majorclass, acadyearterm);
    }

    @Override
    public List<Course> getTeacherCourse(int tno, String acadyearterm) {
        return courseMapper.getTeacherCourse(tno,acadyearterm);
    }

    @Override
    public int getTeacherCourseTotal(int tno, String acadyearterm) {
        return courseMapper.getTeacherCourseTotal(tno,acadyearterm);
    }
}
