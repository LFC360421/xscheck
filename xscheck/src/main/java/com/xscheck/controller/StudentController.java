package com.xscheck.controller;

import com.xscheck.pojo.Student;
import com.xscheck.service.LoginService;
import com.xscheck.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    LoginService loginService;

//   查询学生
    @ResponseBody
    @RequestMapping("/getAllStudent")
    public Map getAllStudent(int page,int rows,Student student){
//       System.out.println(student.getSno()+student.getMajorclass());
        //查询所有数据
        List<Student> xs=studentService.findAllStudent(student);
//        System.out.println(xs);
        //查询总记录数
        int total=studentService.findStudentTotal(student);
        //展示分页集合
        List<Student> xsList=new ArrayList<>();
        for (int i = 0; i < xs.size(); i++)
        {
            //当前页-1 * 记录数 并且 这条记录是第几页的数据 当前页乘以记录数
            //第一次传过来的rows 是10 page是1
            if (i >= (page - 1) * rows && i < page * rows)
            {
                //符合当前页的数据添加到展示分页集合中
                xsList.add(xs.get(i));
            }
        }
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("total", total);
        result.put("rows", xsList);
        return result;
    }

//添加学生
    @ResponseBody
    @RequestMapping("/addStudent")
    public String addStudent(Student student){
        student.setPassword( String.valueOf(student.getSno()));
        studentService.addStudent(student);

        return "{\"status\":\"ok\"}";
    }
// 删除学生
    @RequestMapping("/deleteStudent")
    @ResponseBody
    public String deleteStudent(HttpServletRequest request) {
        String[] ids=request.getParameter("idString").split(",");
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < ids.length; i++) {
            list.add(Integer.parseInt(ids[i]));
        }
        studentService.deleteStudent(list);
        return "1";
    }
//修改学生信息
    @ResponseBody
    @RequestMapping("/updateStudent")
    public String updateStudent(Student student){
//        System.out.println(student);
        studentService.updateStudent(student);
        return "1";
    }

//    学生修改密码
    @ResponseBody
    @RequestMapping("/modifyStudentPasswd")
    public String modifyStudentPasswd(HttpServletRequest request,String oldPassword,String newPassword){
       Student student=(Student)request.getSession().getAttribute("student");
//       System.out.println(oldPassword+student.getPassword());
       if(!student.getPassword().equals(oldPassword)){
           return "1";
       }
       student.setPassword(newPassword);
//       System.out.println(student);
       loginService.updateStudentPasswd(student);
       return "2";

    }

}
