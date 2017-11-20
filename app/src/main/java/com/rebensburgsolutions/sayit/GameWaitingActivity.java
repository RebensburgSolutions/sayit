package com.rebensburgsolutions.sayit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameWaitingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_lobby);
    }

    public void startGame(View view){
        Intent i = new Intent(GameWaitingActivity.this, GameActivity.class);
        startActivity(i);
    }
}
