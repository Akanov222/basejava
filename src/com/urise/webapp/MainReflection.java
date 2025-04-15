package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume resume = new Resume();
        Class<? extends Resume> resumeClass = resume.getClass();
        Field field = resumeClass.getDeclaredFields()[0];
        field.setAccessible(true);

        System.out.println(field.getName());
        System.out.println(field.get(resume));

        Method setUuid = resumeClass.getMethod("setUuid", String.class);
        setUuid.invoke(resume,"newUuid");

        Method method = resumeClass.getMethod("toString");
        Object result = method.invoke(resume);
        System.out.println(result);
    }
}
