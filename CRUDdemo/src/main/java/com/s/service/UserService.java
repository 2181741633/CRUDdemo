package com.s.service;

import com.s.dao.UserMapper;
import com.s.entity.User;
import com.s.entity.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public void addUser(User user) {
        userMapper.insertSelective(user);
    }

    public boolean selectchong(String uName) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUNameEqualTo(uName);
        long num = userMapper.countByExample(userExample);
        return num == 0;
    }

    public User findUser(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    public void deleteUser(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    public void deleteUsers(List<Integer> ids) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUIdIn(ids);
        userMapper.deleteByExample(userExample);
    }
}
