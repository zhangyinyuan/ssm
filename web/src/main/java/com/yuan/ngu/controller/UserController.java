package com.yuan.ngu.controller;

import com.yuan.ngu.ssm.api.po.User;
import com.yuan.ngu.ssm.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    //支持跨域请求
    @CrossOrigin(origins = "*", maxAge = 0)
    @RequestMapping(path = "/queryAll", method = RequestMethod.GET)
    @ResponseBody
    public List<User> queryAll() {
        return userService.getUserList(0, 10);
    }
}
