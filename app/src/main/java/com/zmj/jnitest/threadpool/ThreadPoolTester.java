package com.zmj.jnitest.threadpool;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogRecord;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2020/2/20
 * Description :
 */
public class ThreadPoolTester {

    /**
     * 自动复用线程
     */
    public void cacheThreadPool(){
        ExecutorService cacheThreadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++){
            final int index = i;
            cacheThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    Log.i("cacheThreadPool",Thread.currentThread().getName() + " " + index);
                }
            });

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 固定线程池
     */
    public void fixedThreadPool(){
        ExecutorService fixedThread = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++){
            final int index = i;
            fixedThread.execute(new Runnable() {
                @Override
                public void run() {
                    Log.i("fixedThread",Thread.currentThread().getName() + " " + index);
                }
            });
        }
    }

    /**
     * 单线程池
     */
    public void singleThreadPool(){
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++){
            final int index = i;

            singleThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    Log.i("singleThreadPool",Thread.currentThread().getName() + " " + index);
                }
            });
        }
    }

    /**
     * 定时、定周期 计划执行线程池
     */
    public void scheduleThreadPool(){
        Log.i("scheduledExecutor","准备等待3秒");
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        //定时3秒以后执行
        /*scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                Log.i("scheduledExecutor",Thread.currentThread().getName() + "定时3秒以后执行");
            }
        },3, TimeUnit.SECONDS);*/

        //定时2秒以后，每3秒执行一次
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                Log.i("scheduledExecutor",Thread.currentThread().getName() + "定时每3秒执行一次");
            }
        },2,3,TimeUnit.SECONDS);
    }


    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    };
}
