package com.example.youtubefragment.API;

import com.example.youtubefragment.Models.VideoDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {
    @GET("search")
    Call<VideoDetails> getVideoDetails(@Query("key") String key,
                                       @Query("part") String part,
                                       @Query("channelId") String channelId,
                                       @Query("maxResults") String maxResult);
}
