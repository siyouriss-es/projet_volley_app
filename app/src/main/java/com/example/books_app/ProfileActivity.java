package com.example.books_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class ProfileActivity extends AppCompatActivity {
    // -------------- For Drawer Menu : ------------------------
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    //---------------- Clicking Drawer Menu : -------------------------
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //-------------------- Drawer Menu Code : ------------------------------------
        drawer=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigationView);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_search:
                        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                        break;
                    case R.id.nav_profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        break;
                    case R.id.nav_settings:
                        startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                        break;
                    case R.id.nav_users:
                        startActivity(new Intent(getApplicationContext(), UsersActivity.class));
                        break;
                    case R.id.nav_share:
                        startActivity(new Intent(getApplicationContext(), ShareActivity.class));
                        break;
                    case R.id.nav_repair:
                        startActivity(new Intent(getApplicationContext(), DonateActivity.class));
                        break;
                    case R.id.nav_logout:
                        startActivity(new Intent(getApplicationContext(), LogoutActivity.class));
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "Something went wrong !", Toast.LENGTH_SHORT).show();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });
        //------------------------- End Drawer Menu ------------------------------------

    }
}