package com.zpf.leetcode;

import com.zpf.leetcode.util.Execute;

public class Main {
    public static void main(String[] args) {
        String a ="";
        String b = "a";
        System.out.println(b.contains(a));
    }

    private static void execute() {
        try {
            Class<?> exClass = Class.forName("com.zpf.leetcode.number.Number_7");
            Execute execute = (Execute) exClass.newInstance();
            execute.execute();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
