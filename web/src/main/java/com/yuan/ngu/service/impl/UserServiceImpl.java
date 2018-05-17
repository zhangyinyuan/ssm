package com.yuan.ngu.service.impl;

import com.yuan.ngu.dao.IUserMapper;
import com.yuan.ngu.ssm.api.po.User;
import com.yuan.ngu.ssm.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public List<User> getUserList(int offset, int limit) {
        return userMapper.queryAll(offset, limit);
    }
}
