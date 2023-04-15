package com.example.quicktap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView titles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
          /*画面に表示するビューの設定*/
         titles = findViewById(R.id.title);
        Button start = findViewById(R.id.start);
        ((Button)findViewById(R.id.start)).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case(R.id.start):
                Intent intentlevel = new Intent(getApplication(),GameLevel.class);
                //MainActivityからGameLevelを開く
                startActivity(intentlevel);
                //起動する
                break;

        }

    }
}