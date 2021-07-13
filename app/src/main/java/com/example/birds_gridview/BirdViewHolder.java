package com.example.birds_gridview;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BirdViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvImage;
    private ItemClickListener itemClickListener;

    public BirdViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvImage = this.itemView.findViewById(R.id.ivImage);
    }

    public void setData(Bird bird) {
        mIvImage.setImageResource(bird.getImage());
        mIvImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(getAdapterPosition(), bird);
            }
        });
    }
}
