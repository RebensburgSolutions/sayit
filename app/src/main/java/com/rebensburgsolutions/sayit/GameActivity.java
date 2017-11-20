package com.rebensburgsolutions.sayit;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.rebensburgsolutions.sayit.adapters.PlayerStatsRecyclerAdapter;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private ArrayList<String> stringArrayList;
    private RecyclerView playerList;
    private PlayerStatsRecyclerAdapter adapter;
    private BottomSheetBehavior mBottomSheetBehavior;

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingame_tabview1);

        setTitle("Lobby");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        View bottomSheet = findViewById(R.id.bottom_sheet);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        mBottomSheetBehavior.setPeekHeight(390);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        if (mBottomSheetBehavior != null) {

            mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                @Override
                public void onStateChanged(@NonNull View bottomSheet, int newState) {
                    if(newState==BottomSheetBehavior.STATE_COLLAPSED){

                    }
                }

                @Override
                public void onSlide(@NonNull View bottomSheet, float slideOffset) {

                }
            });
        }
        playerList = (RecyclerView) findViewById(R.id.rv_player_stats);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        playerList.setLayoutManager(layoutManager);

        setData(); //adding data to array list
        adapter = new PlayerStatsRecyclerAdapter(stringArrayList);
        playerList.setAdapter(adapter);
    }

    private void setData() {
        stringArrayList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            stringArrayList.add("Item " + (i + 1));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                //Quit game dialog

                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Lobby verlassen");
                alert.setMessage("Wollen Sie das Spiel wirklich verlassen? Sie verlieren dadurch alle erspielten Punkte");
                // this is set the view from XML inside AlertDialog
                // disallow cancel of AlertDialog on click of back button and outside touch
                alert.setCancelable(false);
                alert.setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                alert.setPositiveButton("Verlassen", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        upButton();
                    }
                });
                AlertDialog dialog = alert.create();
                dialog.show();
//                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void upButton (){
        NavUtils.navigateUpFromSameTask(this);
    }
}
