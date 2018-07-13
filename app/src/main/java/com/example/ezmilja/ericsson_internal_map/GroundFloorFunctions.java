package com.example.ezmilja.ericsson_internal_map;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
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

public class GroundFloorFunctions extends AppCompatActivity {

    public int visiblered = 0;
    public int visibleyellow= 0;
    public int visibleblue= 0;
    public int visiblegreen= 0;
    public int visibleorange = 0;
    public int visiblepurple= 0;
    public int visibleteal= 0;
    public int visiblepink= 0;
    public int visiblecyan= 0;

    public int viscdock1 = 0;
    public int viscdock2 = 0;
    public int viscdock3 = 0;
    public int viscdock4 = 0;
    public int viscdock5 = 0;
    public int viscdock6 = 0;
    public int viscdock7 = 0;

    public int vistoilet1 = 0;
    public int vistoilet2 = 0;
    public int vistoilet3 = 0;
    public int vistoilet4 = 0;
    public int vistoilet5 = 0;
    public int vistoilet6 = 0;
    public int vistoilet7 = 0;

    public int visprint1 = 0;
    public int visprint2 = 0;
    public int visprint3 = 0;
    public int visprint4 = 0;
    public int visprint5 = 0;
    public int visprint6 = 0;
    public int visprint7 = 0;


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

    ImageButton cdock1;
    ImageButton cdock2;
    ImageButton cdock3;
    ImageButton cdock4;
    ImageButton cdock5;
    ImageButton cdock6;
    ImageButton cdock7;

    ImageButton toilet1;
    ImageButton toilet2;
    ImageButton toilet3;
    ImageButton toilet4;
    ImageButton toilet5;
    ImageButton toilet6;
    ImageButton toilet7;

    ImageButton print1;
    ImageButton print2;
    ImageButton print3;
    ImageButton print4;
    ImageButton print5;
    ImageButton print6;
    ImageButton print7;


    ImageButton TBCamera;
    ImageButton TBCoffee;
    ImageButton TBToilets;
    ImageButton TBPrinters;
    ImageButton TBClearAll;



    public TextView QRmessage;

    private final static String ERROR_MESSAGE = "Unable to scan bar code";

    //open/close navigation drawer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_ground_floor_functions);



        //navigation drawer toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        greenPin    =(ImageButton) findViewById(R.id.pin_green);
        redPin      =(ImageButton) findViewById(R.id.pin_red);
        yellowPin   =(ImageButton) findViewById(R.id.pin_yellow);
        bluePin     =(ImageButton) findViewById(R.id.pin_blue);
        orangePin   =(ImageButton) findViewById(R.id.pin_orange);
        purplePin   =(ImageButton) findViewById(R.id.pin_purple);
        pinkPin     =(ImageButton) findViewById(R.id.pin_pink);
        cyanPin     =(ImageButton) findViewById(R.id.pin_cyan);
        tealPin     =(ImageButton) findViewById(R.id.pin_teal);

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

        cdock1      =(ImageButton) findViewById(R.id.cdock1);
        cdock2      =(ImageButton) findViewById(R.id.cdock2);
        cdock3      =(ImageButton) findViewById(R.id.cdock3);
        cdock4      =(ImageButton) findViewById(R.id.cdock4);
        cdock5      =(ImageButton) findViewById(R.id.cdock5);
        cdock6      =(ImageButton) findViewById(R.id.cdock6);
        cdock7      =(ImageButton) findViewById(R.id.cdock7);

