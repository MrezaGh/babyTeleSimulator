package com.td.mreza.babytelesimulator;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class StorageManager {
    Context context;
    File database;

    public StorageManager(Context context){
        this.context = context;
        File database = new File(context.getFilesDir(), "database");
        FileOutputStream outputStream;
        String contents = "hello world";
        try {
            outputStream = new FileOutputStream("database");

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write(contents);
            bufferedWriter.close();


            FileInputStream fileInputStream = context.openFileInput("database");

            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String lineData = bufferedReader.readLine();

            Log.i("dataaaaa ", lineData);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d("fuckkk", "not found");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("fuckkk", "io exception");
        }
        Log.i("allfiles: ", String.valueOf(context.fileList()[1]));
    }
    public void save(int lastNumber){

    }
    public void load(){
        try {
            FileInputStream fileInputStream = context.openFileInput("database");

            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String lineData = bufferedReader.readLine();

            Log.i("files -> ", lineData);


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