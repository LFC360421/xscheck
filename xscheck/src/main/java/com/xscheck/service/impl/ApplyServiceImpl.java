package com.xscheck.service.impl;

import com.xscheck.mapper.ApplyMapper;
import com.xscheck.pojo.Apply;
import com.xscheck.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    ApplyMapper applyMapper;

//    动态查询所有的申请
    @Override
    public List<Apply> findAllApply(Apply apply) {
        return applyMapper.findAllApply(apply);
    }

//    查询申请总数total
    @Override
    public int findApplyTotal(Apply apply) {
        return applyMapper.findApplyTotal(apply);
    }

//    学生添加申请
    @Override
    public void addApply(Apply apply) {
        applyMapper.addApply(apply);
    }

//    审批申请
    @Override
    public void updateApply(int id,String isagree,String note) {
        applyMapper.updateApply(id,isagree,note);
    }
//删除申请
    @Override
    public void deleteApply(List<Integer> list) {
        for(int i=0;i<list.size();i++) {
           applyMapper.deleteApply(list.get(i));
        }
    }
}
