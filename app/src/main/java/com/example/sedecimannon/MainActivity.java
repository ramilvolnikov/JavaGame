package com.example.sedecimannon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Random;
import android.view.View;

public class MainActivity extends Activity {
    private TextView testTextView;
    private TextView TextView2;
    private TextView TextView3;
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
                     ExprtoText(Integer.toString((int) (Math.random() * 100)));
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

    int RAND;
    Integer t2;
    Integer t3;
//Expression generation and text assignment
    private void ExprtoText(String s){
        testTextView = (TextView) findViewById(R.id.textView);
        //testTextView.setTag(1);
        testTextView.setText(s);
        TextView2 = (TextView) findViewById(R.id.textView2);
        TextView3 = (TextView) findViewById(R.id.textView3);
        Integer textInTV2 = Integer.parseInt(TextView2.getText().toString());
        Integer textInTV3 = Integer.parseInt(TextView3.getText().toString());
        t2 = textInTV2;
        t3 = textInTV3;
        if (t2>t3)
        {
            t3 = t2;
            TextView3.setText(Integer.toString(t3));

        }
        //TextView2.setText(Integer.toString(textInTV2 + 1));
        String d;
        final Random random = new Random();
        int rand = random.nextInt(3) + 1;
        Integer is = Integer.parseInt(s);;
        if (rand == 1) {
            d = (DecToBin(is));
        }else {d = (DecToBin(is+1));}
        b1 = (Button)findViewById(R.id.button1);
        //b1.setTag(1);
        b1.setText(d);

        if (rand == 2) {
        d = (DecToOctal(is));
        }else {d = (DecToOctal(is+1));}
        Button b2 = (Button)findViewById(R.id.button2);
        //b2.setTag(1);
        b2.setText(d);

        if (rand == 3) {
            d = (DecToHex(is));
        } else {d = (DecToHex(is+1));}
        Button b3 = (Button)findViewById(R.id.button3);
        //b3.setTag(1);
        b3.setText(d);

        RAND = rand;
    }


//Decimal to binary system

    private String DecToBin (Integer dec){
        if (dec == 0) return "0";
        if (dec < 0) Log.e("ERROR", "Number less than zero");
        String bin = "";
        try{
            if ( dec > 0) {
                bin = Integer.toBinaryString(dec);
            }
        }catch(ArithmeticException e){Log.e("ERROR", String.valueOf(e));}
        Log.d("DecToBin", new StringBuilder(bin).toString() + " number: " + bin);
        return  new StringBuilder(bin).toString();
    }


// Decimal to octal system

    private String DecToOctal (Integer dec){
        if (dec == 0) return "0";
        if (dec < 0) Log.e("ERROR", "Number less than zero");
        String octal = "";
        try{
            if ( dec > 0) {
                octal = Integer.toOctalString(dec);
            }
        }catch(ArithmeticException e){Log.e("ERROR", String.valueOf(e));}
        Log.d("DecToBin", new StringBuilder(octal).toString() + " number: " + octal);
        return  new StringBuilder(octal).toString();
    }


//Decimal to hex system

    private String DecToHex (Integer dec){
        if (dec == 0) return "0";
        if (dec < 0) Log.e("ERROR", "Number less than zero");
        String hex = "";
        try{
            if ( dec > 0) {
                hex = Integer.toHexString(dec);
            }
        }catch(ArithmeticException e){Log.e("ERROR", String.valueOf(e));}
        Log.d("DecToHex", new StringBuilder(hex).toString() + " number: " + dec);
        return  new StringBuilder(hex).toString();
    }



    private String DecToBin (String dec){
        return "-1";
    }
    private String DecToOctal (String dec){
        return "-1";
    }
    private String DecToHex (String dec){
        return "-1";
    }

    public void onClick1(View v)
    {
        if ((RAND == 1) && (testTextView.getText()!="TRUE!") && (testTextView.getText()!="FALSE!"))
        {
            testTextView.setText("TRUE!");
            t2++;
            TextView2.setText(Integer.toString(t2));
        }else {
            if ((RAND!=1)&& (testTextView.getText()!="TRUE!") && (testTextView.getText()!="FALSE!")) {
            testTextView.setText("FALSE!");
            TextView2.setText("0");
            }
        }

    }

    public void onClick2(View v)
    {
        if ((RAND == 2) && (testTextView.getText()!="TRUE!") && (testTextView.getText()!="FALSE!"))
        {
            testTextView.setText("TRUE!");
            t2++;
            TextView2.setText(Integer.toString(t2));
        }else {
            if ((RAND!=2)&& (testTextView.getText()!="TRUE!") && (testTextView.getText()!="FALSE!")) {
            testTextView.setText("FALSE!");
            TextView2.setText("0");
            }
        }

    }

    public void onClick3(View v)
    {
        if ((RAND == 3) && (testTextView.getText()!="TRUE!") && (testTextView.getText()!="FALSE!"))
        {
            testTextView.setText("TRUE!");
            t2++;
            TextView2.setText(Integer.toString(t2));
        }else {
            if ((RAND!=3) && (testTextView.getText()!="TRUE!") && (testTextView.getText()!="FALSE!")){
                testTextView.setText("FALSE!");
                TextView2.setText("0");
            }
        }

    }

}
