package com.linliangxu.framework.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import java.text.SimpleDateFormat;

public class BoxUtil {

    /**
     * 设置定时开机
     */
    @SuppressLint("SimpleDateFormat")
    public static void poweron(Context context, long time){
        Intent intent = new Intent("zysd.alarm.poweron.time");

        String date = new SimpleDateFormat("yyyy-MM-dd").format(time);
        String dateTime = new SimpleDateFormat("HH:mm").format(time);

        intent.putExtra("poweronday", date);
        intent.putExtra("powerontime",dateTime);
        context.sendBroadcast(intent);
    }

    /**
     * 设置定时关机
     */
    @SuppressLint("SimpleDateFormat")
    public static void poweroff(Context context, long time){
        Intent intent = new Intent("zysd.alarm.poweroff.time");

        String date = new SimpleDateFormat("yyyy-MM-dd").format(time);
        String dateTime = new SimpleDateFormat("HH:mm").format(time);

        intent.putExtra("poweroffday", date);
        intent.putExtra("powerofftime", dateTime);
        context.sendBroadcast(intent);
    }

    /**
     * 取消定时关机命令
     */
    public static void cancelPowerOff(Context context){
        Intent intent = new Intent("zysd.alarm.poweroff.cancel");
        context.sendBroadcast(intent);
    }

    /**
     * 立即关机
     */
    public static void shutdownnow(Context context){
        Intent intent = new Intent("shutdown.zysd.now");
        context.sendBroadcast(intent);
    }

    /**
     * 立即重启
     */
    public static void rebootnow(Context context){
        Intent intent = new Intent("reboot.zysd.now");
        context.sendBroadcast(intent);
    }

}
