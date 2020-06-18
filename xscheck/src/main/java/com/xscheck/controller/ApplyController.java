package com.xscheck.controller;

import com.xscheck.pojo.Apply;
import com.xscheck.pojo.Course;
import com.xscheck.pojo.Student;
import com.xscheck.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Controller
public class ApplyController {
   @Autowired
    ApplyService applyService;

   //    查询所有的申请
    @RequestMapping("/getAllApply")
    @ResponseBody
    public Map getAllApply(int page, int rows, Apply apply){
        //查询所有数据
        List<Apply> as=applyService.findAllApply(apply);

        //查询总记录数
        int total=applyService.findApplyTotal(apply);
        //展示分页集合
        List<Apply> asList=new ArrayList<>();

        for (int i = 0; i < as.size(); i++)
        {
            //当前页-1 * 记录数 并且 这条记录是第几页的数据 当前页乘以记录数
            //第一次传过来的rows 是10 page是1
            if (i >= (page - 1) * rows && i < page * rows)
            {
                //符合当前页的数据添加到展示分页集合中
                asList.add(as.get(i));
            }
        }
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("total", total);
        result.put("rows", asList);
        return result;
    }

    //学生添加申请
    @ResponseBody
    @RequestMapping("/addApply")
    public String addApply(HttpServletRequest request,Apply apply){
        Student student=(Student)request.getSession().getAttribute("student");
        apply.setSno(student.getSno());
        apply.setSname(student.getSname());
        apply.setMajorclass(student.getMajorclass());
        Date date=new Date();
        apply.setCreatetime(date);
        apply.setIsagree("未审批");
        applyService.addApply(apply);
        return "1";
    }

    //处理申请
    @ResponseBody
    @RequestMapping("/updateApply")
    public String updateApply(int id,String isagree,String note){
//        System.out.println(id+isagree);
        applyService.updateApply(id,isagree,note);
        return "1";
    }

    // 删除申请
    @RequestMapping("/deleteApply")
    @ResponseBody
    public String deleteApply(HttpServletRequest request) {
        String[] ids=request.getParameter("idString").split(",");
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < ids.length; i++) {
            list.add(Integer.parseInt(ids[i]));
        }
       applyService.deleteApply(list);
        return "1";
    }
    // 学生删除申请
    @RequestMapping("/deleteApplyStuent")
    @ResponseBody
    public String deleteApplyStudent(int id) {
//        System.out.println(id);
        List<Integer> list = new ArrayList<Integer>();
            list.add(id);
        applyService.deleteApply(list);
        return "1";
    }

    // 学生查询自己的申请
    @RequestMapping("/getStudentApply")
    @ResponseBody
    public Map getStudentApply(HttpServletRequest request,int page, int rows){
        Student student=(Student) request.getSession().getAttribute("student");
        Apply apply=new Apply();
        apply.setSno(student.getSno());
        //查询所有数据
        List<Apply> xas=applyService.findAllApply(apply);

        //查询总记录数
        int total=applyService.findApplyTotal(apply);
        //展示分页集合
        List<Apply> xasList=new ArrayList<>();

        for (int i = 0; i < xas.size(); i++)
        {
            //当前页-1 * 记录数 并且 这条记录是第几页的数据 当前页乘以记录数
            //第一次传过来的rows 是10 page是1
            if (i >= (page - 1) * rows && i < page * rows)
            {
                //符合当前页的数据添加到展示分页集合中
                xasList.add(xas.get(i));
            }
        }
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("total", total);
        result.put("rows", xasList);
        return result;
    }

//
}
