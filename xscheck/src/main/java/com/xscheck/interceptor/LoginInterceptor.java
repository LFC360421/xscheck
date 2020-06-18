package com.xscheck.interceptor;

import com.xscheck.pojo.Admin;
import com.xscheck.pojo.Student;
import com.xscheck.pojo.Teacher;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginInterceptor implements HandlerInterceptor {


      //请求处理之前调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws IOException {

        Admin admin=(Admin) request.getSession().getAttribute("admin");
        Student student= (Student) request.getSession().getAttribute("student");
        Teacher teacher=(Teacher) request.getSession().getAttribute("teacher");
        if(null!=admin || null!=student || null!=teacher){
            return true;
        }else {
            response.sendRedirect("/index");
            return false;
        }
    }

}
