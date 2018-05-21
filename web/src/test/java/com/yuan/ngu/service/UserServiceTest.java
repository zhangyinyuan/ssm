package com.yuan.ngu.service;

import com.alibaba.fastjson.JSONObject;
import com.yuan.ngu.ssm.api.po.User;
import com.yuan.ngu.ssm.api.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 测试事务的传播行为 和 UserService
 * 事务的7种传播行为:
 * 1、PROPAGATION_REQUIRED：如果当前没有事务，就创建一个新事务，如果当前存在事务，就加入该事务，该设置是最常用的设置。
 * 2、PROPAGATION_SUPPORTS：支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就以非事务执行。‘
 * 3、PROPAGATION_MANDATORY：支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就抛出异常。
 * 4、PROPAGATION_REQUIRES_NEW：创建新事务，无论当前存不存在事务，都创建新事务。
 * 5、PROPAGATION_NOT_SUPPORTED：以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
 * 6、PROPAGATION_NEVER：以非事务方式执行，如果当前存在事务，则抛出异常。
 * 7、PROPAGATION_NESTED：如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
 * 一个关键:数据回滚的前提是开启了事务,如果没有开启事务,无从谈起回滚
 */
public class UserServiceTest extends SpringBaseTest {

    @Autowired
    private IUserService userService;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    @Test
    public void getUserList() {
        List<User> userList = userService.getUserList(0, 10);
        System.err.println(">>>>>>>>>>>>>>>> userList = " + JSONObject.toJSON(userList));
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    @Test
    public void getUser() {
        User user = userService.getUser(1000);
        System.err.println(">>>>>>>>>>>>>>>> user = " + JSONObject.toJSON(user));


    }


    @Test
    public void addUserTest() {
        User user = new User();
        user.setUserName("張三");
        user.setUserPhone(17693661916L);
        user.setScore(new Random().nextInt(100) + 1);
        user.setCreateTime(new Date());
        userService.inserUser(user);
    }

    @Test
    public void updateUserTest() {
        User user = new User();
        user.setUserId(1000);
        user.setUserName("999");
        userService.updateUser(user);
    }

}