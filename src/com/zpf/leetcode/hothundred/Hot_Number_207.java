package com.zpf.leetcode.hothundred;

import java.util.*;

public class Hot_Number_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> entry = new HashMap<>();
        Map<Integer, List<Integer>> mapping = new HashMap<>();
        HashSet<Integer> cache = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            entry.put(i, 0);
            cache.add(i);
            mapping.put(i, new ArrayList<>());
        }
        for (int[] a : prerequisites) {
            int k = entry.get(a[0]);
            entry.replace(a[0], k + 1);
            mapping.get(a[1]).add(a[0]);
        }
        while (cache.size() != 0) {
            int choose = -1;
            for (Map.Entry<Integer, Integer> entryData : entry.entrySet()) {
                if (entryData.getValue() == 0) {
                    choose = entryData.getKey();
                    break;
                }
            }
            if (choose < 0) {
                return false;
            } else {
                cache.remove(choose);
                entry.remove(choose);
                for (int a : mapping.get(choose)) {
                    entry.replace(a, entry.get(a) - 1);
                }
            }
        }
        return true;
    }
}
