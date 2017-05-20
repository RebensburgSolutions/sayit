package com.rebensburgsolutions.sayit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    public Button button_go_username;

    public void init(){
        button_go_username = (Button)findViewById(R.id.button_username);
        button_go_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openLobbyActivity = new Intent(WelcomeActivity.this, LobbyActivity.class);
                startActivity(openLobbyActivity);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();
    }
}
