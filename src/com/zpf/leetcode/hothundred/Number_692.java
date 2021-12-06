package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

import java.util.*;

public class Number_692 implements Execute {
    //["i","love","leetcode","i","love","coding"]
    //2
    @Override
    public void execute() {
        String[] a = {"i", "love", "leetcode", "i", "love", "coding"};
        topKFrequent(a, 2);
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cache = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>( (o1, o2) -> {
/*            Log.i("o1", o1);
            Log.i("o2", o2);*/

            int int1 = cache.getOrDefault(o1, 0);
            int int2 = cache.getOrDefault(o2, 0);
/*            Log.i("int1", int1);
            Log.i("int2", int2);*/
            if (int1-int2==0){
                return o1.compareTo(o2);
            }
            return int2 - int1;
        });
        for (String str : words) {
            cache.put(str, cache.getOrDefault(str, 0) + 1);
        }
        queue.addAll(cache.keySet());
        List<String> list = new ArrayList<>();
        Log.i("优先数组",Arrays.toString(queue.toArray()));
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
        Log.i("结果",Arrays.toString(list.toArray()));
        return list;
    }
}
