package com.tosit.framework.mvc.servlet;

import com.tosit.framework.mvc.annotation.RequestPath;
import com.tosit.framework.mvc.ex.MVCException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class DispatcherServlet extends HttpServlet {
    String[] scanPackage = null;
    //ClassLoader contextClassLoader = null;
    List<String> scanClassNames = new ArrayList<>();
    Map<String,PathMapEntity> pathMapping=null;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PathMapEntity pathMapEntity =null;
        String uri = request.getRequestURI().trim();
        Set<String> pathInMaps = pathMapping.keySet();
        for (String eachPathInMap:
                pathInMaps ) {
           // System.out.println(eachPathInMap);
            if(uri.indexOf(eachPathInMap)!=-1){
                pathMapEntity = pathMapping.get(eachPathInMap);
                break;
            }
        }
        try {
            Object obj = pathMapEntity.getClazz().newInstance();
            String rs = (String) (pathMapEntity.getMethod().invoke(obj,request,response));
            if(rs!=null){
                String forwardPath = null;
                if(rs!=null && rs.trim().startsWith("/")){//返回的视图是必须是绝对路径
                    forwardPath = rs;
                }else{//返回的视图是相对路径
                   // forwardPath = nameSpace+"/"+rs;
                    throw  new RuntimeException("\""+rs+"\""+"有错,返回值必须是绝对路径");
                }
                request.getRequestDispatcher(forwardPath).forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void init() throws ServletException {
      //  contextClassLoader = Thread.currentThread().getContextClassLoader();
        //1  读取配置的路径,找出所有的class 文件,得到限定类名
        scanPackage =  getAllClassNameFromConfig();

        // 2 解释类,得到路径映射的实体 Map
        pathMapping =  getPathMapEntity();
    }

    private  Map<String,PathMapEntity> getPathMapEntity() {
        Map<String,PathMapEntity> pathMapping = new HashMap<>();
        for (String className:scanClassNames  ) {
            try {
                Class clazz  = Class.forName(className);
                String nameSpaceStr = "";
                RequestPath nameSpace = (RequestPath) clazz.getAnnotation(RequestPath.class);
                if(nameSpace!=null){
                    nameSpaceStr = nameSpace.value();
                }

                Method[] methods = clazz.getMethods();
                for (Method eachMethod :
                        methods) {
                    RequestPath path = (RequestPath) eachMethod.getAnnotation(RequestPath.class);
                    if(path!=null){
                        String value =path.value();
                        String urlpath =  nameSpaceStr+value;
                        PathMapEntity pathMapEntity = new PathMapEntity(urlpath, clazz, eachMethod);
//                        System.out.println("map:"+urlpath);
                        pathMapping.put(pathMapEntity.getPath(),pathMapEntity);
                    }
                }
//                System.out.println("===========================================");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return  pathMapping;
    }

    private  String[] getAllClassNameFromConfig() {
        String[] scanPackage = null;
        String allPackage = this.getServletConfig().getInitParameter("scan-package");//
        if (allPackage == null) {
            //System.out.println("见鬼了");
            throw new MVCException("scan-package not Found!");
        } else {
            scanPackage = allPackage.split(",");//2
        }
        //根据路径找出所有的类名!!
        if (scanPackage != null && scanPackage.length > 0) {
            for (String eachPackage :
                    scanPackage) {
                String packName = eachPackage.trim();
                String packPath = packName.replaceAll("\\.", "/");
                URL resource = Thread.currentThread().getContextClassLoader().getResource(packPath);//com.tosit.emps.action
                String filepath = resource.getPath();
                File classDir = new File(filepath);
                File[] allCalssFile = classDir.listFiles();
                for (File f :
                        allCalssFile) {
                    if(f.getName().endsWith("class")){//只需要class 文件的名字
                        String className = packName+"."+f.getName().substring(0,f.getName().indexOf("."));
//                        System.out.println(className+" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        scanClassNames.add(className);
                    }
                }
            }
        }
        return   scanPackage;
    }


}
