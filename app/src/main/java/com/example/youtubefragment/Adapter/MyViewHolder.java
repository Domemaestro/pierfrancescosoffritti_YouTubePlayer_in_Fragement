package com.example.youtubefragment.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubefragment.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView Thumbnail;
    ImageView PlayBtn;
    TextView TitleHolder;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        Thumbnail = itemView.findViewById(R.id.youTubePlayerView);
        PlayBtn = itemView.findViewById(R.id.PlayBtn_img);
        TitleHolder = itemView.findViewById(R.id.titleHolder);

    }
}
