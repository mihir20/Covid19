package com.example.covid19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.covid19.utils.PermissionsUtil;

public class MainActivity extends AppCompatActivity {
    private Button mStatsBtn, mHotspotBtn;
    private boolean mAskedByHotspot = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiViews();
        PermissionsUtil.requestLocation(this);
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
                mAskedByHotspot=true;
                if(PermissionsUtil.requestLocation(MainActivity.this)){
                    Intent i = new Intent(getApplicationContext(),HotspotActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    private void intiViews() {
        mStatsBtn = findViewById(R.id.stats_btn);
        mHotspotBtn = findViewById(R.id.hotspot_btn);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==PermissionsUtil.REQUEST_LOCATION&&mAskedByHotspot){
            Intent i = new Intent(getApplicationContext(),HotspotActivity.class);
            startActivity(i);
        }
    }
}
