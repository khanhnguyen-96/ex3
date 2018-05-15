package banana.mybk.Helpers;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import banana.mybk.R;

public class SharePreferenceHelper {
    Activity activity;
    public SharePreferenceHelper(Activity activity) {
        this.activity = activity;
    }

    public void saveBoolean(String key, Boolean value) {
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBoolean(String key) {
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        return sharedPref.getBoolean(key, false);
    }

    public void saveString(String key, String value) {
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key) {
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        return sharedPref.getString(key, "");
    }
}
