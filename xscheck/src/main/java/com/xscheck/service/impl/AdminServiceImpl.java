package com.xscheck.service.impl;

import com.xscheck.mapper.AdminMapper;
import com.xscheck.pojo.Admin;
import com.xscheck.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
     @Autowired
    AdminMapper adminMapper;

    //查询所有的管理员信息
    @Override
    public List<Admin> findAllAdmin(Admin admin) {
        return adminMapper.findAllAdmin(admin);
    }
    //查询总数total
    @Override
    public int findAdminTotal(Admin admin) {
        return adminMapper.findAdminTotal(admin);
    }
    //添加管理员信息
    @Override
    public void addAdmin(Admin admin) {
        adminMapper.addAdmin(admin);
    }
    //删除管理员信息
    @Override
    public void deleteAdmin(List<Integer> list) {
        for(int i=0;i<list.size();i++) {
           adminMapper.deleteAdmin(list.get(i));
        }
    }
}
