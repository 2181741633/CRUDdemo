package com.s.service;

import com.s.dao.DeptMapper;
import com.s.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {

    @Autowired
    DeptMapper deptMapper;


    public List<Dept> getDepts() {
        List<Dept> depts = deptMapper.selectByExample(null);
        return depts;
    }
}
