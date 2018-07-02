package com.example.ezmilja.ericsson_internal_map;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button btn = (Button) findViewById(R.id.btnMap);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), GroundFloorFunctions.class);
                startActivityForResult(myIntent, 0);
            }

        });

        Button btn1 = (Button) findViewById(R.id.btnScan);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, ScanActivity.class);
                startActivity(intent);
            }
        });


        Button btn2 = (Button) findViewById(R.id.btnZones);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ZonesMenu.class);
                startActivityForResult(myIntent, 0);
            }

        });
    }
}

