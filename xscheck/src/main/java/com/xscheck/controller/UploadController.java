package com.xscheck.controller;

import com.xscheck.pojo.Student;
import com.xscheck.service.StudentService;
import com.xscheck.utils.ExcelUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UploadController {
    @Autowired
    StudentService studentService;

//  导出学生信息表
    @RequestMapping("/exportStudent")
    public void exportStudent(HttpServletResponse response) throws IOException {
       String fileName="学生信息表";
       String[]  excelHeaders={"学号","姓名","性别","联系电话","专业班级"};
       List<Student> dataStudent=studentService.dataStudent();
       List<String[]> data=new ArrayList<>();
       for(int i=0;i<dataStudent.size();i++){
           //将每一条学生数据转化为String数组
           List<String> str=new ArrayList<>();
           str.add(String.valueOf(dataStudent.get(i).getSno()));
           str.add(dataStudent.get(i).getSname());
           str.add(dataStudent.get(i).getSex());
           str.add(String.valueOf(dataStudent.get(i).getPhone()));
           str.add(dataStudent.get(i).getMajorclass());
           String[] strs=str.toArray(new String[str.size()]);
           data.add(strs);
       }
       ExcelUtil excelUtil=new ExcelUtil();
       excelUtil.exportExcel(response,fileName,excelHeaders,data);
    }

//    Excel导入学生信息
    @RequestMapping("/importStudent")
    @ResponseBody
    public String importStudent(MultipartFile file) throws IOException, InvalidFormatException {
//        String filename=file.getOriginalFilename();
        ExcelUtil excelUtil=new ExcelUtil();
        List<Object[]> list=excelUtil.importExcel2(file);
        for(int i=0;i<list.size();i++){
            Student student=new Student();
            student.setSno((Integer) list.get(i)[0]);
            student.setSname((String)list.get(i)[1]);
            student.setSex((String)list.get(i)[2]);
            student.setPassword(String.valueOf(list.get(i)[0]));
            student.setPhone((Integer)list.get(i)[3]);
            student.setMajorclass((String)list.get(i)[4]);
//            System.out.println(student.toString());
            studentService.addStudent(student);
        }
        return "1";
    }

}
