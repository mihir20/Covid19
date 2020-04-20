package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mStatsBtn, mHotspotBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiViews();
        mStatsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent res_intent = new Intent(getApplicationContext(),ResourcesActivity.class);
                startActivity(res_intent);
            }
        });
        mHotspotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hotspot_intent = new Intent(getApplicationContext(),HotspotActivity.class);
                startActivity(hotspot_intent);
            }
        });
    }

    private void intiViews() {
        mStatsBtn = findViewById(R.id.stats_btn);
        mHotspotBtn = findViewById(R.id.hotspot_btn);
    }
}
