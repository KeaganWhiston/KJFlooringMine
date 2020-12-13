package com.example.kjflooring.Settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import com.example.kjflooring.R;

/**
 * @author jordanflorence
 * SettingsActivity - retrieve the settings from the preferences.xml file.
 */
public class SettingsActivity extends AppCompatActivity {


    /**
     * @param savedInstanceState - references the Bundle object passed into the onCreate method.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content,
                new CustomPreferenceFragment()).commit();
    }

    /**
     * References - preferences.xml to populate the SettingsActivity.
     */
    public static class CustomPreferenceFragment extends PreferenceFragment {
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }


}