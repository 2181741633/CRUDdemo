package com.tosit.framework.mvc.servlet;

import java.lang.reflect.Method;

public class PathMapEntity {
    private String path;
    private Class clazz;
    private Method method;

    public PathMapEntity(String path, Class clazz, Method method) {
        this.path = path;
        this.clazz = clazz;
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public Class getClazz() {
        return clazz;
    }

    public Method getMethod() {
        return method;
    }
}
