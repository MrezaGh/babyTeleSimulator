package com.td.mreza.babytelesimulator;

import android.util.Log;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class ConnectionManager {
    private int delay = 5000;



    public int[] load(final int lastPreviousNum){
        final int[] numbers = new int[10];
        final CountDownLatch latch = new CountDownLatch(1);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(delay);
                    returnNumbers(lastPreviousNum, numbers);
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i("CurrentThread: ", Thread.currentThread().getName());
            }
        };

        Thread cloud = new Thread(runnable, "cloud thread");
        cloud.start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i("connection thread ->", String.valueOf(Thread.currentThread().getId()));
        return numbers.clone();
    }


    private void returnNumbers(int lastPreviousNum,int[] numbers) {
        for (int i = 0; i < 10; i++) {
            numbers[i] = i + lastPreviousNum + 1;
        }
    }
}
