package com.zpf.leetcode.number;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

public class Number_258 implements Execute {
    @Override
    public void execute() {
        Log.i("Number_258", addDigits(38));
    }

/*    public int addDigits(int num) {
        int temp = 0;
        String cache = String.valueOf(num);
        for (int i = 0; i < cache.length(); i++) {
            temp = Integer.parseInt(String.valueOf(cache.charAt(i))) + temp;
        }
        if (temp < 10) {
            return temp;
        } else {
            return addDigits(temp);
        }
    }*/

/*    public int addDigits(int num) {
        int temp = num;

        while (temp >= 10) {
            int cacheInt = 0;
            String cache = String.valueOf(temp);
            for (int i = 0; i < cache.length(); i++) {
                cacheInt = Integer.parseInt(String.valueOf(cache.charAt(i))) + cacheInt;
            }
            temp = cacheInt;
            Log.i("Number_258", temp);
        }
        return temp;
    }*/
    public int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}
