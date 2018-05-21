package com.yuan.ngu.dao;

import com.yuan.ngu.ssm.api.po.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserMapper {

    /**
     * 根据偏移量查询用户列表
     *
     * @param offset
     * @param limit
     * @return
     */
    List<User> queryAll(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 增加积分
     */
    void addScore(@Param("inserUser") int add);

    @Insert("INSERT INTO _user (user_name,user_phone,score) VALUES ('${userName}',${userPhone},'${score}')")
    void insertUser(User user);

    @Delete("DELETE FROM _user WHERE user_id = ${userId}")
    void deleteUser(@Param("userId") int userId);

    @Select("UPDATE _user SET user_name = '${userName}' WHERE user_id = ${userId}")
    void updateUser(User user);

    @Select("SELECT * FROM _user WHERE user_id = ${userId}")
    User queryUser(@Param("userId") int userId);
}
