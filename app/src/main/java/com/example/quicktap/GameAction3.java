package com.example.quicktap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.SimpleTimeZone;

import java.util.logging.LogRecord;

public class GameAction3 extends AppCompatActivity implements Runnable,View.OnClickListener{
    //GameAction3クラス
    //AppCompatActivityはAndroidアプリを利用するのに必要な基本的なクラス
    //
    //View.OnClickListenerクラスはボタンに対するクリック処理を設定する為のクラス
    /*Viewクラスの中にOnclickListenerというインターフェースが定義されているので、
     OnclickListenerを使う際はView.OnclickListenerという風にして使う*/

    /*
    スレッド(Thread)と(Runnable)は、プログラム上で複数の処理を同時に動かす仕組み
    ↓
    上を継承したクラスでスレッド(Thread)と(Runnable)で実行したい処理をrunメソッドに書く
    ↓
    記述したスレッド(Thread)と(Runnable)で実行するにはこのThreadを継承したクラスのインスタンスを生成し、startメソッドを呼び出す
    ↓


     */

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;

    private Button startbtn;
    private Button finishbtn;

    private Button homebtn;

    private Button retrybtn;


    private boolean startphase;

    private final SimpleDateFormat data = new SimpleDateFormat("mm:ss:SS",Locale.JAPAN);
    //final他の値を代入出来ない
    //SimpleDateFormatクラスは日付のフォーマットと解析を、ロケールを考慮して行うための具象クラス


    private TextView textTime;


    private final Handler handler = new Handler(Looper.getMainLooper());
    //別のスレッドからはアクセスできないのでHandlerを通す

    private volatile boolean timephase = false;
    //フィールドの値の共有


    private int count;

    private long startTime;


    //Activityクラスの
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            //Bundleにはアプリの状態を保存できて画面の切り替えなどに使う
        setContentView(R.layout.activity_game_action3);
        //setContentViewは画面に表示するレイアウトを指定する記述（

            startphase = false;
        count = 1;

        b1 = findViewById(R.id.button1);
        //()のなかのidを見つけてButtonクラスに代入
        b1.setOnClickListener(this);
        //()にボタンを押された時の処理を記述
        b2 = findViewById(R.id.button2);
        b2.setOnClickListener(this);
        b3 = findViewById(R.id.button3);
        b3.setOnClickListener(this);
        b4 = findViewById(R.id.button4);
        b4.setOnClickListener(this);
        b5 = findViewById(R.id.button5);
        b5.setOnClickListener(this);
        b6 = findViewById(R.id.button6);
        b6.setOnClickListener(this);
        b7 = findViewById(R.id.button7);
        b7.setOnClickListener(this);
        b8 = findViewById(R.id.button8);
        b8.setOnClickListener(this);
        b9 = findViewById(R.id.button9);
        b9.setOnClickListener(this);
        startbtn = findViewById(R.id.buttonstart);
        startbtn.setOnClickListener(this);

        finishbtn = findViewById(R.id.buttonfinish);
        finishbtn.setOnClickListener(this);
        homebtn = findViewById(R.id.buttonHome);
        homebtn.setOnClickListener(this);
        retrybtn = findViewById(R.id.buttonRetry);
        retrybtn.setOnClickListener(this);
        ((Button) findViewById(R.id.buttonHome)).setOnClickListener(this);
        ((Button) findViewById(R.id.buttonRetry)).setOnClickListener(this);
        finishbtn.setVisibility(View.INVISIBLE);
        textTime = (TextView)findViewById(R.id.textTime);
        textTime.setText(data.format(0));



        List<String> number = new ArrayList<String>();
        number.add("1");
        number.add("2");
        number.add("3");
        number.add("4");
        number.add("5");
        number.add("6");
        number.add("7");
        number.add("8");
        number.add("9");
        Collections.shuffle(number);
        //アレイリストの番号をシャッフル

