package com.abdul.mvvmapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.NamesVH>{
    String[] mNames;
     public NamesAdapter(String[] names){
         mNames = names;
     }

    @NonNull
    @Override //1. created a row plank and put into VH box
    public NamesVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row,parent,false);
        return new NamesVH(rowView);
    }

    @Override
    public int getItemCount() {
        return mNames.length;
    }

    @Override
    public void onBindViewHolder(@NonNull NamesVH holder, int position) {
         holder.tvRow.setText(mNames[position]);

    }

    //2. i got the handle of the tv in the plank
    class NamesVH extends RecyclerView.ViewHolder {
         TextView tvRow;
        public NamesVH(@NonNull View itemView) {
            super(itemView);
            tvRow = itemView.findViewById(R.id.tvRow);
        }
    }
}
