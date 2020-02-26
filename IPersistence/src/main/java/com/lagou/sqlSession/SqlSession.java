package com.lagou.sqlSession;

import com.lagou.pojo.User;

import java.util.List;

public interface SqlSession {

    //模糊查询
    public <E> List<E> selectList(String statementid, Object... params) throws Exception;//可变参
    //根据条件查询单个
    public <E> E selectOne(String statementid, Object... params) throws Exception;
    //根据id删除
    public void deleteById(String statementid, Object... params) throws Exception;
    //根据id更新
    public void updateById(String statementid, Object... params) throws Exception;
    //插入新用户
    public void insert(String statementid, Object... params) throws Exception;


    //为Dao接口生成代理实现类
    public <T> T getMapper(Class<?> mapperClass);
}
