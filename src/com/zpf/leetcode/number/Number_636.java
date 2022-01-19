package com.zpf.leetcode.number;

import com.zpf.leetcode.util.Execute;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Number_636 implements Execute {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Deque<Integer> idStack = new ArrayDeque<>();
        Deque<String> commandStack = new ArrayDeque<>();
        Deque<Integer> timeStack = new ArrayDeque<>();
        int idCache = 0;
        String commandCache = "";
        int timeCache = 0;
        for (String log : logs) {
            String[] data = log.split(":");
            int id = Integer.parseInt(data[0]);
            String command = data[1];
            int time = Integer.parseInt(data[2]);
            if (!idStack.isEmpty()) {
                int lastId = idStack.peekLast();
                String lastCommand = commandStack.peekLast();
                int lastTime = timeStack.peekLast();
                if ("start".equals(command)) {
                    if ("start".equals(lastCommand)) {
                        result[lastId] = result[lastId] + (time - lastTime);
                    }
                    idStack.offerLast(id);
                    commandStack.offerLast(command);
                    timeStack.offerLast(time);
                } else if ("end".equals(command)) {
                    if (lastId == id) {
                        if ("start".equals(lastCommand)) {
                            result[lastId] = result[lastId] + (time - timeCache) + 1;
                            idStack.pollLast();
                            commandStack.pollLast();
                            timeStack.pollLast();
                        } else {
                            result[lastId] = result[lastId] + (time - timeCache);
                        }
                    } else {
                        result[id] = result[id] + (time - lastTime);
                    }
                }
            }
            idCache = id;
            commandCache = command;
            timeCache = time;
        }
        return result;
    }


    @Override
    public void execute() {

    }
}
