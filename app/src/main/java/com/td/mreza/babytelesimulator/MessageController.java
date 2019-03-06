package com.td.mreza.babytelesimulator;

import android.util.Log;

import java.util.ArrayList;

public class MessageController {
    public ArrayList<Integer> cache;
    public ConnectionManager connectionManager;

    public MessageController(){
        this.connectionManager = new ConnectionManager();
    }
    public void fetch(Boolean fromCache){
        if (fromCache){
            //storage manager
        }
        else {
            //todo : review code and refactor
            int[] numbers = connectionManager.load(0).clone();
            int[] numbers2 = connectionManager.load(10).clone();
        }
    }
}
