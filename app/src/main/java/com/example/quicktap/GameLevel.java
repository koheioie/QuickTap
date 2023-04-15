package com.example.quicktap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameLevel extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_level);

        ((Button)findViewById(R.id.button33)).setOnClickListener(this);

        ((Button)findViewById(R.id.buttonhome)).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case(R.id.button33):
                Intent intentGame3 = new Intent(getApplication(),GameAction3.class);
                startActivity(intentGame3);
                break;

            case(R.id.buttonhome):
                Intent intentHome = new Intent(getApplication(),MainActivity.class);
                startActivity(intentHome);
                break;

        }
    }
}