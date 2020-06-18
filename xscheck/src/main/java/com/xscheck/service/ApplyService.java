package com.xscheck.service;

import com.xscheck.pojo.Apply;

import java.util.List;

public interface ApplyService {
    //    动态查询所有请假申请
    List<Apply> findAllApply(Apply apply);
    //    查询申请的总数total
    int findApplyTotal(Apply apply);
    //    学生添加申请
    void addApply(Apply apply);
    //    老师审批
    void updateApply(int id,String isagree,String note);
    //    删除申请
    void deleteApply(List<Integer> list);

}