        b1.setText(number.get(0));
        b2.setText(number.get(1));
        b3.setText(number.get(2));
        b4.setText(number.get(3));
        b5.setText(number.get(4));
        b6.setText(number.get(5));
        b7.setText(number.get(6));
        b8.setText(number.get(7));
        b9.setText(number.get(8));


    }

    @Override
    public void onClick(View v) {
            Thread thread;
        switch (v.getId()){
            case(R.id.button1):
                if(startphase==true){
                    if(b1.getText().toString().equals(String.valueOf(count))){
                        b1.setVisibility(View.INVISIBLE);
                        //見えなくする
                        count++;
                    }
                    if(count==10){
                        timephase = true;
                        textTime.setText(data.format(0));
                        finishbtn.setVisibility(View.VISIBLE);
                        homebtn.setVisibility(View.INVISIBLE);
                        retrybtn.setVisibility(View.INVISIBLE);

                    }
                }

                break;
            case(R.id.button2):
                if(startphase==true){
                if(b2.getText().toString().equals(String.valueOf(count))){
                    b2.setVisibility(View.INVISIBLE);
                    count++;
                }
                if(count==10){
                    timephase = true;
                    textTime.setText(data.format(0));
                    finishbtn.setVisibility(View.VISIBLE);
                    homebtn.setVisibility(View.INVISIBLE);
                    retrybtn.setVisibility(View.INVISIBLE);

                }}
                break;
            case(R.id.button3):
                if(startphase==true){
                if(b3.getText().toString().equals(String.valueOf(count))){
                    b3.setVisibility(View.INVISIBLE);
                    count++;
                }
                if(count==10){
                    timephase = true;
                    textTime.setText(data.format(0));
                    finishbtn.setVisibility(View.VISIBLE);
                    homebtn.setVisibility(View.INVISIBLE);
                    retrybtn.setVisibility(View.INVISIBLE);

                }}
                break;
            case(R.id.button4):
                if(startphase==true){
                if(b4.getText().toString().equals(String.valueOf(count))){
                    b4.setVisibility(View.INVISIBLE);
                    count++;
                }
                if(count==10){
                    timephase = true;
                    textTime.setText(data.format(0));
                    finishbtn.setVisibility(View.VISIBLE);
                    homebtn.setVisibility(View.INVISIBLE);
                    retrybtn.setVisibility(View.INVISIBLE);

                }}
                break;
            case(R.id.button5):
                if(startphase==true){
                if(b5.getText().toString().equals(String.valueOf(count))){
                    b5.setVisibility(View.INVISIBLE);
                    count++;
                }
                if(count==10){
                    timephase = true;
                    textTime.setText(data.format(0));
                    finishbtn.setVisibility(View.VISIBLE);
                    homebtn.setVisibility(View.INVISIBLE);
                    retrybtn.setVisibility(View.INVISIBLE);

                }}
                break;
            case(R.id.button6):
                if(startphase==true){
                if(b6.getText().toString().equals(String.valueOf(count))){
                    b6.setVisibility(View.INVISIBLE);
                    count++;
                }
                if(count==10){
                    timephase = true;
                    textTime.setText(data.format(0));
                    finishbtn.setVisibility(View.VISIBLE);
                    homebtn.setVisibility(View.INVISIBLE);
                    retrybtn.setVisibility(View.INVISIBLE);

                }}
                break;
            case(R.id.button7):
                if(startphase==true){
                if(b7.getText().toString().equals(String.valueOf(count))){
                    b7.setVisibility(View.INVISIBLE);
                    count++;
                }
                if(count==10){
                    timephase = true;
                    textTime.setText(data.format(0));
                    finishbtn.setVisibility(View.VISIBLE);
                    homebtn.setVisibility(View.INVISIBLE);
                    retrybtn.setVisibility(View.INVISIBLE);

                }}
                break;
            case(R.id.button8):
                if(startphase==true){
                if(b8.getText().toString().equals(String.valueOf(count))){
                    b8.setVisibility(View.INVISIBLE);
                    count++;
                }
                if(count==10){
                    timephase = true;
                    textTime.setText(data.format(0));
                    finishbtn.setVisibility(View.VISIBLE);
                    homebtn.setVisibility(View.INVISIBLE);
                    retrybtn.setVisibility(View.INVISIBLE);

                }}
                break;
            case(R.id.button9):
                if(startphase==true){
                if(b9.getText().toString().equals(String.valueOf(count))){
                    b9.setVisibility(View.INVISIBLE);
                    count++;
                }
                if(count==10){
                    timephase = true;

                    textTime.setText(data.format(0));
                    finishbtn.setVisibility(View.VISIBLE);
                    homebtn.setVisibility(View.INVISIBLE);
                    retrybtn.setVisibility(View.INVISIBLE);

                }}
                break;
            case (R.id.buttonstart):
                startbtn.setVisibility(View.INVISIBLE);
                startphase = true;
                timephase =false;
                thread = new Thread(this);
                thread.start();
                startTime = System.currentTimeMillis();
                break;

            case(R.id.buttonfinish):
                Intent intent1 = new Intent(getApplication(),ScoreZone.class);
                intent1.putExtra("score",textTime.getText().toString());
                startActivity(intent1);
                break;

            case(R.id.buttonHome):
                Intent intentHome = new Intent(getApplication(),MainActivity.class);
                startActivity(intentHome);
                break;
            case(R.id.buttonRetry):

                Intent intentRetry = new Intent(getApplication(),GameAction3.class);
                startActivity(intentRetry);
                break;

        }
    }

    @Override
    public void run() {
            int period = 10;
            while (!timephase){
                try{
                    Thread.sleep(period);
                    //スレッドを一時停止

                }catch (InterruptedException e){
                    e.printStackTrace();
                    timephase = true;
                }
                handler.post(new Runnable() {
                    //postで受け渡し

                    @Override
                    public void run() {
                        long endTime = System.currentTimeMillis();
                        long nowTime = (endTime - startTime);
                        textTime.setText(data.format(nowTime));

                    }

                });
            }

    }
}