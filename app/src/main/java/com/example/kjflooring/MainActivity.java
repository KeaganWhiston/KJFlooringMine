package com.example.kjflooring;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.kjflooring.Settings.SettingsActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

/**
 * @author jordanflorence
 * MainActivity holds the bundle where the AppBarConfig holds the different navigation options.
 * Also holds the menu.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * @param savedInstanceState - references the Bundle object passed into the onCreate method.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_calculator, R.id.nav_products, R.id.nav_contact)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    /**
     *
     * @param menu - menu object
     * @return - returns a boolean to see if the menu has been launched, if it has, inflate.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    /**
     *
     * @param item - item inside of menu. (Settings or Credits)
     * @return - returns a boolean value dependent upon which menu item has been selected, action or action2.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action:
                Intent i = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(i);
                return true;
            case R.id.action2:
                Intent c = new Intent(MainActivity.this, CreditsActivity.class);
                startActivity(c);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
