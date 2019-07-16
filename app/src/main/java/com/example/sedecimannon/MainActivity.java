package com.example.sedecimannon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView testTextView;
    private TextView TextView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            String bin10 = DecToBin(8);
            String bin0 = DecToBin(0);
            String binm1 = DecToBin(-1);
        }
        catch (ArithmeticException e){Log.e("ERROR", String.valueOf(e));}

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            public void run() {
                for(;;)
                try {
                    Thread.sleep(1000);
                    Integer i = (int) (Math.random() * 50 - 10);
                    ExprtoText(Integer.toString(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

//Expression generation and text assignment
    private void ExprtoText(String s){
        testTextView = (TextView) findViewById(R.id.textView);
        testTextView.setTag(1);
        testTextView.setText(s);
        TextView2 = (TextView) findViewById(R.id.textView2);
        Integer textInTV2 = Integer.parseInt(TextView2.getText().toString());
        TextView2.setText(Integer.toString(textInTV2 + 1));
    }

//Decimal to binary system
//TODO: rewrite like toBinaryString
    private String DecToBin (Integer dec){
        if (dec == 0) return "0";
        if (dec < 0) Log.e("ERROR", "Number less than zero");
        String bin = "";
        try{
            while ( dec > 0){
                bin += Integer.toString(dec % 2);
                //dec /= 0;
                dec /= 2;
            }
        }catch(ArithmeticException e){Log.e("ERROR", String.valueOf(e));}
        Log.d("DecToBin", new StringBuilder(bin).reverse().toString());
        return  new StringBuilder(bin).reverse().toString();
    }

//TODO:
    private String DecToBin (String dec){
        return "-1";
    }
}
