package com.rebensburgsolutions.sayit;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class LobbyOverviewActivity extends AppCompatActivity {
    Spinner spinner_difficulty;
    ArrayAdapter<CharSequence> spinner_adapter;
    ArrayList<String> lobbyList = new ArrayList<>();
    ArrayAdapter<String> adapter;
    String selectedFromList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby_overview);

        //LobbyList
        adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, lobbyList);
        final ListView lobbiesList = (ListView) findViewById(R.id.lobbies);
        lobbiesList.setAdapter(adapter);
        lobbiesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long arg3) {
                selectedFromList =(String) (lobbiesList.getItemAtPosition(position));
            }
        });

    }

    public void joinButtonClicked(View view){
        Toast.makeText(getBaseContext(), "Join "+selectedFromList, Toast.LENGTH_SHORT).show();

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
            }
        });

        //Difficulty Selection
        spinner_difficulty = (Spinner)alertLayout.findViewById(R.id.spinner_difficulty);
        spinner_adapter = ArrayAdapter.createFromResource(this, R.array.difficulty,android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_difficulty.setAdapter(spinner_adapter);
        spinner_difficulty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+"",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        alert.setPositiveButton("Create", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String lobbyName = tfLobbyname.getText().toString();
                Toast.makeText(getBaseContext(), "Lobbyname: " + lobbyName, Toast.LENGTH_SHORT).show();
                if(lobbyName.length()>0){
                    lobbyList.add(""+lobbyName);
                }
                adapter.notifyDataSetChanged();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }
}
