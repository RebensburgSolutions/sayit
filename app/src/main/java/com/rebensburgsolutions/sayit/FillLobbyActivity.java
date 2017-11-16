package com.rebensburgsolutions.sayit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FillLobbyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_lobby);
    }

    public void startGame(View view){
        Intent i = new Intent(FillLobbyActivity.this, LobbyActivity.class);
        startActivity(i);
    }
}
