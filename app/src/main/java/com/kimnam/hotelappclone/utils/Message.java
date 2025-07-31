package com.kimnam.hotelappclone.utils;

import android.content.Context;
import android.widget.Toast;

public class Message {
    public static void showMessage(String theMessage , Context context){
        Toast.makeText( context,  theMessage, Toast.LENGTH_SHORT).show();
    }
}
