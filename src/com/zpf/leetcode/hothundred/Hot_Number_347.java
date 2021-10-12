package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;

import java.util.*;

public class Hot_Number_347 implements Execute {
    @Override
    public void execute() {

    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i : nums) {
            cache.put(i, cache.getOrDefault(i, 0) + 1);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            int temp = Integer.MIN_VALUE;
            int key = 0;
            for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
                if (temp < entry.getValue()) {
                    temp = entry.getValue();
                    key = entry.getKey();
                }
            }
            result[i] = key;
            cache.remove(key);
        }
        return result;
    }

    //对方法，通过优先队列实现怼
    public int[] topKFrequentHeap(int[] nums, int k) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i : nums) {
            cache.put(i, cache.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            if (heap.size() == k) {
                if (heap.peek() != null && heap.peek()[1] < count) {
                    heap.poll();
                    heap.offer(new int[]{key, count});
                }
            } else {
                heap.offer(new int[]{key, count});
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = Objects.requireNonNull(heap.poll())[0];
        }
        return result;
    }
}
