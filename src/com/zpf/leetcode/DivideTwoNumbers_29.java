package com.zpf.leetcode;

import com.zpf.leetcode.util.Log;

import java.util.Scanner;

public class DivideTwoNumbers_29 {
    private static final String TAG = "DivideTwoNumbers_29";

    public int divide2(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE&&divisor==-1)
            return Integer.MAX_VALUE;

        boolean k=(dividend>0&&divisor>0)||(dividend<0&&divisor<0);
        int result=0;
        dividend=-Math.abs(dividend);
        divisor=-Math.abs(divisor);
        while(dividend<=divisor) {
            int temp=divisor;
            int c=1;
            while(dividend-temp<=temp) {
                temp=temp<<1;
                c=c<<1;
            }
            dividend-=temp;
            result+=c;
        }
        return k?result:-result;
    }

    public static int divide(int dividend, int divisor) {
        long t1 = dividend;
        long t2 = divisor;
        long result = 0;
        boolean isNegativeNumber = false;
        Log.i(TAG,Math.abs(t1) + " " + Math.abs(t2));
        if (Math.abs(t1) < Math.abs(t2)) return (int) result;
        if ((t1 < 0 && t2 > 0) || (t1 > 0 && t2 < 0)) isNegativeNumber = true;
        t1 = Math.abs(t1);
        t2 = Math.abs(t2);
        Log.i(TAG, t1);
        if (t2==1){
            result = t1;
        }else {
            while (t1 >= t2) {
                t1 -= t2;
                result++;
            }
        }
        if (isNegativeNumber) {
            if (result >= Math.pow(2, 31))
                return (int) -Math.pow(2, 31);
            return -(int) result;
        } else {
            if (result >= Math.pow(2, 31) - 1)
                return (int) Math.pow(2, 31);
            return (int) result;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            String s = sc.nextLine();
            String p = sc.nextLine();
            System.out.println("result:" + divide(Integer.parseInt(s), Integer.parseInt(p)));
        } while (true);

    }
}
