package com.example.contacts_sort;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FIrstAdapter extends RecyclerView.Adapter<FIrstAdapter.FIrstViewHolder> {
    private Context mCtx;
    ArrayList<CountriesModel> mCountriesModelList;
    private ArrayList<String> contents;
    LinearLayoutManager gl;
    SecondAdapter second;
    public  final static  String Tag="test";

    public FIrstAdapter(Context mCtx, ArrayList<CountriesModel> mCountriesModelList) {
        this.mCtx = mCtx;
        this.mCountriesModelList = mCountriesModelList;
       // tagList = new ArrayList<>();
        //        this.contents = contents;
        contents = new ArrayList<>();

    }

    @Override
    public FIrstAdapter.FIrstViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item_header_title, null);
        return new FIrstAdapter.FIrstViewHolder(view);

    }

    @Override
    public void onBindViewHolder(FIrstAdapter.FIrstViewHolder holder, int position) {
        if (mCountriesModelList.get(position).isSection) {
            CountriesModel sectionItem = mCountriesModelList.get(position);

            holder.headerTitleTextview.setText(sectionItem.name);
        }
        else
        {
            gl = new LinearLayoutManager(mCtx);

            contents.add(mCountriesModelList.get(position).name.toString());
            Log.d("content",contents.toString());
            holder.rv.setLayoutManager(gl);
            second = new SecondAdapter(mCtx,contents);
            holder.rv.setAdapter(second);



        }

    }

    @Override
    public int getItemCount() {
        return mCountriesModelList.size();
    }

    public class FIrstViewHolder extends RecyclerView.ViewHolder {
        TextView headerTitleTextview;
          RecyclerView rv;
        public FIrstViewHolder(View itemView) {
            super(itemView);
            headerTitleTextview = (TextView) itemView.findViewById(R.id.headerTitleTextview);
            rv=(RecyclerView) itemView.findViewById(R.id.rv);



        }
    }
}
