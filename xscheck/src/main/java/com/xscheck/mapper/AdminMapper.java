package com.xscheck.mapper;

import com.xscheck.pojo.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper {
    //查询所有的管理员信息
    @Select("<script>" +
            "select * from admin " +
            "<where>" +
            "<if test=\" adminno!=null\"> adminno=#{adminno}</if>" +
            "</where>" +
            "</script>")
    List<Admin> findAllAdmin(Admin admin);
    //查询总数total
    @Select("<script>" +
            "select count(id) from admin " +
            "<where>" +
            "<if test=\" adminno!=null\"> adminno=#{adminno}</if>" +
            "</where>" +
            "</script>")
    int findAdminTotal(Admin admin);
    //添加管理员信息
    @Insert("insert into admin(adminno,password) values (#{adminno},#{password})")
    void addAdmin(Admin admin);
    //删除管理员信息
    @Delete("delete from admin where admino=#{adminno}")
    void deleteAdmin(int adminno);
}
