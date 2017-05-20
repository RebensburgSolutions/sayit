package com.rebensburgsolutions.sayit;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class LobbyActivity extends AppCompatActivity {

    ArrayList<String> lobbyList = new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
        adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, lobbyList);
        ListView lobbiesList = (ListView) findViewById(R.id.lobbies);
        lobbiesList.setAdapter(adapter);

    }
    public void createButtonClicked(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_createlobbypopup, null);
        final EditText tfLobbyname = (EditText) alertLayout.findViewById(R.id.tf_lobbyname);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Create Lobby");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setPositiveButton("Create", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String lobbyName = tfLobbyname.getText().toString();
                Toast.makeText(getBaseContext(), "Lobbyname: " + lobbyName, Toast.LENGTH_SHORT).show();
                lobbyList.add(""+lobbyName);
                adapter.notifyDataSetChanged();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }
}
