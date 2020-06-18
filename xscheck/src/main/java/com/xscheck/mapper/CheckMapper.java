package com.xscheck.mapper;

import com.xscheck.pojo.Apply;
import com.xscheck.pojo.Check1;
import com.xscheck.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

@Mapper
public interface CheckMapper {
//    提供教师考勤时的班级选择
    @Select("select distinct majorclass from  course where tno=#{tno}")
    List<String> getMajorclass(int tno);
//    提供教师考勤时的课程名选择
    @Select("select distinct coursename from course where tno=#{tno}")
    List<String> getCoursename(int tno);
//    教师选择班级获取将要考勤的学生
    @Select("select * from student where majorclass=#{majorclass}")
    List<Student> getCheckStudent(String majorclass);
//    将将要考勤的学生添加进考勤表
    @Insert("insert into check1(sno,sname,majorclass,checktime,coursename,tname,istruancy,acadyearterm) " +
            "values(#{sno},#{sname},#{majorclass},#{checktime},#{coursename},#{tname},#{istruancy},#{acadyearterm})")
    void addCheckStudent(Check1 check);
    //    获取未请假的考勤学生
    @Select("select * from check1 where majorclass=#{majorclass} and istruancy=#{istruancy}")
    List<Check1> getAllCheckStudent(String majorclass,String istruancy);
    //    获取未请假的考勤学生总数total
    @Select("select count(id) from check1 where majorclass=#{majorclass} and istruancy=#{istruancy}")
    int getAllCheckStudentTotal(String majorclass,String istruancy);
//    查找将要考勤的请假学生
    @Select("select * from apply where majorclass=#{majorclass} and starttime<=#{checktime} and endtime>=#{checktime}")
    List<Apply> getSnoApply(String majorclass, Date checktime);
//    修改考勤表请假学生数据
    @Update("update check1 set istruancy=\"请假\" where sno=#{sno} and istruancy=#{istruancy}")
    void updateCheckApplyStudent(int sno,String istruancy);
//    修改考勤已到的学生
    @Update("update check1 set istruancy=\"已到\" where id=#{id}")
    void updateOkCheck(int id);
//    修改考勤为旷课的学生
    @Update("update check1 set istruancy=\"旷课\" where id=#{id}")
    void updateTruancyCheck(int id);
//    查看请假学生请假详细信息
    @Select("select * from apply where sno=#{sno} and starttime<=#{checktime} and endtime>=#{checktime}")
    Apply getApplyDetail(int sno, Date checktime);
//    相关学生查看的考勤为旷课的信息
    @Select("select * from check1 where sno=#{sno} and acadyearterm=#{acadyearterm} and istruancy=\"旷课\" ")
    List<Check1> getStudentStatistics(int sno,String acadyearterm);
//     相关学生查看的考勤为旷课的信息总数total
    @Select("select count(id) from check1 where sno=#{sno} and acadyearterm=#{acadyearterm} and istruancy=\"旷课\" ")
    int getStudentStatisticsTotal(int sno,String acadyearterm);
//    获取学生考勤为已到的次数
    @Select("select count(id) from check1 where sno=#{sno} and acadyearterm=#{acadyearterm} " +
            "and coursename=#{coursename} and  istruancy=\"已到\"")
    int getArrrivedNum(int sno,String acadyearterm,String coursename);
//    获取学生考勤为请假的学生次数
    @Select("select count(id) from check1 where sno=#{sno} and acadyearterm=#{acadyearterm} " +
            "and coursename=#{coursename} and  istruancy=\"请假\"")
    int getApplyNum(int sno,String acadyearterm,String coursename);
//    获取学生考勤为旷课的学生
    @Select("select count(id) from check1 where sno=#{sno} and acadyearterm=#{acadyearterm} " +
            "and coursename=#{coursename} and istruancy=\"旷课\"")
    int getTruancyNum(int sno,String acadyearterm,String coursename);

    }