        //Coffee dock 1
        cdock1.setVisibility(View.INVISIBLE);
        cdock1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cdock1.setVisibility(View.INVISIBLE);
                viscdock1 = 0;
            }
        });
        //Coffee dock 2
        cdock2.setVisibility(View.INVISIBLE);
        cdock2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cdock2.setVisibility(View.INVISIBLE);
                viscdock2 = 0;
            }
        });
        //Coffee dock 3
        cdock3.setVisibility(View.INVISIBLE);
        cdock3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cdock3.setVisibility(View.INVISIBLE);
                viscdock3 = 0;
            }
        });
        //Coffee dock 4
        cdock4.setVisibility(View.INVISIBLE);
        cdock4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cdock4.setVisibility(View.INVISIBLE);
                viscdock4 = 0;
            }
        });
        //Coffee dock 5
        cdock5.setVisibility(View.INVISIBLE);
        cdock5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cdock5.setVisibility(View.INVISIBLE);
                viscdock5 = 0;
            }
        });
        //Coffee dock 6
        cdock6.setVisibility(View.INVISIBLE);
        cdock6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cdock6.setVisibility(View.INVISIBLE);
                viscdock6 = 0;
            }
        });

        //Coffee dock 7
        cdock7.setVisibility(View.INVISIBLE);
        cdock7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cdock7.setVisibility(View.INVISIBLE);
                viscdock7 = 0;
            }
        });

        toilet1      =(ImageButton) findViewById(R.id.toilet1);
        toilet2      =(ImageButton) findViewById(R.id.toilet2);
        toilet3      =(ImageButton) findViewById(R.id.toilet3);
        toilet4      =(ImageButton) findViewById(R.id.toilet4);
        toilet5      =(ImageButton) findViewById(R.id.toilet5);
        toilet6      =(ImageButton) findViewById(R.id.toilet6);
        toilet7      =(ImageButton) findViewById(R.id.toilet7);

        //Toilet 1
        toilet1.setVisibility(View.INVISIBLE);
        toilet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toilet1.setVisibility(View.INVISIBLE);
                vistoilet1 = 0;
            }
        });
        //Toilet 2
        toilet2.setVisibility(View.INVISIBLE);
        toilet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toilet2.setVisibility(View.INVISIBLE);
                vistoilet2 = 0;
            }
        });
        //Toilet 3
        toilet3.setVisibility(View.INVISIBLE);
        toilet3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toilet3.setVisibility(View.INVISIBLE);
                vistoilet3 = 0;
            }
        });
        //Toilet 4
        toilet4.setVisibility(View.INVISIBLE);
        toilet4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toilet4.setVisibility(View.INVISIBLE);
                vistoilet4 = 0;
            }
        });
        //Toilet 5
        toilet5.setVisibility(View.INVISIBLE);
        toilet5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toilet5.setVisibility(View.INVISIBLE);
                vistoilet5 = 0;
            }
        });
        //Toilet 6
        toilet6.setVisibility(View.INVISIBLE);
        toilet6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toilet6.setVisibility(View.INVISIBLE);
                vistoilet6 = 0;
            }
        });

        //Toilet 7
        toilet7.setVisibility(View.INVISIBLE);
        toilet7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toilet7.setVisibility(View.INVISIBLE);
                vistoilet7 = 0;
            }
        });


        print1      =(ImageButton) findViewById(R.id.print1);
        print2      =(ImageButton) findViewById(R.id.print2);
        print3      =(ImageButton) findViewById(R.id.print3);
        print4      =(ImageButton) findViewById(R.id.print4);
        print5      =(ImageButton) findViewById(R.id.print5);
        print6      =(ImageButton) findViewById(R.id.print6);
        print7      =(ImageButton) findViewById(R.id.print7);

        //Toilet 1
        print1.setVisibility(View.INVISIBLE);
        print1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print1.setVisibility(View.INVISIBLE);
                visprint1 = 0;
            }
        });
        //Toilet 2
        print2.setVisibility(View.INVISIBLE);
        print2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print2.setVisibility(View.INVISIBLE);
                visprint2 = 0;
            }
        });
        //Toilet 3
        print3.setVisibility(View.INVISIBLE);
        print3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print3.setVisibility(View.INVISIBLE);
                visprint3 = 0;
            }
        });
        //Toilet 4
        print4.setVisibility(View.INVISIBLE);
        print4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print4.setVisibility(View.INVISIBLE);
                visprint4 = 0;
            }
        });
        //Toilet 5
        print5.setVisibility(View.INVISIBLE);
        print5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print5.setVisibility(View.INVISIBLE);
                visprint5 = 0;
            }
        });
        //Toilet 6
        print6.setVisibility(View.INVISIBLE);
        print6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print6.setVisibility(View.INVISIBLE);
                visprint6 = 0;
            }
        });

        //Toilet 7
        print7.setVisibility(View.INVISIBLE);
        print7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print7.setVisibility(View.INVISIBLE);
                visprint7 = 0;
            }
        });
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

    /*
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

            viscoffee();

        } else if (id == R.id.nav_toilets) {

            vistoilet();

        } else if (id == R.id.nav_printer) {

            visprint();

        } else if (id ==R.id.nav_clear) {

            clearALL();

        }
        return true;
    }

    */

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
        if (searchmenuopen == true) {
            searchlistitems.setVisibility(View.INVISIBLE);
            searchmenuopen = false;
        }
         else {
            super.onBackPressed();
        }
    }

    public void roomSwitch(){

        if ( roomName.equals("Athlone")){
            roomName = "athlone";
            height = 465;
            width = 677;

            isfree();
        }

        else if ( roomName.equals("Anchorage")){
            roomName = "anchorage";
            height = 50;
            width = 50;

            isfree();
        }

        else if ( roomName.equals( "Berlin")){

            roomName = "berlin";
            height = 500;
            width = 1107;
            isfree() ;
        }

        else if ( roomName.equals( "Brasilia")){

            roomName = "brasilia";
            height = 150;
            width = 150;
            isfree() ;
        }

        else if ( roomName.equals( "Buenos Aires")){

            roomName = "buenosaires";
            height = 200;
            width = 200;
            isfree() ;
        }

        else if ( roomName.equals( "Canberra")){

            roomName = "canberra";
            height = 250;
            width = 250;
            isfree() ;
        }

        else if ( roomName.equals( "Cape Town")){

            roomName = "capetown";
            height = 300;
            width = 300;
            isfree() ;
        }

        else if ( roomName.equals( "Demo Room")){

            roomName = "demoroom";
            height = 350;
            width = 350;
            isfree() ;
        }

        else if ( roomName.equals( "Helsinki")){

            roomName = "helsinki";
            height = 300;
            width = 1534;
            isfree() ;
        }

        else if ( roomName.equals( "Honolulu")){

            roomName = "honolulu";
            height = 450;
            width = 450;
            isfree() ;
        }

        else if ( roomName.equals( "Jakarta")){

            roomName = "jakarta";
            height = 500;
            width = 500;
            isfree() ;
        }

        else if ( roomName.equals( "Kiev")){

            roomName = "kiev";
            height = 500;
            width = 1844;
            isfree() ;
        }

        else if ( roomName.equals( "Kuala Lumpur")){

            roomName = "kualalumpur";
            height = 600;
            width = 600;

            isfree() ;
        }

        else if ( roomName.equals( "Larsmagnus")){

            roomName = "larsmagnus";
            height = 6500;
            width = 0;
            isfree() ;
        }

        else if ( roomName.equals( "Moscow")){

            roomName = "moscow";
            height = 300;
            width = 1844;
            isfree() ;
        }

        else if ( roomName.equals( "Nuuk")){

            roomName = "nuuk";
            height = 374;
            width = 279;
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
            height = 739;
            width = 685;
            isfree() ;
        }

        else if ( roomName.equals( "Reykjavik")){

            roomName = "reykjavik";
            height = 850;
            width = 279;
            isfree() ;
        }

        else if ( roomName.equals( "Rome")){

            roomName = "rome";
            height = 500;
            width = 1534;
            isfree() ;
        }

        else if ( roomName.equals( "Stockholm")){

            roomName = "stockholm";
            height = 300;
            width = 1107;
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

        else if ( roomName.equals( "Washington DC")){

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

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(greenWidth, greenHeigth, 0, 0);
            greenPin.setLayoutParams(params);

            greenPin.setVisibility(View.VISIBLE);

            visiblegreen = 1;
        }
        else if(visibleblue == 0){
            int blueHeigth = height;
            int blueWidth  = width;
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(blueWidth, blueHeigth, 0, 0);
            bluePin.setLayoutParams(params);

            bluePin.setVisibility(View.VISIBLE);

            visibleblue = 1;
        }
        else if(visiblered == 0){
            int redHeigth = height;
            int redWidth  = width;

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(redWidth, redHeigth, 0, 0);
            redPin.setLayoutParams(params);

            redPin.setVisibility(View.VISIBLE);

            visiblered = 1;
        }
        else if(visibleyellow == 0){
            int yellowHeigth = height;
            int yellowWidth  = width;

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(yellowWidth, yellowHeigth, 0, 0);
            yellowPin.setLayoutParams(params);

            yellowPin.setVisibility(View.VISIBLE);

            visibleyellow = 1;
        }
        else if(visiblecyan == 0){
            int cyanHeigth = height;
            int cyanWidth  = width;

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(cyanWidth, cyanHeigth, 0, 0);
            cyanPin.setLayoutParams(params);

            cyanPin.setVisibility(View.VISIBLE);
            visiblecyan = 1;
        }
        else if(visibleorange == 0){
            int orangeHeigth = height;
            int orangeWidth  = width;

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(orangeWidth,orangeHeigth, 0, 0);
            orangePin.setLayoutParams(params);

            orangePin.setVisibility(View.VISIBLE);
            visibleorange = 1;
        }
        else if(visiblepink == 0){
            int pinkHeigth = height;
            int pinkWidth  = width;

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(pinkWidth, pinkHeigth, 0, 0);
            pinkPin.setLayoutParams(params);

            pinkPin.setVisibility(View.VISIBLE);
            visiblepink = 1;
        }
        else if(visibleteal == 0){
            int tealHeigth = height;
            int tealWidth  = width;
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(tealWidth, tealHeigth, 0, 0);
            tealPin.setLayoutParams(params);

            tealPin.setVisibility(View.VISIBLE);

            visibleteal = 1;
        }
        else if(visiblepurple == 0){
            int purpleHeigth = height;
            int purpleWidth  = width;
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(purpleWidth, purpleHeigth, 0, 0);
            purplePin.setLayoutParams(params);

            purplePin.setVisibility(View.VISIBLE);

            visiblepurple = 1;
        }
        else{

            visiblered = 0;
            visibleyellow = 0;
            visibleblue = 0;
            visiblegreen = 0;
            visibleorange = 0;
            visiblepurple = 0;
            visibleteal = 0;
            visiblepink = 0;
            visiblecyan = 0;
            isfree();
        }

    }

   public void viscoffee(){
       viscdock1 = 1;
       viscdock2 = 1;
       viscdock3 = 1;
       viscdock4 = 1;
       viscdock5 = 1;
       viscdock6 = 1;
       viscdock7 = 1;
       cdock1.setVisibility(View.VISIBLE);
       cdock2.setVisibility(View.VISIBLE);
       cdock3.setVisibility(View.VISIBLE);
       cdock4.setVisibility(View.VISIBLE);
       cdock5.setVisibility(View.VISIBLE);
       cdock6.setVisibility(View.VISIBLE);
       cdock7.setVisibility(View.VISIBLE);

   }

   public void vistoilet(){
       vistoilet1 = 1;
       vistoilet2 = 1;
       vistoilet3 = 1;
       vistoilet4 = 1;
       vistoilet5 = 1;
       vistoilet6 = 1;
       vistoilet7 = 1;
       toilet1.setVisibility(View.VISIBLE);
       toilet2.setVisibility(View.VISIBLE);
       toilet3.setVisibility(View.VISIBLE);
       toilet4.setVisibility(View.VISIBLE);
       toilet5.setVisibility(View.VISIBLE);
       toilet6.setVisibility(View.VISIBLE);
       toilet7.setVisibility(View.VISIBLE);

   }

    public void visprint(){
        visprint1 = 1;
        visprint2 = 1;
        visprint3 = 1;
        visprint4 = 1;
        visprint5 = 1;
        visprint6 = 1;
        visprint7 = 1;
        print1.setVisibility(View.VISIBLE);
        print2.setVisibility(View.VISIBLE);
        print3.setVisibility(View.VISIBLE);
        print4.setVisibility(View.VISIBLE);
        print5.setVisibility(View.VISIBLE);
        print6.setVisibility(View.VISIBLE);
        print7.setVisibility(View.VISIBLE);

    }

   public void clearALL(){
       visiblered = 0;
       visibleyellow = 0;
       visibleblue = 0;
       visiblegreen = 0;
       visibleorange = 0;
       visiblepurple = 0;
       visibleteal = 0;
       visiblepink = 0;
       visiblecyan = 0;
       redPin.setVisibility(View.INVISIBLE);
       greenPin.setVisibility(View.INVISIBLE);
       yellowPin.setVisibility(View.INVISIBLE);
       bluePin.setVisibility(View.INVISIBLE);
       orangePin.setVisibility(View.INVISIBLE);
       purplePin.setVisibility(View.INVISIBLE);
       tealPin.setVisibility(View.INVISIBLE);
       cyanPin.setVisibility(View.INVISIBLE);
       pinkPin.setVisibility(View.INVISIBLE);

       viscdock1 = 0;
       viscdock2 = 0;
       viscdock3 = 0;
       viscdock4 = 0;
       viscdock5 = 0;
       viscdock6 = 0;
       viscdock7 = 0;
       cdock1.setVisibility(View.INVISIBLE);
       cdock2.setVisibility(View.INVISIBLE);
       cdock3.setVisibility(View.INVISIBLE);
       cdock4.setVisibility(View.INVISIBLE);
       cdock5.setVisibility(View.INVISIBLE);
       cdock6.setVisibility(View.INVISIBLE);
       cdock7.setVisibility(View.INVISIBLE);

       vistoilet1 = 0;
       vistoilet2 = 0;
       vistoilet3 = 0;
       vistoilet4 = 0;
       vistoilet5 = 0;
       vistoilet6 = 0;
       vistoilet7 = 0;
       toilet1.setVisibility(View.INVISIBLE);
       toilet2.setVisibility(View.INVISIBLE);
       toilet3.setVisibility(View.INVISIBLE);
       toilet4.setVisibility(View.INVISIBLE);
       toilet5.setVisibility(View.INVISIBLE);
       toilet6.setVisibility(View.INVISIBLE);
       toilet7.setVisibility(View.INVISIBLE);

       visprint1 = 0;
       visprint2 = 0;
       visprint3 = 0;
       visprint4 = 0;
       visprint5 = 0;
       visprint6 = 0;
       visprint7 = 0;
       print1.setVisibility(View.INVISIBLE);
       print2.setVisibility(View.INVISIBLE);
       print3.setVisibility(View.INVISIBLE);
       print4.setVisibility(View.INVISIBLE);
       print5.setVisibility(View.INVISIBLE);
       print6.setVisibility(View.INVISIBLE);
       print7.setVisibility(View.INVISIBLE);
   }

    private String getValue(final Intent intent) {
        try {
            final String barCodeString = intent.getExtras().getString(Constants.SCAN_BAR_TEST_KEY);

            return barCodeString != null ? barCodeString : ERROR_MESSAGE;

        } catch (final Exception e) {
            e.printStackTrace();
        }
        return ERROR_MESSAGE;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.nav_camera:
                Intent intent = new Intent(GroundFloorFunctions.this, ScanActivity.class);
                startActivity(intent);
                return true;
            case R.id.nav_coffee:
          viscoffee();
                return true;
            case R.id.nav_toilets:
vistoilet();
                return true;
            case R.id.nav_printer:
visprint();
                return true;
            case R.id.nav_clear:
clearALL();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
