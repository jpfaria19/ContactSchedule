package com.java.desenvolvimento.infnet.contactschedule.adapter;

import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.java.desenvolvimento.infnet.contactschedule.R;

public class RecycleAdapter extends RecyclerView.Adapter{

    private String[] dataTest;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ProgressBar pBar;

        public ViewHolder(View itemView) {
            super(itemView);
            pBar  = itemView.findViewById(R.id.progressBar);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
