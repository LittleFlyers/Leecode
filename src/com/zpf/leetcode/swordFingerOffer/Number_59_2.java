package com.zpf.leetcode.swordFingerOffer;

import com.zpf.leetcode.util.Log;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * <p>
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 * <p>
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number_59_2 {

    public void get() {
        MaxQueue maxQueue = new MaxQueue();
        Log.i("max_value", maxQueue.max_value());
        maxQueue.push_back(1);
        maxQueue.push_back(3);
        Log.i("max_value", maxQueue.max_value());
        maxQueue.push_back(2);
        maxQueue.push_back(1);
        Log.i("pop_front", maxQueue.pop_front());
        Log.i("max_value", maxQueue.max_value());
        Log.i("pop_front", maxQueue.pop_front());
        Log.i("max_value", maxQueue.max_value());
        Log.i("pop_front", maxQueue.pop_front());
        Log.i("max_value", maxQueue.max_value());
        Log.i("pop_front", maxQueue.pop_front());
        Log.i("max_value", maxQueue.max_value());
        Log.i("pop_front", maxQueue.pop_front());
        Log.i("max_value", maxQueue.max_value());
    }

    class MaxQueue {
        private Node header;
        private Node tail;
        private int max = -1;

        public MaxQueue() {
            header = new Node();
            tail = new Node();
            header.next = tail;
            tail.pre = header;
        }

        public int max_value() {
            return max;
        }

        public void push_back(int value) {
            if (value >= max) {
                max = value;
            }
            Node pushNode = new Node();
            pushNode.val = value;
            tail.pre.next = pushNode;
            pushNode.pre = tail.pre;
            pushNode.next = tail;
            tail.pre = pushNode;
        }

        public int pop_front() {
            if (header.next == tail) {
                return -1;
            } else {
                int re = header.next.val;
                header.next.next.pre = header;
                header.next = header.next.next;
                if (re == max) {
                    max = -1;
                    Node temp = header.next;
                    while (temp != tail) {
                        if (max <= temp.val) {
                            max = temp.val;
                        }
                        temp = temp.next;
                    }
                }
                return re;
            }
        }

        class Node {
            public int val;
            public Node pre;
            public Node next;
        }
    }

}
