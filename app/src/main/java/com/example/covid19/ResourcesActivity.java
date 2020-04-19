package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.covid19.Adapters.ResourcesAdapter;
import com.example.covid19.Classes.Resource;

import java.util.ArrayList;

public class ResourcesActivity extends AppCompatActivity {
    RecyclerView resRV;
    ArrayList<Resource> resources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);
        resources=new ArrayList<>();
        intiViews();
        createDemoList();
        ResourcesAdapter adapter = new ResourcesAdapter(resources);
        resRV.setAdapter(adapter);
        resRV.setLayoutManager(new LinearLayoutManager(this));
    }

    private void createDemoList() {
        for(int i=0;i<20;i++){
            resources.add(new Resource("test lab","jaipur",
                    "jamenv, jkd","this is best","SMS",
                    "946792368","Rajasthan"));
        }
    }

    private void intiViews() {
        resRV=findViewById(R.id.resoures_rv);
    }
}
