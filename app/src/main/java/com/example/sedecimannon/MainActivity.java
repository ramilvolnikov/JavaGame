package com.example.sedecimannon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView testTextView;
    private TextView TextView2;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
            // Endless cycle
            for (; ; ) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                     ExprtoText(Integer.toString((int) (Math.random() * 50 - 10)));
                    }
                });
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

//Expression generation and text assignment
    private void ExprtoText(String s){
        testTextView = (TextView) findViewById(R.id.textView);
        //testTextView.setTag(1);
        testTextView.setText(s);
        TextView2 = (TextView) findViewById(R.id.textView2);
        Integer textInTV2 = Integer.parseInt(TextView2.getText().toString());
        TextView2.setText(Integer.toString(textInTV2 + 1));
        String d;
        Integer is = Integer.parseInt(s);;
        d = (DecToBin(is));
        b1 = (Button)findViewById(R.id.button1);
        //b1.setTag(1);
        b1.setText(d);

        d = (DecToOctal(is));
        Button b2 = (Button)findViewById(R.id.button2);
        //b2.setTag(1);
        b2.setText(d);

        d = (DecToHex(is));
        Button b3 = (Button)findViewById(R.id.button3);
        //b3.setTag(1);
        b3.setText(d);
    }
// TODO: Add description

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
    // TODO: REWRITE!!!!
    private String DecToHex (Integer dec){
        if (dec == 0) return "0";
        if (dec < 0) Log.e("ERROR", "Number less than zero");
        String hex = "";
        try{
           // while ( dec > 0) {
                hex = Integer.toHexString(dec);
           // }
        }catch(ArithmeticException e){Log.e("ERROR", String.valueOf(e));}
        Log.d("DecToHex", new StringBuilder(hex).toString() + " number: " + dec);
        return  new StringBuilder(hex).toString();
    }


    //TODO: DO IT!!!!!!!!!!!!!
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
