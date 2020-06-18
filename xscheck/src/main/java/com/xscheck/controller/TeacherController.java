package com.xscheck.controller;

import com.xscheck.pojo.Teacher;
import com.xscheck.service.LoginService;
import com.xscheck.service.TeacherService;
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
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    LoginService loginService;

    //   查询老师
    @ResponseBody
    @RequestMapping("/getAllTeacher")
    public Map getAllTeacher(int page, int rows, Teacher teacher){
//        System.out.println(teacher.getTno()+teacher.getDepartment());
        //查询所有数据
        List<Teacher> ts=teacherService.findAllTeacher(teacher);

        //查询总记录数
        int total=teacherService.findTeacherTotal(teacher);
        //展示分页集合
        List<Teacher> tsList=new ArrayList<>();

        for (int i = 0; i < ts.size(); i++)
        {
            //当前页-1 * 记录数 并且 这条记录是第几页的数据 当前页乘以记录数
            //第一次传过来的rows 是10 page是1
            if (i >= (page - 1) * rows && i < page * rows)
            {
                //符合当前页的数据添加到展示分页集合中
               tsList.add(ts.get(i));
            }
        }
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("total", total);
        result.put("rows", tsList);
        return result;
    }

    //添加老师
    @ResponseBody
    @RequestMapping("/addTeacher")
    public String addTeacher(Teacher teacher){
       teacher.setPassword( String.valueOf(teacher.getTno()));
       teacherService.addTeacher(teacher);
        return "1";
    }
    // 删除老师信息
    @RequestMapping("/deleteTeacher")
    @ResponseBody
    public String deleteTeacher(HttpServletRequest request) {
        String[] ids=request.getParameter("idString").split(",");
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < ids.length; i++) {
            list.add(Integer.parseInt(ids[i]));
        }
       teacherService.deleteTeacher(list);
        return "1";
    }
    //修改老师信息
    @ResponseBody
    @RequestMapping("/updateTeacher")
    public String updateTeacher(Teacher teacher){
       teacherService.updateTeacher(teacher);
        return "1";
    }

    //    老师修改密码
    @ResponseBody
    @RequestMapping("/modifyTeacherPasswd")
    public String modifyTeacherPasswd(HttpServletRequest request,String oldPassword,String newPassword){
        Teacher teacher=(Teacher)request.getSession().getAttribute("teacher");
        if(!teacher.getPassword().equals(oldPassword)){
            return "1";
        }
        teacher.setPassword(newPassword);
        System.out.println(teacher);
        loginService.updateTeacherPassword(teacher);
        return "2";

    }
}
