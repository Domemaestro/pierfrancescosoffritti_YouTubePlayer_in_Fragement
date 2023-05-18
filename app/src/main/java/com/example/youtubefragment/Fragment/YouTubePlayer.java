package com.example.youtubefragment.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.youtubefragment.API.SingletonRetrofitObject;
import com.example.youtubefragment.Adapter.MyAdapter;
import com.example.youtubefragment.Models.Items;
import com.example.youtubefragment.Models.VideoDetails;
import com.example.youtubefragment.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YouTubePlayer extends Fragment {
    RecyclerView recyclerView;

    public YouTubePlayer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_you_tube_player, container, false);
        recyclerView = view.findViewById(R.id.VideoList); //verify
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        recyclerView.hasFixedSize();
        dropApiCall();
        return view;

    }

    private void dropApiCall() {
        Call<VideoDetails> videoDetailsCall = SingletonRetrofitObject.getmInstance().getAPI().getVideoDetails(
                getString(R.string.YoutubeApi_key),
                "snippet",
                getString(R.string.channel),
                "50"
        );

        videoDetailsCall.enqueue(new Callback<VideoDetails>() {
            @Override
            public void onResponse(Call<VideoDetails> call, Response<VideoDetails> response) {
                setRecyclerView(response.body().getItems());
            }

            @Override
            public void onFailure(Call<VideoDetails> call, Throwable t) {

            }
        });
    }

    private void setRecyclerView(Items[] items) {
        MyAdapter adapter = new MyAdapter(getActivity(),items);
        recyclerView.setAdapter(adapter);
    }
}