package com.rebensburgsolutions.sayit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.rebensburgsolutions.sayit.adapters.LobbyRecyclerAdapter;

import java.util.ArrayList;

public class LobbyActivity extends AppCompatActivity {

    private ArrayList<String> stringArrayList;
    private RecyclerView recyclerView;
    private LobbyRecyclerAdapter adapter;

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        setTitle("Lobby");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.rv_lobby);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        setData(); //adding data to array list
        adapter = new LobbyRecyclerAdapter(stringArrayList);
        recyclerView.setAdapter(adapter);
    }

    private void setData() {
        stringArrayList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            stringArrayList.add("Item " + (i + 1));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lobby, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_item_lobby_edit:
                Toast.makeText(this, getString(R.string.edit), Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                Intent intent = new Intent(LobbyActivity.this, LobbyOverviewActivity.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
