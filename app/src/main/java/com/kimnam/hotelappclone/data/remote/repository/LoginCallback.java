package com.kimnam.hotelappclone.data.remote.repository;

import com.kimnam.hotelappclone.data.remote.models.response.LoginResponse;

public interface LoginCallback {
    void onLoading();
    void onError(String message);
    void onSuccess(LoginResponse loginResponse);


}
