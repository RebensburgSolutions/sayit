package com.rebensburgsolutions.sayit.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rebensburgsolutions.sayit.R;

import java.util.ArrayList;

/**
 * Created by svenhofmann on 21.05.17.
 */


//TODO Needs to be changed later!
public class LobbyRecyclerAdapter extends RecyclerView.Adapter<LobbyRecyclerAdapter.LobbyRecyclerViewHolder> {

    private ArrayList<String> items;

    public LobbyRecyclerAdapter(ArrayList<String> items) {
        this.items = items;
    }

    public LobbyRecyclerAdapter() {
    }

    @Override
    public LobbyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.recyclerview_lobby;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);

        return new LobbyRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LobbyRecyclerViewHolder holder, int position) {
        holder.mWordTextView.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        if(items == null) return 0;
        return items.size();
    }

    public class LobbyRecyclerViewHolder extends RecyclerView.ViewHolder {

        public final TextView mUsernameTextView;
        public final TextView mWordTextView;
        public final TextView mPointsTextView;


        public LobbyRecyclerViewHolder(View itemView) {
            super(itemView);
            mUsernameTextView = (TextView) itemView.findViewById(R.id.tv_username);
            mWordTextView = (TextView) itemView.findViewById(R.id.tv_word);
            mPointsTextView = (TextView) itemView.findViewById(R.id.tv_points);
        }
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
        notifyDataSetChanged();
    }
}
