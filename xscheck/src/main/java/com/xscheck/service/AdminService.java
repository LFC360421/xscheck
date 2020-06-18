package com.xscheck.service;

import com.xscheck.pojo.Admin;

import java.util.List;

public interface AdminService {
    //显示所有管理员信息
    List<Admin> findAllAdmin(Admin admin);
    //查询total总数
    int findAdminTotal(Admin admin);
    //添加管理员
    void addAdmin(Admin admin);
    //删除管理员信息
    void deleteAdmin(List<Integer> list);
}
