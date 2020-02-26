package com.lagou.dao;

import com.lagou.io.Resource;
import com.lagou.pojo.User;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;

public class IUserDaoImpl implements IUserDao {

    InputStream resourceAsStream = Resource.getResourceAsStream("sqlMapConfig.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    public IUserDaoImpl() throws PropertyVetoException, DocumentException {
    }

    @Override
    public List<User> findAll() throws Exception {

        List<User> users = sqlSession.selectList("user.findAll");
        for (User user2 : users) {
            System.out.println(user2.getUsername());
        }

        return users;
    }

    @Override
    public User findByCondition(User user) throws Exception {

        User user1 = sqlSession.selectOne("user.findByCondition", user);
        System.out.println(user1.getUsername());

    return user;
    }

    @Override
    public void deleteById(User user) throws Exception {


    }

    @Override
    public void updateById(User user) throws Exception {

    }

    @Override
    public void insert(User user) throws Exception {

    }
}
