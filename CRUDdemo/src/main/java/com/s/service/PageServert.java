package com.s.service;

import com.s.dao.UserMapper;
import com.s.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PageServert {

    @Autowired
    UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.selectByExamplewithDept(null);
    }
}
