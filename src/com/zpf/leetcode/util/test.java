package com.zpf.leetcode.util;

public class test {

    public static void main(String[] args) {
        execute("com.zpf.leetcode.hothundred.Hot_Number_42");
    }

    private static void execute(String className) {
        try {
            Class<?> exClass = Class.forName(className);
            Execute execute = (Execute) exClass.newInstance();
            execute.execute();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
