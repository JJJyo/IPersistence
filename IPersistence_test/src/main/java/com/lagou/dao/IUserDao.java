package com.lagou.dao;

import com.lagou.pojo.User;

import java.util.List;

public interface IUserDao {

    //查询所有用户
    public List<User> findAll() throws Exception;

    //根据条件进行用户查询
    public User findByCondition(User user) throws Exception;

    //根据id删除
    public void deleteById(User user) throws Exception;

    //根据id更新
    public void updateById(User user) throws Exception;

    //插入新用户
    public void insert(User user) throws Exception;
}
