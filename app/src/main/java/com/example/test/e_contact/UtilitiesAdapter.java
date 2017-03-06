package com.example.test.e_contact;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class UtilitiesAdapter extends RecyclerView.Adapter<UtilitiesAdapter.ViewHolder> {

    private int[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public ViewHolder(ImageView v) {
            super(v);
            imageView = v;
        }
    }

    public UtilitiesAdapter(int[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    public UtilitiesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.utilities_image_view, parent, false);
        return new ViewHolder((ImageView) v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.imageView.setImageResource(mDataset[position]);

    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}


