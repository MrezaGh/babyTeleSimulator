package com.td.mreza.babytelesimulator;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StorageManager {
    Context context;
    File database;

    public StorageManager(Context context){
        this.context = context;
        File database = new File(context.getFilesDir(), "database");
        FileOutputStream outputStream;
        String contents = "hello world";
        try {
            outputStream = context.openFileOutput("database", Context.MODE_PRIVATE);
            outputStream.write(contents.getBytes());
            outputStream.close();
            FileInputStream input = context.openFileInput("database");
            input.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i("allfiles: ", String.valueOf(context.fileList()[1]));
    }
    public void save(int lastNumber){

    }
    public void load(){
        try {
            FileInputStream inputStream = context.openFileInput("database");
            int data = inputStream.read();
            Log.i("file ->", String.valueOf(data));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.i("oops", "file not found");
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("oops", "couldn't read file");
        }
    }

}

class Storage extends Thread{
    @Override
    public void run() {

    }
}