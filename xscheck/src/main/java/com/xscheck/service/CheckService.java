package com.xscheck.service;

import com.xscheck.pojo.Apply;
import com.xscheck.pojo.Check1;
import com.xscheck.pojo.Student;

import java.util.Date;
import java.util.List;

public interface CheckService {
//    提供教师考勤时的班级选择
    List<String> getMajorclass(int tno);
//    提供教师考勤时的课程名选择
    List<String> getCoursename(int tno);
//    教师选择班级获取将要考勤的学生
    List<Student> getCheckStudent(String majorclass);
//    将将要考勤的学生添加进入考勤表
    void  addCheckStudent(Check1 check);
//    获取未请假的考勤学生
    List<Check1> getAllCheckStudent(String majorclass,String istruancy);
    //    获取未请假的考勤学生总数total
    int getAllCheckStudentTotal(String majorclass,String istruancy);
    //    修改考勤表请假学生数据
    void updateCheckApplyStudent(String majorclass,Date checktime);
//    修改考勤已到的学生
    void updateOkCheck(List<Integer> list);
//    修改考勤为旷课的学生
    void updateTruancyCheck(List<Integer> list);
//    查看相关请假学生的请假详细信息
    Apply getApplyDetail(int sno,Date checktime);
//    查找相关学生的考勤信息
    List<Check1> getStudentStatistics(int sno,String acadyearterm);
//     查找相关学生的考勤信息总数total
    int getStudentStatisticsTotal(int sno,String acadyearterm);
//    查询考情表中某学生某门课程的已达到次数
    int getArrivedNum(int sno,String acadyearterm,String coursename);
//    查询考情表中某学生某门课程的请假次数
    int getApplyNum(int sno,String acadyearterm,String coursename);
//    查询考情表中某学生某门课程的旷课次数
    int getTruancyNum(int sno,String acadyearterm,String coursename);
}
