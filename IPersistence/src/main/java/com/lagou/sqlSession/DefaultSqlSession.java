package com.lagou.sqlSession;

import com.lagou.pojo.Configuration;
import com.lagou.pojo.MappedStatement;

import java.lang.reflect.*;
import java.util.List;

public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T getMapper(Class<?> mapperClass) {
        // 使用JDK动态代理来为Dao接口生成代理对象，并返回

        Object proxyInstance = Proxy.newProxyInstance(DefaultSqlSession.class.getClassLoader(), new Class[]{mapperClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 底层都还是去执行JDBC代码 //根据不同情况，来调用selctList或者selectOne
                // 准备参数 1：statmentid :sql语句的唯一标识：namespace.id= 接口全限定名.方法名
                // 方法名：findAll
                String methodName = method.getName();
                // 接口全限定名
                String className = method.getDeclaringClass().getName();

                String statementId = className+"."+methodName;

                // 准备参数2：params:args
                // 获取被调用方法的返回值类型
                Type genericReturnType = method.getGenericReturnType();
                // 判断是否进行了 泛型类型参数化，看类型有没有泛型 没有泛型就是实体类型调用的是findbycondition方法
//                if(genericReturnType instanceof ParameterizedType){
//                    List<Object> objects = selectList(statementId, args);
//                    return objects;
//                }
//
//                return selectOne(statementId, args);

                if (methodName == "findAll"){

                    List<Object> objects = selectList(statementId, args);
                    return objects;
                }else if (methodName == "findByCondition"){

                    return selectOne(statementId, args);
                }else if (methodName == "insert"){
                    insert(statementId, args);
                    return null;
                }else if (methodName == "deleteById"){
                    deleteById(statementId, args);
                    return null;
                }else if (methodName == "updateById") {
                    updateById(statementId, args);
                    return null;
                }
                return null;
            }
        });

        return (T) proxyInstance;
    }

    @Override
    public <E> E selectOne(String statementid, Object... params) throws Exception{
        List<Object> objects = selectList(statementid, params);
        if (objects.size() == 1){

            return (E)objects.get(0);
        }else{
            throw new RuntimeException("查询结果过多或结果过多");
        }
    }

    @Override
    public void deleteById(String statementid, Object... params) throws Exception {

        //对DefaultExecutor的query方法调用
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementid);
        defaultExecutor.query(configuration, mappedStatement, params);
    }

    @Override
    public void updateById(String statementid, Object... params) throws Exception {

        //对DefaultExecutor的query方法调用
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementid);
        defaultExecutor.query(configuration, mappedStatement, params);
    }

    @Override
    public void insert(String statementid, Object... params) throws Exception {

        //对DefaultExecutor的query方法调用
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementid);
        defaultExecutor.query(configuration, mappedStatement, params);
    }

    @Override
    public <E> List<E> selectList(String statementid, Object... params) throws Exception{

        //对DefaultExecutor的query方法调用
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementid);
        List<Object> list = defaultExecutor.query(configuration, mappedStatement, params);

        return (List<E>) list;
    }
}
