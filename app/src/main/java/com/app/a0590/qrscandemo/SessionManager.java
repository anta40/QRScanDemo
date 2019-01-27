package com.app.a0590.qrscandemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by Andre Tampubolon (andre.tampubolon@idstar.co.id) on 1/27/2019.
 */
public class SessionManager {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context ctxt;
    private int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "QRScanDemoPref";
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";

    public SessionManager(Context ctxt){
        this.ctxt = ctxt;
        pref = ctxt.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(String email, String password){
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_PASSWORD, password);
        editor.putString(KEY_EMAIL, email);
        editor.commit();
    }

    public HashMap<String, String> getLoginDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        user.put(KEY_PASSWORD, pref.getString(KEY_PASSWORD, null));
        return user;
    }

    public void checkLogin(){
        if(!this.isLoggedIn()){
            Intent i = new Intent(ctxt, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ctxt.startActivity(i);
        }
    }

    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}


