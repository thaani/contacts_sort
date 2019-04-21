package com.example.contacts_sort;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.SecondViewHolder> { private Context mCtx;
    private List<String> contents;


    public SecondAdapter(Context mCtx, List<String> contents) {
        this.mCtx = mCtx;
        this.contents = contents;

    }


    @Override
    public SecondAdapter.SecondViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item_name, null);
        return new SecondAdapter.SecondViewHolder(view);

    }

    @Override
    public void onBindViewHolder(SecondAdapter.SecondViewHolder holder, int position) {

        holder.item.setText(contents.get(position).toString());

    }

    @Override
    public int getItemCount() {
      return contents.size();
    }

    public class SecondViewHolder extends RecyclerView.ViewHolder {
        TextView item;
        public SecondViewHolder(View itemView) {
            super(itemView);
            item = (TextView) itemView.findViewById(R.id.nameTextview);

        }
    }
}
