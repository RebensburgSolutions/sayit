package com.rebensburgsolutions.sayit.utilities;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by svenhofmann on 20.05.17.
 */

public class PreferenceManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "intro_slider-welcome";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String USERNAME = "Username";

    public PreferenceManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public String getUsername() {
        return pref.getString(USERNAME, "unknown");
    }

    public void setUsername(String username) {
        editor.putString(USERNAME, username);
        editor.commit();
    }
}
