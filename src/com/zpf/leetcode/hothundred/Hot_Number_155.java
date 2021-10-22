package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Hot_Number_155 implements Execute {
    @Override
    public void execute() {

    }

    class MinStack {
        private Deque<Integer> mStack;
        private int mMin;

        public MinStack() {
            mStack = new ArrayDeque<>();
            mMin = Integer.MAX_VALUE;
        }

        public void push(int val) {
            mStack.push(val);
            mMin = Math.min(mMin, val);
        }

        public void pop() {
            if (!mStack.isEmpty()) {
                int temp = mStack.peek();
                if (temp == mMin) {
                    mMin = Integer.MAX_VALUE;
                    mStack.pop();
                    System.out.println(temp);
                    List<Integer> cache = new ArrayList<>(mStack);
                    for (int i : cache) {
                        System.out.print(i + " ");
                        mMin = Math.min(mMin, i);
                    }
                } else {
                    mStack.pop();
                }
            }
        }

        public int top() {
            if (!mStack.isEmpty()) {
                return mStack.peek();
            } else {
                return 0;
            }
        }

        public int getMin() {
            return mMin;
        }
    }
}
