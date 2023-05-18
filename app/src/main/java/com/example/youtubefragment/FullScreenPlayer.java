package com.example.youtubefragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class FullScreenPlayer extends AppCompatActivity {

    YouTubePlayerView fullScreenPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_player);

        fullScreenPlayer = findViewById(R.id.fullScreenYouTubePlayerPie);

        String videoId = getIntent().getStringExtra("VideoId");
        fullScreenPlayer.getYouTubePlayerWhenReady(youTubePlayer ->
                youTubePlayer.loadVideo(videoId,0f));


    }
}