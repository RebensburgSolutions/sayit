package com.rebensburgsolutions.sayit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * Neue Benutzer können registriert werden
 * @author Lukas Voigt
 */

public class RegisterActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText etMail;
    private EditText etPassword;
    private EditText etUsername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etPassword = (EditText) findViewById(R.id.et_password);
        etMail = (EditText) findViewById(R.id.et_mail);
        etUsername = (EditText) findViewById(R.id.et_username);




        mAuth = FirebaseAuth.getInstance();


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                   //Benutzer angemeldet
                    Log.d("info", "onAuthStateChanged:signed_in:" + user.getUid());
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

    /**
     * Neuer Benutzer wird bei Firebase hinzugefügt
     * @param view
     */
    public void register(View view){

        String email = etMail.getText().toString();
        String password = etPassword.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("info", "createUserWithEmail:onComplete:" + task.isSuccessful());


                        if (!task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login Failed",
                                    Toast.LENGTH_SHORT).show();
                        }else{
                            Intent i = new Intent(getApplicationContext(), LobbyActivity.class);
                            startActivity(i);
                        }

                        // ...
                    }
                });
    }


}
