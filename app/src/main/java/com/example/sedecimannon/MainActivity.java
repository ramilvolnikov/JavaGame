package com.example.sedecimannon;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity<shex> extends AppCompatActivity {
    private TextView testTextView;
    private TextView TextView2;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            String bin10 = DecToBin(8);
            String bin0 = DecToBin(0);
            String binm1 = DecToBin(-1);
            String sbin10 = DecToBin("8");
            String sbin0 = DecToBin("0");
            String sbinm1 = DecToBin("-1");

            String octal10 = DecToOctal(8);
            String octal0 = DecToOctal(0);
            String octalm1 = DecToOctal(-1);
            String soctal10 = DecToOctal("8");
            String soctal0 = DecToOctal("0");
            String soctalm1 = DecToOctal("-1");

            String hex10 = DecToHex(8);
            String hex0 = DecToHex(0);
            String hexm1 = DecToHex(-1);
            String shex10 = DecToHex("8");
            String shex0 = DecToHex("0");
            String shexm1 = DecToHex("-1");
        }
        catch (ArithmeticException e){Log.e("ERROR", String.valueOf(e));}
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread thread = new Thread(runnable);
        thread.start();

//TODO: create for this single function.
// Maybe set local variable for time and connect with gradientlists
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_layout);

        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();

        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(3500);

        animationDrawable.start();
    }

    //For counter and changer expro
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            // имитация длительного процесса
            for (; ; ) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ExprtoText(Integer.toString((int) (Math.random() * 50 - 10)));
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

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
// TODO: rewrite like toBinaryString
    private String DecToBin (Integer dec){
        if (dec == 0) return "0";
        if (dec < 0) Log.e("ERROR", "Number less than zero");
        String bin = "";
        try{
            while ( dec > 0){
                bin += Integer.toString(dec % 2);
                dec /= 2;
            }
        }catch(ArithmeticException e){Log.e("ERROR", String.valueOf(e));}
        Log.d("DecToBin", new StringBuilder(bin).reverse().toString() + " number: " + dec);
        return  new StringBuilder(bin).reverse().toString();
    }

    private String DecToOctal (Integer dec){
        if (dec == 0) return "0";
        if (dec < 0) Log.e("ERROR", "Number less than zero");
        String octal = "";
        try{
            while ( dec > 0){
                octal += Integer.toString(dec % 8);
                dec /= 8;
            }
        }catch(ArithmeticException e){Log.e("ERROR", String.valueOf(e));}
        Log.d("DecToOctal", new StringBuilder(octal).reverse().toString() + " number: " + dec);
        return  new StringBuilder(octal).reverse().toString();
    }

    private String DecToHex (Integer dec){
        if (dec == 0) return "0";
        if (dec < 0) Log.e("ERROR", "Number less than zero");
        String hex = "";
        try{
            while ( dec > 0){
                hex += Integer.toString(dec % 16);
                if ((new Integer(hex))>9) {
                    hex - strhex[Integer.parseInt(hex)];
                }
                dec /= 16;
            }
        }catch(ArithmeticException e){Log.e("ERROR", String.valueOf(e));}
        Log.d("DecToHex", new StringBuilder(hex).reverse().toString() + " number: " + dec);
        return  new StringBuilder(hex).reverse().toString();
    }

    //TODO:

    String[] strhex = new String[16];
    strhex[10] = "A";
    strhex[10] = "B";
    strhex[10] = "C";
    strhex[10] = "D";
    strhex[10] = "E";
    strhex[10] = "F";

    private String DecToBin (String dec){
        return "-1";
    }
    private String DecToOctal (String dec){
        return "-1";
    }
    private String DecToHex (String dec){
        return "-1";
    }

}
