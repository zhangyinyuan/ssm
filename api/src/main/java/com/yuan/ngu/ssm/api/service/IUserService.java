package com.yuan.ngu.ssm.api.service;

import com.yuan.ngu.ssm.api.po.User;

import java.util.List;

public interface IUserService {
    List<User> getUserList(int offset, int limit);
}
