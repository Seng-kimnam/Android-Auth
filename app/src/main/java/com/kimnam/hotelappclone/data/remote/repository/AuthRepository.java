package com.kimnam.hotelappclone.data.remote.repository;

import com.kimnam.hotelappclone.data.network.*;
import com.kimnam.hotelappclone.data.remote.models.request.LoginRequest;
import com.kimnam.hotelappclone.data.remote.models.response.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRepository {

    private final ApiNetwork apiNetwork;

    public AuthRepository(){
        apiNetwork = ApiClient.getClient().create(ApiNetwork.class);
    }
    public void login(String username , String password , LoginCallback loginCallback){
        try{
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setPhoneNumber(username);
            loginRequest.setPassword(password);
            loginCallback.onLoading();
            apiNetwork.loginRes(loginRequest).enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if(response.isSuccessful()  && response.body() != null){
                        loginCallback.onSuccess(response.body());
                    }else{
                        loginCallback.onError("Please re-check your username and password ");
                    }

                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    loginCallback.onError("Specific Error" + t.getMessage());
                }
            });
        }catch (Throwable e){
            loginCallback.onError(e.getMessage());
        }
    }
}
