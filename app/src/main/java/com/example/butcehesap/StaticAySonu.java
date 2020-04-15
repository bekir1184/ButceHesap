package com.example.butcehesap;


import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static android.content.Context.MODE_PRIVATE;

public class StaticAySonu {
    private static int aySonu=14;

    public static int getAySonu(Context context) throws IOException {
        FileInputStream fileInputStream=context.openFileInput("Bilgiler.txt");
        InputStreamReader inputStreamReader =new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader= new BufferedReader(inputStreamReader);

        return bufferedReader.read();

    }

    public static void setAySonu(int aySonu, Context context) {
        StaticAySonu.aySonu = aySonu;
        try {
            FileOutputStream kisiBilgi=context.openFileOutput("Bilgiler.txt",MODE_PRIVATE);
            kisiBilgi.write(aySonu);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
