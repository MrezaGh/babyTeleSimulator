package com.td.mreza.babytelesimulator;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

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
    public void fetch(Boolean fromCache){
        if (fromCache){
            //storage manager
            storageManager.load();

        }
        else {
            //todo : review code and refactor
            int[] numbers = connectionManager.load(0);
            int[] numbers2 = connectionManager.load(10);
        }
    }
}
