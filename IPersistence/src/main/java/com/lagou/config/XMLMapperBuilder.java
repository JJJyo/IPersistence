package com.lagou.config;

import com.lagou.pojo.Configuration;
import com.lagou.pojo.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class XMLMapperBuilder {

    private Configuration configuration;

    public XMLMapperBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public void parse(InputStream in) throws DocumentException {

        Document document = new SAXReader().read(in);
        Element rootElement = document.getRootElement();

        List<Element> list = rootElement.selectNodes("//select");
        String namespace = rootElement.attributeValue("namespace");
        for (Element element : list) {
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String paramterType = element.attributeValue("paramterType");
            String sqlText = element.getTextTrim();

            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            mappedStatement.setResultType(resultType);
            mappedStatement.setParamterType(paramterType);
            mappedStatement.setSql(sqlText);

            String key = namespace+"."+id;
            configuration.getMappedStatementMap().put(key, mappedStatement);
        }

        List<Element> list2 = rootElement.selectNodes("//insert");
        String namespace2 = rootElement.attributeValue("namespace");
        for (Element element : list2) {
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String paramterType = element.attributeValue("paramterType");
            String sqlText = element.getTextTrim();

            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            mappedStatement.setResultType(resultType);
            mappedStatement.setParamterType(paramterType);
            mappedStatement.setSql(sqlText);

            String key = namespace2+"."+id;
            configuration.getMappedStatementMap().put(key, mappedStatement);
        }

        List<Element> list3 = rootElement.selectNodes("//update");
        String namespace3 = rootElement.attributeValue("namespace");
        for (Element element : list3) {
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String paramterType = element.attributeValue("paramterType");
            String sqlText = element.getTextTrim();

            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            mappedStatement.setResultType(resultType);
            mappedStatement.setParamterType(paramterType);
            mappedStatement.setSql(sqlText);

            String key = namespace3+"."+id;
            configuration.getMappedStatementMap().put(key, mappedStatement);
        }

        List<Element> list4 = rootElement.selectNodes("//delete");
        String namespace4 = rootElement.attributeValue("namespace");
        for (Element element : list4) {
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String paramterType = element.attributeValue("paramterType");
            String sqlText = element.getTextTrim();

            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            mappedStatement.setResultType(resultType);
            mappedStatement.setParamterType(paramterType);
            mappedStatement.setSql(sqlText);

            String key = namespace4+"."+id;
            configuration.getMappedStatementMap().put(key, mappedStatement);
        }
    }
}
