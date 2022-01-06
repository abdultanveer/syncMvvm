package com.abdul.mvvmapp;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.NamesVH>
{

    @NonNull
    @Override
    public NamesVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull NamesVH holder, int position) {

    }

    class NamesVH extends RecyclerView.ViewHolder {
        public NamesVH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
