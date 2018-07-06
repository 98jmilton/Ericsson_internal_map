package com.example.ezmilja.ericsson_internal_map;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class GroundFloorFunctions extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private PopupMenu popupMenu;
    ImageButton img;



    //open/close navigation drawer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ground_floor_functions);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        SubsamplingScaleImageView imageView = (SubsamplingScaleImageView)findViewById(R.id.imageView);
        imageView.setImage(ImageSource.resource(R.drawable.map));

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //item functions within navigation drawer
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // opens the qr scanner
            Intent intent = new Intent(GroundFloorFunctions.this, ScanActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_coffee) {

        } else if (id == R.id.nav_toilets) {

        } else if (id == R.id.nav_printer) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //popup menu
    public void onClick(View anchor) {
        // TODO Auto-generated method stub

        // Image switching when arrow is clicked
        img= findViewById(R.id.imageButton);
        img.setImageResource(R.drawable.ic_baselinearrow_drop_down24px);

        popupMenu = new PopupMenu(GroundFloorFunctions.this, anchor, Gravity.CENTER);
        popupMenu.setOnDismissListener(new OnDismissListener());
        popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener());
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();

    }

    private class OnDismissListener implements PopupMenu.OnDismissListener {

        @Override
        public void onDismiss(PopupMenu menu) {
            // TODO Auto-generated method stub
            img.setImageResource(R.drawable.ic_baselinearrow_drop_up24px);
        }
    }

    private class OnMenuItemClickListener implements
            PopupMenu.OnMenuItemClickListener
    {

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            // TODO Auto-generated method stub
            switch (item.getItemId()) {
                case R.id.lang_java:
                    Toast.makeText(getApplicationContext(), "Java got clicked", Toast.LENGTH_SHORT).show();
                    img.setImageResource(R.drawable.ic_baselinearrow_drop_up24px);
                    return true;
                case R.id.lang_android:
                    Toast.makeText(getApplicationContext(), "Android got clicked",Toast.LENGTH_SHORT).show();
                    img.setImageResource(R.drawable.ic_baselinearrow_drop_up24px);
                    return true;
                case R.id.lang_python:
                    Toast.makeText(getApplicationContext(), "Python got clicked", Toast.LENGTH_SHORT).show();
                    img.setImageResource(R.drawable.ic_baselinearrow_drop_up24px);
                    return true;
                case R.id.lang_ruby:
                    Toast.makeText(getApplicationContext(), "Garfield got clicked", Toast.LENGTH_SHORT).show();
                    img.setImageResource(R.drawable.ic_baselinearrow_drop_up24px);
                    return true;
            }
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
