package com.example.recyclerviewpresiden;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListPresidenAdapter extends RecyclerView.Adapter<ListPresidenAdapter.CategoryViewHolder> {
    private Context context;

    ArrayList<Presiden> getListPresiden() {
        return listPresien;
    }

    void setListPresiden(ArrayList<Presiden> listPresiden) {
        this.listPresien = listPresiden;
    }

    private ArrayList<Presiden> listPresien;

    ListPresidenAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_presiden, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.tvName.setText(getListPresiden().get(position).getName());
        holder.tvRemarks.setText(getListPresiden().get(position).getRemarks());

        Glide.with(context)
                .load(getListPresiden().get(position).getPhoto())
                .into(holder.imgPhoto);

    }

    @Override
    public int getItemCount() {
        return getListPresiden().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvRemarks;
        ImageView imgPhoto;

        CategoryViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_item_name);
            tvRemarks = (TextView) itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = (ImageView) itemView.findViewById(R.id.img_item_photo);

        }

    }
}
