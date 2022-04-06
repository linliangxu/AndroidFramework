package com.linliangxu.framework.util;


import java.util.List;

public final class MathUtil {

    public static float percent(int total, int value) {
        float percent = total > 0 ? ((float) value / total) : 0;
        if (percent < 0) percent = 0;
        else if (percent > 1) percent = 1;
        return percent;
    }


    public static int scoreRangeIndex(int score) {
        if (score < 60) return 0;
        else if (score < 70) return 1;
        else if (score < 80) return 2;
        else if (score < 90) return 3;
        else return 4;
    }


    public static Integer[] scoreRangeCount(List<String> list) {
        Integer[] result = {0, 0, 0, 0, 0};
        for (String string : list) {
            int score = Integer.parseInt(string);
            int index = scoreRangeIndex(score);
            result[index]++;
        }
        return result;
    }

}