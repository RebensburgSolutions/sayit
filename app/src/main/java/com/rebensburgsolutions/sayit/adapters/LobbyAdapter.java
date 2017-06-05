package com.rebensburgsolutions.sayit.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rebensburgsolutions.sayit.R;

import java.util.ArrayList;

public class LobbyAdapter extends ArrayAdapter<String[]> {

    Context context;
    int layoutResourceId;
    ArrayList<String[]> data = null;

    public LobbyAdapter(Context context, ArrayList<String[]> data) {
        super(context, R.layout.layout_lobbyrow, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View customRow = inflater.inflate(R.layout.layout_lobbyrow, parent, false);;

        String[] rowContent = getItem(position);
        final TextView lobbyName = (TextView) customRow.findViewById(R.id.lobby_name);
        TextView playerAmount = (TextView) customRow.findViewById(R.id.player_amount);
        lobbyName.setText(rowContent[0]);
        playerAmount.setText(rowContent[1]);
        return customRow;
    }

}