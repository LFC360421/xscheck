package com.xscheck.mapper;

import com.xscheck.pojo.Apply;
import com.xscheck.pojo.Course;
import com.xscheck.pojo.Student;
import com.xscheck.pojo.Teacher;
import org.apache.ibatis.jdbc.SQL;

public class DynaSql {
    //根据传过来的参数动态构建sql语句
//    动态查找所有的学生
    public String findAllStudent(Student student){
        return new SQL(){{
            //关键字是区分大小写的  SQL SELECT WHERE
            SELECT("*");
            FROM("student");
            if(student.getSno()!=null){
                WHERE("sno=#{sno}");
            }
            if(null!=student.getMajorclass()&&""!=student.getMajorclass()){
                WHERE("majorclass=#{majorclass}");
            }
        }}.toString();
    }
//    动态查找所有的学生total
    public String findStudentTotal(Student student){
        return new SQL(){{
            //关键字是区分大小写的  SQL SELECT WHERE
            SELECT("count(sno)");
            FROM("student");
            if(student.getSno()!=null){
                WHERE("sno=#{sno}");
            }
            if(null!=student.getMajorclass()&&""!=student.getMajorclass()){
                WHERE("majorclass=#{majorclass}");
            }
        }}.toString();
    }
//    动态查找所有的老师
    public String findAllTeacher(Teacher teacher){
        return new SQL(){{
            //关键字是区分大小写的  SQL SELECT WHERE
            SELECT("*");
            FROM("teacher");
            if(teacher.getTno()!=null){
                WHERE("tno=#{tno}");
            }
            if(null!=teacher.getDepartment()&&""!=teacher.getDepartment()){
                WHERE("department=#{department}");
            }
        }}.toString();
    }
//    动态查找老师total
    public String findTeacherTotal(Teacher teacher){
        return new SQL(){{
            //关键字是区分大小写的  SQL SELECT WHERE
            SELECT("count(tno)");
            FROM("teacher");
            if(teacher.getTno()!=null){
                WHERE("tno=#{tno}");
            }
            if(null!=teacher.getDepartment()&&""!=teacher.getDepartment()){
                WHERE("department=#{department}");
            }
        }}.toString();
    }
//动态查找所有的课程
    public String findAllCourse(Course course){
        return new SQL(){{
            SELECT("*");
            FROM("course");
            if(null!=course.getCoursename()&&""!=course.getCoursename()){
                WHERE("coursename=#{coursename}");
            }
            if(null!=course.getMajorclass()&&""!=course.getMajorclass()){
                WHERE("department=#{department}");
            }
            if(null!=course.getAcadyearterm()&&""!=course.getAcadyearterm()){
                WHERE("acadyearterm=#{acadyearterm}");
            }
        }}.toString();
    }
//    查找课程total
    public String findCourseTotal(Course course){
        return new SQL(){{
            SELECT("count(id)");
            FROM("course");
            if(null!=course.getCoursename()&&""!=course.getCoursename()){
                WHERE("coursename=#{coursename}");
            }
            if(null!=course.getMajorclass()&&""!=course.getMajorclass()){
                WHERE("department=#{department}");
            }
            if(null!=course.getAcadyearterm()&&""!=course.getAcadyearterm()){
                WHERE("acadyearterm=#{acadyearterm}");
            }
        }}.toString();
    }

//    动态查找所有的申请
    public String findAllApply(Apply apply){
        return new SQL(){{
            SELECT("*");
            FROM("apply");
            if(null!=apply.getSno()){
                WHERE("sno=#{sno}");
            }
            if(null!=apply.getMajorclass()&&""!=apply.getMajorclass()){
                WHERE("majorclass=#{majorclass}");
            }
            if(null!=apply.getIsagree()&&""!=apply.getIsagree()){
                WHERE("isagree=#{isagree}");
            }
        }}.toString();
    }
//    查询申请总数total
    public String findApplyTotal(Apply apply){
        return new SQL(){{
            SELECT("count(id)");
            FROM("apply");
            if(null!=apply.getSno()){
                WHERE("sno=#{sno}");
            }
            if(null!=apply.getMajorclass()&&""!=apply.getMajorclass()){
                WHERE("majorclass=#{majorclass}");
            }
            if(null!=apply.getIsagree()&&""!=apply.getIsagree()){
                WHERE("isagree=#{isagree}");
            }
        }}.toString();
    }
}
