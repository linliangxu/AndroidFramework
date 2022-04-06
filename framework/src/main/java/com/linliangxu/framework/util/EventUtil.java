package com.linliangxu.framework.util;


/**
 * Created by MONDAY on 2016/8/6.
 */
public class EventUtil {


    private static long lastClickTime;
    private static int clickNumber;

    public static boolean continueClick(int number) {
        long time = System.currentTimeMillis();
        long timeDiff = time - lastClickTime;
        if (0 < timeDiff && timeDiff < 700) {
            clickNumber ++;
            if (clickNumber == number)
                return true;
        } else {
            clickNumber = 1;
        }
        lastClickTime = time;
        return false;
    }


}
