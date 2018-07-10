package com.example.ezmilja.ericsson_internal_map;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import com.otaliastudios.zoom.ZoomLayout;
import com.otaliastudios.zoom.ZoomLogger;

import static android.widget.Toast.LENGTH_LONG;

public class GroundFloorFunctions extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public int visiblered = 0;
    public int visibleyellow= 0;
    public int visibleblue= 0;
    public int visiblegreen= 0;
    public int visibleorange = 0;
    public int visiblepurple= 0;
    public int visibleteal= 0;
    public int visiblepink= 0;
    public int visiblecyan= 0;

    public String roomName = "";
    public int height=0;
    public int width=0;

    private PopupMenu popupMenu;
    ImageButton img;
    ListView searchlistitems;
    ArrayAdapter<String> adapter;
public boolean searchmenuopen=false;

    ImageButton greenPin;
    ImageButton redPin;
    ImageButton yellowPin;
    ImageButton bluePin;
    ImageButton orangePin;
    ImageButton purplePin;
    ImageButton pinkPin;
    ImageButton cyanPin;
    ImageButton tealPin;


    //open/close navigation drawer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ground_floor_functions);


        visiblered = 0;
        visibleyellow = 0;
        visibleblue = 0;
        visiblegreen = 0;
        visibleorange = 0;
        visiblepurple = 0;
        visibleteal = 0;
        visiblepink = 0;
        visiblecyan = 0;

        //navigation drawer toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        greenPin    =(ImageButton) findViewById(R.id.pin_green);
        /*redPin      =(ImageButton) findViewById(R.id.pin_red);
        yellowPin   =(ImageButton) findViewById(R.id.pin_yellow);
        bluePin     =(ImageButton) findViewById(R.id.pin_blue);
        orangePin   =(ImageButton) findViewById(R.id.pin_orange);
        purplePin   =(ImageButton) findViewById(R.id.pin_purple);
        pinkPin     =(ImageButton) findViewById(R.id.pin_pink);
        cyanPin     =(ImageButton) findViewById(R.id.pin_cyan);
        tealPin     =(ImageButton) findViewById(R.id.pin_teal);*/

        //GREENPIN
        greenPin.setVisibility(View.INVISIBLE);
        greenPin.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
            greenPin.setVisibility(View.INVISIBLE);
            visiblegreen = 0;
        }
        });

        //REDPIN
        redPin.setVisibility(View.INVISIBLE);
        redPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redPin.setVisibility(View.INVISIBLE);
                visiblered = 0;
            }
        });

        //YELLOWPIN
        yellowPin.setVisibility(View.INVISIBLE);
        yellowPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yellowPin.setVisibility(View.INVISIBLE);
                visibleyellow = 0;
            }
        });

        //BLUEPIN
        bluePin.setVisibility(View.INVISIBLE);
        bluePin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bluePin.setVisibility(View.INVISIBLE);
                visibleblue = 0;
            }
        });

        //ORANGEPIN
        orangePin.setVisibility(View.INVISIBLE);
        orangePin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orangePin.setVisibility(View.INVISIBLE);
                visibleorange = 0;
            }
        });

        //PURPLEPIN
        purplePin.setVisibility(View.INVISIBLE);
        purplePin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purplePin.setVisibility(View.INVISIBLE);
                visiblepurple = 0;
            }
        });

        //PINKPIN
        pinkPin.setVisibility(View.INVISIBLE);
        pinkPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pinkPin.setVisibility(View.INVISIBLE);
                visiblepink = 0;
            }
        });

        //CYANPIN
        cyanPin.setVisibility(View.INVISIBLE);
        cyanPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cyanPin.setVisibility(View.INVISIBLE);
                visiblecyan = 0;
            }
        });

        //TEALPIN
        tealPin.setVisibility(View.INVISIBLE);
        tealPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tealPin.setVisibility(View.INVISIBLE);
                visibleteal = 0;
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    //Add List of rooms to search bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.searchmenu, menu);
        MenuItem item = menu.findItem(R.id.searchlist);
        final SearchView searchView = (SearchView)item.getActionView();

        //suggestion list for searching
        searchlistitems=(ListView) findViewById(R.id.searchlistitems);
        ArrayList<String> arraySearch=new ArrayList<>();
        arraySearch.addAll(Arrays.asList(getResources().getStringArray(R.array.rooms)));
        adapter = new ArrayAdapter<String>(GroundFloorFunctions.this, android.R.layout.simple_list_item_1,
                arraySearch
        );
        searchlistitems.setAdapter(adapter);

        // WHEN AN ITEM IS CLICKED ON THE LISTVIEW
        searchlistitems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView <? > arg0, View view, int position, long id) {
                // When clicked, show a toast with the TextView text
                searchlistitems.setVisibility(View.INVISIBLE);
                roomName= (String) ((TextView) view).getText();
                roomSwitch();
            }

        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            //using the enter key in search bar
            @Override
            public boolean onQueryTextSubmit(String s) {
                searchlistitems.setVisibility(View.INVISIBLE);
                searchmenuopen = false;
                return false;
            }

            //typing/deleting in search bar
            @Override
            public boolean onQueryTextChange(String s) {
                String addText = "";
                addText +=s;

                if (addText.length() > 0) {

                    adapter.getFilter().filter(s);
                    searchlistitems.setVisibility(View.VISIBLE);
                    searchmenuopen = true;
                    return false;
                }
                else {
                        searchlistitems.setVisibility(View.INVISIBLE);
                        searchmenuopen = false;
                }
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
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
        }
        else if (searchmenuopen == true) {
            searchlistitems.setVisibility(View.INVISIBLE);
            searchmenuopen = false;
        }
         else {
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

    void jeff(){

        Toast.makeText(this,roomName,LENGTH_LONG).show();

    }

    public void roomSwitch(){

        if ( roomName.equals("Anchorage")){
            roomName = "anchorage";
            height = 0;
            width = 0;

            isfree();
        }

        else if ( roomName.equals( "Berlin")){

            roomName = "berlin";
            height = 0;
            width = 0;
            isfree() ;
        }

        else if ( roomName.equals( "Brasilia")){

            roomName = "brasilia";
            height = 0;
            width = 0;
            isfree() ;
        }

        else if ( roomName.equals( "Buenosaires")){

            roomName = "buenosaires";
            height = 0;
            width = 0;
            isfree() ;
        }

        else if ( roomName.equals( "Canberra")){

            roomName = "canberra";
            height = 0;
            width = 0;
            isfree() ;
        }

        else if ( roomName.equals( "Capetown")){

            roomName = "capetown";
            height = 0;
            width = 0;
            isfree() ;
        }

        else if ( roomName.equals( "Demoroom")){

            roomName = "demoroom";
            height = 0;
            width = 0;
            isfree() ;
        }

        else if ( roomName.equals( "Helsinki")){

            roomName = "helsinki";
            height = 0;
            width = 0;
            isfree() ;
        }

        else if ( roomName.equals( "Honolulu")){

            roomName = "honolulu";
            height = 0;
            width = 0;
            isfree() ;
        }

        else if ( roomName.equals( "Jakarta")){

            roomName = "jakarta";
            height = 0;
            width = 0;
            isfree() ;
        }

        else if ( roomName.equals( "Kiev")){

            roomName = "kiev";
            height = 0;
            width = 0;
            isfree() ;
        }

        else if ( roomName.equals( "Kualalumpur")){

            roomName = "kualalumpur";
            height = 0;
            width = 0;

            isfree() ;
        }

        else if ( roomName.equals( "Larsmagnus")){

            roomName = "larsmagnus";
            height = 0;
            width = 0;
            isfree() ;
        }

        else if ( roomName.equals( "Moscow")){

            roomName = "moscow";
            height = 0;
            width = 0;
            isfree() ;
        }

        else if ( roomName.equals( "Nuuk")){

            roomName = "nuuk";
            height = 380;
            width = 185;
            isfree() ;
        }

        else if ( roomName.equals( "Ottowa")){

            roomName = "ottowa";
            height = 0;
            width = 0;
            isfree() ;
        }

        else if ( roomName.equals( "Paris")){

            roomName = "paris";
            height = 0;
            width = 0;
            isfree() ;
        }

        else if ( roomName.equals( "Reykjavik")){

            roomName = "reykjavik";
            height = 0;
            width = 0;
            isfree() ;
        }

        else if ( roomName.equals( "Rome")){

            roomName = "rome";
            height = 0;
            width = 0;
            isfree() ;
        }

        else if ( roomName.equals( "Stockholm")){

            roomName = "stockholm";
            height = 0;
            width = 0;
            isfree() ;
        }

        else if ( roomName.equals( "Tokyo")){

            roomName = "tokyo";
            height = 0;
            width = 0;
            isfree() ;
        }

        else if ( roomName.equals( "Warsaw")){

            roomName = "warsaw";
            height = 0;
            width = 0;
            isfree() ;
        }

        else if ( roomName.equals( "Washingtondc")){

            roomName = "washingtondc";
            height = 0;
            width = 0;
            isfree() ;
        }

        else if ( roomName.equals( "Wellington")){

            roomName = "wellington";
            height = 0;
            width = 0;
            isfree();
        }
        else{

            Toast.makeText(this,"Shit",LENGTH_LONG).show();
        }

    }


    public void isfree(){
        if(visiblegreen == 0){

            int greenHeigth = height;
            int greenWidth  = width;


            greenPin.setVisibility(View.VISIBLE);

            visiblegreen = 1;
        }
        else if(visibleblue == 0){
            int blueHeigth = height;
            int blueWidth  = width;


            visibleblue = 1;
        }
        else if(visiblered == 0){
            int redHeigth = height;
            int redWidth  = width;


            visiblered = 1;
        }
        else if(visibleyellow == 0){
            int yellowHeigth = height;
            int yellowWidth  = width;


            visibleyellow = 1;
        }
        else if(visiblecyan == 0){
            int cyanHeigth = height;
            int cyanWidth  = width;


            visiblecyan = 1;
        }
        else if(visibleorange == 0){
            int orangeHeigth = height;
            int orangeWidth  = width;


            visibleorange = 1;
        }
        else if(visiblepink == 0){
            int pinkHeigth = height;
            int pinkWidth  = width;


            visiblepink = 1;
        }
        else if(visibleteal == 0){
            int tealHeigth = height;
            int tealWidth  = width;


            visibleteal = 1;
        }
        else if(visiblepurple == 0){
            int purpleHeigth = height;
            int purpleWidth  = width;


            visiblepurple = 1;
        }
        else{}

    }

}
