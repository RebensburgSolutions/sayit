package com.rebensburgsolutions.sayit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


/**
 * @author Lukas Voigt
 */

public class WelcomeRegisterOrLoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_register_or_login);
    }






    public void buttonClicked(View view){

        switch (Integer.parseInt(view.getTag().toString())){

            case(0):
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                break;
            case(1):
                Intent j = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(j);
                break;
            default:
                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();


        }


    }
}
