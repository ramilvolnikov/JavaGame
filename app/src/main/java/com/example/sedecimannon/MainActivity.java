package com.example.sedecimannon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    Integer a = 6;
    int b = a;

//function xuyanction
    public static int bigger() {
        int k = 0;
        for (int i = 0; i<4; i++){
            int n = (int) (Math.random() * 10);
            if (n > k) {
                k = n;
            }
        }
        return k;
    }
}
