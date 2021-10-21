package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;

public class Hot_Number_461 implements Execute {
    @Override
    public void execute() {

    }

    public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        String binaryStr = Integer.toBinaryString(temp);
        return binaryStr.length() - binaryStr.replace("1", "").length();
    }
}
