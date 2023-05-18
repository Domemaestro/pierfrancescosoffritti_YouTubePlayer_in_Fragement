package com.example.youtubefragment.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubefragment.FullScreenPlayer;
import com.example.youtubefragment.Models.Items;
import com.example.youtubefragment.R;
import com.squareup.picasso.Picasso;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;

    public MyAdapter(Context context, Items[] items) {
        this.context = context;
        this.items = items;
    }

    Items[] items;
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_rc,parent,false);
        return new MyViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Items videoId = items[position];

        holder.TitleHolder.setText(items[position]
                .getSnippet()
                .getTitle());

        Picasso.get().load(items[position].
                getSnippet()
                .getThumbnails()
                .getHigh()
                .getUrl())
                .into(holder.Thumbnail);

        holder.PlayBtn.setOnClickListener(view -> {
            Intent i = new Intent(context, FullScreenPlayer.class);
            i.putExtra("VideoId",videoId.getId().getVideoId());
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return items.length;
    }
}
