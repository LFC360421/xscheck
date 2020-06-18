package com.xscheck.service.impl;

import com.xscheck.mapper.CheckMapper;
import com.xscheck.pojo.Apply;
import com.xscheck.pojo.Check1;
import com.xscheck.pojo.Student;
import com.xscheck.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CheckServiceImpl implements CheckService {
    @Autowired
    CheckMapper checkMapper;

//    提供教师考勤时的班级选择
    @Override
    public List<String> getMajorclass(int tno) {
        return checkMapper.getMajorclass(tno);
    }

//提供教师考勤时的课程名选择
    @Override
    public List<String> getCoursename(int tno) {
        return checkMapper.getCoursename(tno);
    }

    @Override
    public List<Student> getCheckStudent(String majorclass) {
        return checkMapper.getCheckStudent(majorclass);
    }

    @Override
    public void addCheckStudent(Check1 check) {
        checkMapper.addCheckStudent(check);
    }

    @Override
    public List<Check1> getAllCheckStudent(String majorclass,String istruancy) {
        if(istruancy.equals("请假")){
            Date checktime=new Date();
            List<Apply> list=checkMapper.getSnoApply(majorclass,checktime);
            List<Check1> check1s=new ArrayList<>();
            for(int i=0;i<list.size();i++){
                Check1 check1=new Check1();
                check1.setSno(list.get(i).getSno());
                check1.setSname(list.get(i).getSname());
                check1.setIstruancy("请假");
                check1s.add(check1);
            }
            return check1s;
        }
        return checkMapper.getAllCheckStudent(majorclass,istruancy);
    }

    @Override
    public int getAllCheckStudentTotal(String majorclass,String istruancy) {
        if(istruancy.equals("请假")){
            Date checktime=new Date();
            List<Apply> list=checkMapper.getSnoApply(majorclass,checktime);
            return list.size();
        }
        return checkMapper.getAllCheckStudentTotal(majorclass,istruancy);
    }

    //    修改考勤表请假学生数据
    @Override
    public void updateCheckApplyStudent(String majorclass, Date checktime) {
        List<Apply> lists=checkMapper.getSnoApply(majorclass, checktime);
//        System.out.println(listSno);
        for(int i=0;i<lists.size();i++) {
            int sno=lists.get(i).getSno();
            String istruancy="未考勤";
            checkMapper.updateCheckApplyStudent(sno,istruancy);
        }
    }
// 修改考勤已到的学生
    @Override
    public void updateOkCheck(List<Integer> list) {
        for(int i=0;i<list.size();i++){
            checkMapper.updateOkCheck(list.get(i));
        }
    }
//修改考勤为旷课的学生
    @Override
    public void updateTruancyCheck(List<Integer> list) {
        for(int i=0;i<list.size();i++){
            checkMapper.updateTruancyCheck(list.get(i));
        }
    }

    @Override
    public Apply getApplyDetail(int sno, Date checktime) {
        return checkMapper.getApplyDetail(sno, checktime);
    }

    @Override
    public List<Check1> getStudentStatistics(int sno, String acadyearterm) {
        return checkMapper.getStudentStatistics(sno,acadyearterm);
    }

    @Override
    public int getStudentStatisticsTotal(int sno, String acadyearterm) {

        return checkMapper.getStudentStatisticsTotal(sno,acadyearterm);
    }

    @Override
    public int getArrivedNum(int sno, String acadyearterm, String coursename) {
        return checkMapper.getArrrivedNum(sno, acadyearterm, coursename);
    }

    @Override
    public int getApplyNum(int sno, String acadyearterm, String coursename) {
        return checkMapper.getApplyNum(sno, acadyearterm, coursename);
    }

    @Override
    public int getTruancyNum(int sno, String acadyearterm, String coursename) {
        return checkMapper.getTruancyNum(sno, acadyearterm, coursename);
    }

}
