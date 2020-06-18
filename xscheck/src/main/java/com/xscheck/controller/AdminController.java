package com.xscheck.controller;

import com.xscheck.pojo.Admin;
import com.xscheck.service.AdminService;
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
public class AdminController {
    @Autowired
    AdminService adminService;

    //查询管理员信息
    @ResponseBody
    @RequestMapping("/getAllAdmin")
    public Map getAllAdmin(int page, int rows, Admin admin){
//        System.out.println(admin);
        //查询所有数据
        List<Admin> as=adminService.findAllAdmin(admin);
        //查询总记录数
        int total=adminService.findAdminTotal(admin);
        //展示分页集合
        List<Admin> asList=new ArrayList<>();

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

    //添加管理员
    @ResponseBody
    @RequestMapping("/addAdmin")
    public String addAdmin(Admin admin){
        admin.setPassword( String.valueOf(admin.getAdminno()));
        adminService.addAdmin(admin);
        return "1";
    }

    //删除管理员
    @RequestMapping("/deleteAdmin")
    @ResponseBody
    public String deleteAdmin(HttpServletRequest request) {
        String[] ids=request.getParameter("idString").split(",");
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < ids.length; i++) {
            list.add(Integer.parseInt(ids[i]));
        }
        adminService.deleteAdmin(list);
        return "1";
    }

}
