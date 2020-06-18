package com.xscheck.mapper;

import com.xscheck.pojo.Apply;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApplyMapper {
//    动态查询所有请假申请
    @SelectProvider(type = DynaSql.class,method = "findAllApply")
    List<Apply> findAllApply(Apply apply);

//    查询申请的总数total
    @SelectProvider(type = DynaSql.class,method = "findApplyTotal")
    int findApplyTotal(Apply apply);

//    学生添加申请
    @Insert("insert into apply(sno,sname,majorclass,reason,starttime,endtime,createtime,isagree) " +
            "" +
            "values(#{sno},#{sname},#{majorclass},#{reason},#{starttime},#{endtime},#{createtime},#{isagree})")
    void addApply(Apply apply);

//    老师审批
    @Update("update apply set isagree=#{isagree},note=#{note} where id=#{id} ")
    void updateApply(int id,String isagree,String note);

//    删除申请
    @Delete("delete from apply where id=#{id}")
    void deleteApply(int id);


}
