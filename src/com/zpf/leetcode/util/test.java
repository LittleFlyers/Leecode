package com.zpf.leetcode.util;

import com.zpf.leetcode.Number_29;
import com.zpf.leetcode.Number_31;
import com.zpf.leetcode.hothundred.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    public static void echartGmT(List<Score> chartList) {
        Map<String, Score> map = new HashMap<>();
        //user.setName(obj.getString("names").trim());
//        List<Score> chartList = userService.echartGmT();
        List<String> strs = new ArrayList<String>();
        for (int i = 0; i < chartList.size(); i++) {
            String mm = chartList.get(i).getMonth();
            strs.add(mm);
        }
        ArrayList<String> sx = new ArrayList<String>();
        ArrayList<String> yw = new ArrayList<String>();
        ArrayList<String> wy = new ArrayList<String>();
        ArrayList<String> total = new ArrayList<String>();
        ArrayList<String> month = new ArrayList<String>();
        String[] array = {"1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"};
        for (int j = 0; j < array.length; j++) {
           /*boolean flag2 = strs.contains(array[j]);
           if(flag2){*/
            boolean thisMonthHasScore = false;
            for (int i = 0; i < chartList.size(); i++) {
                if (chartList.get(i).getMonth().equals(array[j])) {
/*                    sx.add(chartList.get(i).getSxscore());
                    yw.add(chartList.get(i).getYwscore());
                    wy.add(chartList.get(i).getWyscore());
                    total.add(chartList.get(i).getTotalscore());*/
                    map.put(array[j], chartList.get(i));
//                    month.add(array[j]);
                    thisMonthHasScore = true;
                    System.out.println(array[j] + " " + chartList.get(i).getSxscore());
                    break;
                }
                thisMonthHasScore = false;
            }
            if (!thisMonthHasScore) {
                System.out.println(array[j] + " " + "0");
    /*            sx.add("0");
                yw.add("0");
                wy.add("0");
                total.add("0");
                month.add(array[j]);*/
                map.put(array[j], null);
            }

        }
    }

    static class Score {
        String sx;
        String yw;
        String wy;
        String month;

        public Score(String sx, String yw, String wy, String month) {
            this.sx = sx;
            this.yw = yw;
            this.wy = wy;
            this.month = month;
        }

        public String getSxscore() {
            return sx;
        }

        public void setSx(String sx) {
            this.sx = sx;
        }

        public String getYwscore() {
            return yw;
        }

        public void setYw(String yw) {
            this.yw = yw;
        }

        public String getWyscore() {
            return wy;
        }

        public void setWy(String wy) {
            this.wy = wy;
        }

        public String getMonth() {
            return month;
        }

        public String getTotalscore() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }
    }

    public static void main(String[] args) {
        Hot_Number_309 number_44 = new Hot_Number_309();
        number_44.get();
    }

}
