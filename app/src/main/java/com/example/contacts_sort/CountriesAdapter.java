package com.example.contacts_sort;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class CountriesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int SECTION_VIEW = 0;
    public static final int CONTENT_VIEW = 1;
    RecyclerView rv;

    ArrayList<CountriesModel> mCountriesModelList;
    private List<String> checkBoxItems;

    // WeakReference<Context> mContextWeakReference;
    Context mctx;

    public CountriesAdapter(ArrayList<CountriesModel> mCountriesModelList,  Context mctx) {
        this.mCountriesModelList = mCountriesModelList;

        this.mctx = mctx;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        //   Context context = mContextWeakReference.get();
        if (viewType == SECTION_VIEW) {


            return new SectionHeaderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header_title, parent, false));
        }
     //   GridLayoutManager gridLayoutManager = new GridLayoutManager(mctx,3);

        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name, parent, false), mctx);
    }
   /* layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
        @Override
        public int getSpanSize(int position) {
            int type=mAdapter.getItemViewType(position);
            if (type == "view holder type name")
                return 2;
            else
                return 1;
        }
    });*/

    @Override
    public int getItemViewType(int position) {
        if (mCountriesModelList.get(position).isSection) {
            return SECTION_VIEW;

        } else {
            return CONTENT_VIEW;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        //  Context context = mContextWeakReference.get();
        if (mctx == null) {
            return;
        }
        if (SECTION_VIEW == getItemViewType(position)) {

            SectionHeaderViewHolder sectionHeaderViewHolder = (SectionHeaderViewHolder) holder;
            CountriesModel sectionItem = mCountriesModelList.get(position);
            sectionHeaderViewHolder.headerTitleTextview.setText(sectionItem.name);
            return;
        }


        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        CountriesModel currentUser = ((CountriesModel) mCountriesModelList.get(position));
        itemViewHolder.nameTextview.setText(currentUser.name);

    }


    @Override
    public int getItemCount() {
        return mCountriesModelList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextview;

        public ItemViewHolder(View itemView, final Context context) {
            super(itemView);
            nameTextview = (TextView) itemView.findViewById(R.id.nameTextview);
        }
    }

    public class SectionHeaderViewHolder extends RecyclerView.ViewHolder {
        TextView headerTitleTextview;

        public SectionHeaderViewHolder(View itemView) {
            super(itemView);
            headerTitleTextview = (TextView) itemView.findViewById(R.id.headerTitleTextview);
        }
    }
}
