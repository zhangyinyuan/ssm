package com.yuan.ngu.service.impl;

import com.yuan.ngu.dao.IUserMapper;
import com.yuan.ngu.ssm.api.po.User;
import com.yuan.ngu.ssm.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Resource
    private UserServiceImpl userServiceImpl;

    @Override
    public User getUser(int userId) {
        return userMapper.queryUser(userId);
    }

    @Override
    public List<User> getUserList(int offset, int limit) {
        return userMapper.queryAll(offset, limit);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void updateUser(User user) {
        userMapper.updateUser(user);
        throw new RuntimeException("测试回滚");
    }

    @Override
    public void deleteUser(int userId) {
        userMapper.deleteUser(userId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void inserUser(User user) {
        userMapper.insertUser(user);
        user.setUserId(1000);
        user.setUserName("555");
        userServiceImpl.updateUser(user);
//        throw new RuntimeException("测试回滚");
    }
}