package com.lagou.pojo;

//存储mapper.xml的信息
public class MappedStatement {

    /*
    id， 参数类型， 返回类型， sql语句
     */

    public String getId() {
        return id;
    }

    public String getResultType() {
        return resultType;
    }

    public String getParamterType() {
        return paramterType;
    }

    public String getSql() {
        return sql;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public void setParamterType(String paramterType) {
        this.paramterType = paramterType;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    private String id;
    private String resultType;
    private String paramterType;
    private String sql;
}
