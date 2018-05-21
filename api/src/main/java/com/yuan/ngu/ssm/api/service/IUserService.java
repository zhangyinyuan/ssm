package com.yuan.ngu.ssm.api.service;

import com.yuan.ngu.ssm.api.po.User;

import java.util.List;

public interface IUserService {

    /**
     * 根据用户名查找一个用户
     *
     * @param userId 用户Id
     * @return
     */
    User getUser(int userId);

    /**
     * @param offset 分页的当前页
     * @param limit  每页展示的数据条数
     * @return
     */
    List<User> getUserList(int offset, int limit);

    void updateUser(User user);

    void deleteUser(int userId);

    void inserUser(User user);
}
