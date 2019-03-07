package com.td.mreza.babytelesimulator;

import android.app.Notification;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class MessageController {
    public ArrayList<Integer> cache;
    String fileDir;
    Context context;
    ConnectionManager connectionManager;
    StorageManager storageManager;

    public MessageController(Context context){
        this.context = context;
        this.connectionManager = new ConnectionManager();
        this.storageManager = new StorageManager(context);
        this.cache = new ArrayList<>();

    }
    public void fetch(final Boolean fromCache, final int lastNumber){
        final CountDownLatch latch = new CountDownLatch(1);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (fromCache){
                    //todo : review and refactor
                    int[] numbers = storageManager.load(lastNumber);
                    //notificationCenter.data_loaded();// todo: this line should be added after Notification Center implementation is done
                    for (int number : numbers) {
                        cache.add(number);
                    }
                }
                else {
                    //todo : review code and refactor
                    int[] numbers = connectionManager.load(lastNumber);
                    boolean saved = storageManager.save(lastNumber + 10);
                    if (numbers != null){
                        for (int number : numbers) {
                            cache.add(number);
                        }
                    }

                    //notificationCenter.data_loaded();// todo: this line should be added after Notification Center implementation is done
                }
                Log.i("cache ", String.valueOf(cache));
            }
        };
        Thread fetchThread = new Thread(runnable, "MessageController Fetch thread");
        fetchThread.start();


    }
}
