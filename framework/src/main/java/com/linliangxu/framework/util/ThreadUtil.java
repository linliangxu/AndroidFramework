package com.linliangxu.framework.util;

import android.app.ActivityManager;
import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池,执行子线程
 * Created by Administrator on 12/7/2015.
 */
public class ThreadUtil {

    private static ExecutorService executorService;

    /**
     * 执行一个线程
     * @param runnable
     */
    public static void execute(Runnable runnable){
        if(executorService == null){
            executorService = Executors.newFixedThreadPool(3);
        }

        executorService.execute(runnable);
    }

    /**
     * 初始化Handler
     */
    public static void init(){

    }

    /**
     * 延时
     * @param time
     */
    public static void sleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static int getCurProcessId(){
        return android.os.Process.myPid();
    }


    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager
                .getRunningAppProcesses()) {
            if (appProcess.pid == pid) {

                return appProcess.processName;
            }
        }
        return null;
    }

}
