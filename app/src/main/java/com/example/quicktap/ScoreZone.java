package com.example.quicktap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreZone extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_zone);

        Intent intent = getIntent();
        String score = intent.getStringExtra("score");

        TextView Time = (TextView)findViewById(R.id.Time);

        TextView textTime = (TextView)findViewById(R.id.textTime);


        textTime.setText(score);


        ((Button) findViewById(R.id.buttonHome)).setOnClickListener(this);
        ((Button) findViewById(R.id.buttonRetry)).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
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
}