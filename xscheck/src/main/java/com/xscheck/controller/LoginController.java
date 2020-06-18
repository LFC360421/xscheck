package com.xscheck.controller;

import com.xscheck.pojo.Admin;
import com.xscheck.pojo.Student;
import com.xscheck.pojo.Teacher;
import com.xscheck.service.LoginService;
import com.xscheck.utils.CodeMsg;
import com.xscheck.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
public class LoginController{
    @Autowired
    LoginService loginService;

//   登录处理
   @ResponseBody
   @RequestMapping("/login")
    public String login(HttpServletRequest request, int lno, String password, String role) {
        if (role.equals("管理员")) {
            Admin admin = loginService.findAdmin(lno, password);
            if (admin != null) {
                //把id保存进session，在后面的文章发表、评论发表时候会用到
                HttpSession session = request.getSession();
                session.setAttribute("admin",admin);
                return "1";
            }
        }
        if (role.equals("学生")) {
            Student student=loginService.findStudent(lno,password);
//            System.out.println(student.getSname());
            if (student != null) {
                HttpSession session = request.getSession();
                session.setAttribute("student",student);
                return "2";
            }

        }
        if (role.equals("教师")) {
            Teacher teacher=loginService.findTeacher(lno, password);
            if (teacher != null) {
                HttpSession session = request.getSession();
                session.setAttribute("teacher",teacher);
                return "3";
            }
        }

      return "-1";
    }

//    获取登录人信息
    @ResponseBody
    @RequestMapping("/login_message")
    public Map login_message(HttpServletRequest request){
       HttpSession session=request.getSession();
       Admin admin=(Admin)session.getAttribute("admin") ;
       Student student=(Student)session.getAttribute("student");
       Teacher teacher=(Teacher)session.getAttribute("teacher");
       Map<String,Object> result = new HashMap<String,Object>();
       result.put("admin",admin);
       result.put("student",student);
       result.put("teacher",teacher);
       return result;
    }
//跳转管理员主页
    @RequestMapping("/admin_main")
    public String admin_main(){
       return "admin/admin_main";
    }

//    测试页面
    @RequestMapping("/hi")
    public String sayHello() {
//       HttpSession session = request.getSession();
//       Student student=(Student)session.getAttribute("student");
//       System.out.println(student);
//       session.setAttribute("student_sname",student.getSname());
       return "admin/hello";
    }

    //  跳转管理员下管理员信息管理页面
    @RequestMapping("/admin_admin")
    public String admin_admin() {
        return "admin/admin_admin";
    }
//    跳转管理员下的学生信息管理页面
    @RequestMapping("/a1")
    public String a1() {
        return "admin/admin_student";
    }
//  跳转管理员下教师信息管理页面
    @RequestMapping("/a2")
    public String a2() {
        return "admin/admin_teacher";
    }
//跳转管理员下课程管理页面
    @RequestMapping("/a3")
    public String a3() {
        return "admin/admin_course";
    }
//跳转管理员下请假管理页面
    @RequestMapping("/a4")
    public String a4() {
        return "admin/admin_apply";
    }
//    跳转管理员下的考勤统计页面
    @RequestMapping("/admin_statistics")
    public String admin_statistics(){
        return "/admin/admin_statistics";
    }


//跳转学生主页
    @RequestMapping("/student_main")
    public String student_main(){
        return "student/student_main";
    }
//    跳转学生下的学生个人信息管理页面
    @RequestMapping("/student_message")
    public String student_message(){
       return "student/student_message";
    }
//跳转学生下的课程管理页面
    @RequestMapping("/student_course")
    public String student_course(){
       return "/student/student_course";
    }
//    跳转学生请假页面
    @RequestMapping("/student_apply")
    public String student_apply(){
       return "/student/student_apply";
    }
//    跳转学生下的考勤统计页面
    @RequestMapping("/student_statistics")
    public String student_statistics(){
       return "/student/student_statistics";
    }

//   跳转老师主页
    @RequestMapping("/teacher_main")
    public String teacher_main(){
       return "teacher/teacher_main";
    }
//    跳转教师下的个人信息页面
    @RequestMapping("/teacher_message")
    public String teacher_message(){
       return "/teacher/teacher_message";
    }
//    跳转教师下课程安排页面
    @RequestMapping("/teacher_course")
    public String teacher_course(){
       return "teacher/teacher_course";
    }
//    跳转教师下课堂考勤页面
    @RequestMapping("/teacher_check")
    public String teacher_check(){
        return "teacher/teacher_check";
    }
//    跳转老师下的考勤统计页面
    @RequestMapping("/teacher_statistics")
    public String teacher_statistics(){
        return "/teacher/teacher_statistics";
    }

//    回跳登录主页
    @RequestMapping("/index")
    public String index(HttpServletRequest request){
       HttpSession session=request.getSession();
       session.removeAttribute("admin");
       session.removeAttribute("student");
       session.removeAttribute("teacher");
       return "index";
    }
}
