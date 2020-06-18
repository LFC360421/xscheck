package com.xscheck.controller;

import com.xscheck.pojo.Course;
import com.xscheck.pojo.Student;
import com.xscheck.pojo.Teacher;
import com.xscheck.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CourseController {
    @Autowired
    CourseService courseService;

//    查询所有的课程
    @RequestMapping("/getAllCourse")
    @ResponseBody
    public Map getAllStudent(int page, int rows, Course course){
        //查询所有数据
        List<Course> cs=courseService.findAllCourse(course);

        //查询总记录数
        int total=courseService.findCourseTotal(course);
        //展示分页集合
        List<Course> csList=new ArrayList<>();

        for (int i = 0; i < cs.size(); i++)
        {
            //当前页-1 * 记录数 并且 这条记录是第几页的数据 当前页乘以记录数
            //第一次传过来的rows 是10 page是1
            if (i >= (page - 1) * rows && i < page * rows)
            {
                //符合当前页的数据添加到展示分页集合中
                csList.add(cs.get(i));
            }
        }
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("total", total);
        result.put("rows", csList);
        return result;
    }

    //添加课程
    @ResponseBody
    @RequestMapping("/addCourse")
    public String addCourse(Course course){
        System.out.println(course);
        courseService.addCourse(course);
        return "1";
    }
    // 删除课程信息
    @RequestMapping("/deleteCourse")
    @ResponseBody
    public String deleteCourse(HttpServletRequest request) {
        String[] ids=request.getParameter("idString").split(",");
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < ids.length; i++) {
            list.add(Integer.parseInt(ids[i]));
        }
        courseService.deleteCourse(list);
        return "1";
    }
    //修改课程信息
    @ResponseBody
    @RequestMapping("/updateCourse")
    public String updateStudent(Course course){
      courseService.updateCourse(course);
      return "1";
    }

//    查询所有的学年学期数据
    @ResponseBody
    @RequestMapping("/getAcadyearterm")
    public List<String> getAcadyearterm(){
        List<String> list=courseService.getAcadyearterm();
        return list;
    }

//    学生查询自己的课程安排
    @ResponseBody
    @RequestMapping("/getStudentCourse")
    public Map getStudentCourse(HttpServletRequest request,int page, int rows,String acadyearterm){
        if(acadyearterm==null){
            return null;
        }
        Student student=(Student) request.getSession().getAttribute("student");
        String majorclass=student.getMajorclass();
        //查询所有数据
        List<Course> xcs=courseService.getStudentCourse(majorclass,acadyearterm);

        //查询总记录数
        int total=courseService.getStudentCourseTotal(majorclass,acadyearterm);
        //展示分页集合
        List<Course> xcsList=new ArrayList<>();

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

    //   教师查询自己的授课安排
    @ResponseBody
    @RequestMapping("/getTeacherCourse")
    public Map getTeacherCourse(HttpServletRequest request,int page, int rows,String acadyearterm){
        if(acadyearterm==null){
            return null;
        }
        Teacher teacher =(Teacher)request.getSession().getAttribute("teacher");
        int tno=teacher.getTno();
        //查询所有数据
        List<Course> tcs=courseService.getTeacherCourse(tno,acadyearterm);

        //查询总记录数
        int total=courseService.getTeacherCourseTotal(tno,acadyearterm);
        //展示分页集合
        List<Course> tcsList=new ArrayList<>();

        for (int i = 0; i < tcs.size(); i++)
        {
            //当前页-1 * 记录数 并且 这条记录是第几页的数据 当前页乘以记录数
            //第一次传过来的rows 是10 page是1
            if (i >= (page - 1) * rows && i < page * rows)
            {
                //符合当前页的数据添加到展示分页集合中
                tcsList.add(tcs.get(i));
            }
        }
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("total", total);
        result.put("rows", tcsList);
        return result;

    }
}
