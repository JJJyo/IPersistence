package com.lagou.io;

import java.io.InputStream;

public class Resource {

    /*
    通过配置文件的路径讲配置文件加载到字节流存在内存里

     */
    public static InputStream getResourceAsStream(String path){
        InputStream resourceAsStream = Resource.class.getClassLoader().getResourceAsStream(path);
        return resourceAsStream;
    }
}


