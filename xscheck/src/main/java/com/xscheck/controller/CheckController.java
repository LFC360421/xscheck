package com.xscheck.controller;

import com.xscheck.pojo.Apply;
import com.xscheck.pojo.Check1;
import com.xscheck.pojo.Student;
import com.xscheck.pojo.Teacher;
import com.xscheck.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Controller
public class CheckController {
    @Autowired
    CheckService checkService;

//  提供教师考勤时的班级选择
    @ResponseBody
    @RequestMapping("/getMajorclass")
    public List<String> getMajorclass(HttpServletRequest request){
        Teacher teacher=(Teacher)request.getSession().getAttribute("teacher");
        int tno=teacher.getTno();
        List<String> list=checkService.getMajorclass(tno);
        return list;
    }

//  提供教师考勤时的课程名选择
    @ResponseBody
    @RequestMapping("/getCoursename")
    public List<String> getCoursename(HttpServletRequest request){
        Teacher teacher=(Teacher)request.getSession().getAttribute("teacher");
        int tno=teacher.getTno();
        List<String> list=checkService.getCoursename(tno);
//        System.out.println(list);
        return list;
    }

//  获取将要考勤的班级学生
    @ResponseBody
    @RequestMapping("/getCheckStudent")
    public Map getCheckStudent(HttpServletRequest request,int page,int rows,String acadyearterm,String majorclass,String coursename,String istruancy){
        if(majorclass==null && coursename==null){
            return null;
        }
        if(istruancy.equals("未考勤")) {
            //获取登录的老师信息
            Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
            //获取将要考勤的学生
            List<Student> student = checkService.getCheckStudent(majorclass);
            //将将要考勤的学生放入考勤表（check表）
            Check1 check = new Check1();
            for (int i = 0; i < student.size(); i++) {
                check.setSno(student.get(i).getSno());
                check.setSname(student.get(i).getSname());
                check.setMajorclass(majorclass);
                check.setChecktime(new Date());
                check.setCoursename(coursename);
                check.setTname(teacher.getTname());
                check.setIstruancy("未考勤");
                check.setAcadyearterm(acadyearterm);
                //            System.out.println(check);
                checkService.addCheckStudent(check);
            }

            //修改考勤表中请假学生信息
            Date checktime=new Date();
            checkService.updateCheckApplyStudent(majorclass,checktime);
        }

        //查询所有数据
        List<Check1> checks=checkService.getAllCheckStudent(majorclass,istruancy);

        //查询总记录数
        int total=checkService.getAllCheckStudentTotal(majorclass,istruancy);
        //展示分页集合
        List<Check1> list=new ArrayList<>();

        for (int i = 0; i < checks.size(); i++)
        {
            //当前页-1 * 记录数 并且 这条记录是第几页的数据 当前页乘以记录数
            //第一次传过来的rows 是10 page是1
            if (i >= (page - 1) * rows && i < page * rows)
            {
                //符合当前页的数据添加到展示分页集合中
                list.add(checks.get(i));
            }
        }
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
//修改考勤已到的学生
    @RequestMapping("/okCheck")
    @ResponseBody
    public String okCheck(HttpServletRequest request) {
        String[] ids=request.getParameter("idString").split(",");
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < ids.length; i++) {
            list.add(Integer.parseInt(ids[i]));
        }
        checkService.updateOkCheck(list);
        return "1";
    }
//修改考勤为旷课的学生
    @RequestMapping("/truancyCheck")
    @ResponseBody
    public String truancyCheck(HttpServletRequest request) {
        String[] ids=request.getParameter("idString").split(",");
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < ids.length; i++) {
            list.add(Integer.parseInt(ids[i]));
        }
        checkService.updateTruancyCheck(list);
        return "1";
    }
//    教师查看相关学生请假详细信息
    @RequestMapping("/getApplyDetail")
    @ResponseBody
    public Apply getApplyDetail(int sno){
        Date checktime=new Date();
        Apply apply=checkService.getApplyDetail(sno,checktime);
        return apply;
    }


}
