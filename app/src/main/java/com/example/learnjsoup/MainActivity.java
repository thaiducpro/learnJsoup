package com.example.learnjsoup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.lang.annotation.Documented;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document document = Jsoup.connect("https://www.google.com/").get();

                    System.out.println(document.title());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void search(View view){
        Intent intent = new Intent(this, result.class);
        startActivity(intent);

    }
}