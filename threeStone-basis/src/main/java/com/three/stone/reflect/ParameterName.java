package com.three.stone.reflect;

import com.three.stone.App;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class ParameterName {
    public static void main(String[] args) throws NoSuchMethodException {
        parameterName(App.class);
    }

    private static void parameterName(Class<?> clzz) throws NoSuchMethodException {
        Constructor<?> constructor = clzz.getConstructor(String.class);
        Parameter[] parameters = constructor.getParameters();
        for (Parameter parameter : parameters) {
            //arg0
            System.out.println(parameter.getName());
        }
    }
}
