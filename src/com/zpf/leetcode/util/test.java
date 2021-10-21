package com.zpf.leetcode.util;

public class test {

    public static void main(String[] args) {
        execute();
    }

    private static void execute() {
        try {
            Class<?> exClass = Class.forName("com.zpf.leetcode.hothundred.Hot_Number_169");
            Execute execute = (Execute) exClass.newInstance();
            execute.execute();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
