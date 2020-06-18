package com.xscheck.controller;

import com.xscheck.pojo.Check1;
import com.xscheck.pojo.Statistics;
import com.xscheck.pojo.Student;
import com.xscheck.pojo.Teacher;
import com.xscheck.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StatisticsController {
    @Autowired
    CheckService checkService;

//  学生获取自己的考勤旷课信息
    @RequestMapping("/getStudentStatistics")
    @ResponseBody
    public Map getStudentStatistics(HttpServletRequest request,int page, int rows, String acadyearterm){
        if(acadyearterm==null){
            return null;
        }
        Student student=(Student)request.getSession().getAttribute("student");
        int sno=student.getSno();
        //查询所有数据
        List<Check1> xcs=checkService.getStudentStatistics(sno,acadyearterm);
        //查询总记录数
        int total=checkService.getStudentStatisticsTotal(sno,acadyearterm);
        //展示分页集合
        List<Check1> xcsList=new ArrayList<>();
        for (int i = 0; i < xcs.size(); i++)
        {
            //当前页-1 * 记录数 并且 这条记录是第几页的数据 当前页乘以记录数
            //第一次传过来的rows 是10 page是1
            if (i >= (page - 1) * rows && i < page * rows)
            {
                //符合当前页的数据添加到展示分页集合中
                xcsList.add(xcs.get(i));
            }
        }
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("total", total);
        result.put("rows", xcsList);
        return result;
    }

//    教师获取相关课程学生的考勤信息
    @RequestMapping("/getTeacherStatistics")
    @ResponseBody
    public Map getTeacherStatistics(int page,int rows,String acadyearterm,String majorclass,String coursename) {
        if (acadyearterm == null || majorclass == null || coursename == null) {
            return null;
        }
//        Teacher teacher=(Teacher)request.getSession().getAttribute("teacher");
//        String tname=teacher.getTname();
        //获取数据
        List<Student> list1=checkService.getCheckStudent(majorclass);

        List<Statistics> listState=new ArrayList<>();
        for(int i=0;i<list1.size();i++){
            int arrivedNum=checkService.getArrivedNum(list1.get(i).getSno(),acadyearterm,coursename);
            int applyNum=checkService.getApplyNum(list1.get(i).getSno(),acadyearterm,coursename);
            int truancyNum=checkService.getTruancyNum(list1.get(i).getSno(),acadyearterm,coursename);
            Statistics statistics=new Statistics();
            statistics.setSno(list1.get(i).getSno());
            statistics.setSname(list1.get(i).getSname());
            statistics.setArrivedNum(arrivedNum);
            statistics.setApplyNum(applyNum);
            statistics.setTruancyNum(truancyNum);
            listState.add(statistics);
        }
        //查询总记录数
        int total=listState.size();
        //展示分页集合
        List<Statistics> listRows=new ArrayList<>();
        for (int i = 0; i < listState.size(); i++)
        {
            //当前页-1 * 记录数 并且 这条记录是第几页的数据 当前页乘以记录数
            //第一次传过来的rows 是10 page是1
            if (i >= (page - 1) * rows && i < page * rows)
            {
                //符合当前页的数据添加到展示分页集合中
                listRows.add(listState.get(i));
            }
        }
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("total", total);
        result.put("rows", listRows);
        return result;

    }

}
