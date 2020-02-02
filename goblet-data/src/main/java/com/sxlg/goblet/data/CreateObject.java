package com.sxlg.goblet.data;

import javassist.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

public class CreateObject {
    private static final Logger logger = LoggerFactory.getLogger(CreateObject.class);
    private static final String CLASS_NAME = "goblet.class.name";
    private static final String Type_PREFIX = "java.lang.";
    private Properties properties = new Properties();

    /**
     * Map 为字段:属性
     *
     * @return
     * @throws NoSuchFieldException
     * @throws NotFoundException
     */
    public Map<String, java.lang.Object> buildObject() {
        Map<String, java.lang.Object> objects = new HashMap<String, java.lang.Object>();
        List<Map<String, String>> classInfos = parseField();
        //获取类名
        for (Map<String, String> classInfo : classInfos) {
            String className = classInfo.get(CLASS_NAME);
            classInfo.remove(CLASS_NAME);
            ClassPool pool = ClassPool.getDefault();
            //根据类名创建一个对象
            CtClass ctClass = null;
            try{
                ctClass = pool.makeClass(className, pool.get(Object.class.getName()));
            } catch (NotFoundException e) {
                e.printStackTrace();
            }

            Iterator<Map.Entry<String, String>> property = classInfo.entrySet().iterator();
            StringBuilder stringJoin = new StringBuilder(Type_PREFIX);
            //向对象中添加属性
            while (property.hasNext()) {
                Map.Entry<String, String> next = property.next();
                String field = next.getKey();
                String value = next.getValue();
                String type = stringJoin.append(value).toString();
                CtField ctField = null;
                try{
                    ctField = new CtField(pool.get(type), field.substring(13), ctClass);
                } catch (CannotCompileException e) {
                    e.printStackTrace();
                } catch (NotFoundException e) {
                    e.printStackTrace();
                }
                ctField.setModifiers(Modifier.PROTECTED);
                try {
                    ctClass.addField(ctField);
                } catch (CannotCompileException c) {
                    logger.error("");
                }
                stringJoin.delete(10, stringJoin.toString().length());
            }
            Class aClass = null;
            try {
               aClass = ctClass.toClass();
            } catch (CannotCompileException c) {

            }
            Object o = null;
            try {
                o = aClass.newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            objects.put(className, o);
        }
        return objects;
    }

    private List<Map<String, String>> parseField() {
        Map<String, String> map = null;
        List<Map<String, String>> classInfos = new ArrayList<Map<String, String>>();
        URL path = getClass().getClassLoader().getResource("table");
        File file = new File(path.getPath());
        //获取目录下的所有文件名
        String[] fileNames = file.list();
        for (String fileName : fileNames) {
            InputStream in = getClass().getClassLoader().getResourceAsStream("table\\" + fileName);
            try {
                properties.load(in);
            } catch (IOException e) {

            }
            Enumeration<?> fields = properties.propertyNames();
            map = new HashMap<String, String>();
            while (fields.hasMoreElements()) {
                String fileld = (String) fields.nextElement();
                String type = properties.getProperty(fileld);
                if (StringUtils.isEmpty(type)) {
                    logger.error("");
                } else {
                    map.put(fileld, type);
                }
            }
            classInfos.add(map);
        }
        return classInfos;
    }
}
