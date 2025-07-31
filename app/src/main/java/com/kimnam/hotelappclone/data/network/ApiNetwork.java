package com.kimnam.hotelappclone.data.network;

import com.kimnam.hotelappclone.data.remote.models.request.LoginRequest;
import com.kimnam.hotelappclone.data.remote.models.response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiNetwork {
    @POST("/api/oauth/token")
    Call<LoginResponse> loginRes(@Body LoginRequest req);
}
