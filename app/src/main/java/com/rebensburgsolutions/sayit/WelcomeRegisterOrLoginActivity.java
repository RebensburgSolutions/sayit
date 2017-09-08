package com.rebensburgsolutions.sayit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * @author Lukas Voigt
 */

public class WelcomeRegisterOrLoginActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_register_or_login);

        mAuth = FirebaseAuth.getInstance();


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //Benutzer angemeldet
                    Log.d("info", "onAuthStateChanged:signed_in:" + user.getUid());
                    Intent i = new Intent(getApplicationContext(), LobbyActivity.class);
                    startActivity(i);
                } else {
                    //nicht angemeldet
                    Log.d("info", "onAuthStateChanged:signed_out");
                }

            }
        };
    }



    /**
     * Auth State Listener wird hinzugefügt
     */
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }


    /**
     * Auth State Listener wird beendet
     */
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
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
                break;


        }


    }
}
