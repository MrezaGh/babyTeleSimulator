package com.td.mreza.babytelesimulator;

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

    }
    public void fetch(final Boolean fromCache, final int lastNumber){
        final CountDownLatch latch = new CountDownLatch(1);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (fromCache){
                    //todo : review and refactor
                    int[] numbers = storageManager.load();
                    //notificationCenter.data_loaded(numbers);// todo: this line should be added after
                    // Notification Center implementation is done
                    Log.i("numbers: ", Arrays.toString(numbers));
                }
                else {
                    //todo : review code and refactor
                    int[] numbers = connectionManager.load(lastNumber);
                    boolean saved = storageManager.save(lastNumber + 10);
                    //notificationCenter.data_loaded(numbers);// todo: this line should be added after
                    // Notification Center implementation is done
                }

            }
        };
        Thread fetchThread = new Thread(runnable, "MessageController Fetch thread");
        fetchThread.start();


    }
}
