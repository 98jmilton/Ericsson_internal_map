package com.example.ezmilja.ericsson_internal_map;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.otaliastudios.zoom.ZoomImageView;
import com.otaliastudios.zoom.ZoomLogger;

public class MainMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ZoomLogger.setLogLevel(ZoomLogger.LEVEL_INFO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //final ZoomImageView zoomImage = findViewById(R.id.zoom_layout);
        //zoomImage.setVisibility(View.VISIBLE);
        int resource_id = getResources().getIdentifier("ecm", "drawable", getPackageName());
        //zoomImage.setImageResource(resource_id);


    }
}

