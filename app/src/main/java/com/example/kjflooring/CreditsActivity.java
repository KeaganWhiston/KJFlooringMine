package com.example.kjflooring;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kjflooring.R;
import com.example.kjflooring.nav_products;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

/**
 * @author jordanflorence
 * CreditsActivity - populate this screen with the xml file -> activity_credits.xml.
 */
public class CreditsActivity extends AppCompatActivity {
    /**
     *
     * @param savedInstanceState - references the Bundle object passed into the onCreate method.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }
}
