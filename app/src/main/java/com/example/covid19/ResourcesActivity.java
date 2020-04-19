package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.covid19.adapters.ResourcesAdapter;
import com.example.covid19.classes.Resource;
import com.example.covid19.classes.ResourceResponse;
import com.example.covid19.rest.ApiClient;
import com.example.covid19.rest.ApiInterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResourcesActivity extends AppCompatActivity {
    RecyclerView resRV;
    ArrayList<Resource> resources,currList;
    Spinner stateSpnr, catagorySpnr;
    ArrayList<String>states,categories;
    private ResourcesAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);
        resources=new ArrayList<>();
        intiViews();
        stateSpnr.setVisibility(View.INVISIBLE);
        catagorySpnr.setVisibility(View.INVISIBLE);
        createList();
        catagorySpnr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currList.clear();
                if (position==0&&stateSpnr.getSelectedItemPosition()==0){
                    currList.addAll(resources);
                }else{
                    for(int i=0;i<resources.size();i++) {
                        if ((resources.get(i).getCategory().equals(categories.get(position))||position==0) &&
                                (resources.get(i).getState().equals(states.get(stateSpnr.getSelectedItemPosition()))||
                                        stateSpnr.getSelectedItemPosition()==0)) {
                            currList.add(resources.get(i));
                        }
                    }
                }

                if(currList.isEmpty()){
                    currList.add(new Resource("No Resource available","","",
                            "","","",""));
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        stateSpnr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currList.clear();
                if (position==0&&catagorySpnr.getSelectedItemPosition()==0){
                    currList.addAll(resources);
                    mAdapter.notifyDataSetChanged();
                }else{
                    for(int i=0;i<resources.size();i++) {
                        if ((resources.get(i).getState().equals(states.get(position))||position==0) &&
                                (resources.get(i).getCategory().equals(categories.get(catagorySpnr.getSelectedItemPosition()))||
                                        catagorySpnr.getSelectedItemPosition()==0)) {
                            currList.add(resources.get(i));
                        }
                    }
                }
                if(currList.isEmpty()){
                    currList.add(new Resource("No Resource available","","",
                            "","","",""));
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"noting selected",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createList() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ResourceResponse> call = apiService.getResources();
        call.enqueue(new Callback<ResourceResponse>() {
            @Override
            public void onResponse(Call<ResourceResponse> call, Response<ResourceResponse> response) {
                assert response.body() != null;
                resources= (ArrayList<Resource>) response.body().getResources();
                currList=new ArrayList<>();
                currList.addAll(resources);
                mAdapter = new ResourcesAdapter(currList);
                resRV.setAdapter(mAdapter);
                resRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                setSpinners();
            }

            @Override
            public void onFailure(Call<ResourceResponse> call, Throwable t) {
                Log.e("REST",t.toString());
            }
        });
    }

    private void setSpinners() {
        setStateFilter();
        setCategoryFilter();
    }

    private void setStateFilter() {
        Set<String> statesSet;
        statesSet=new HashSet<String>();
        states=new ArrayList<String>();
        for(int i=0;i<resources.size();i++){
            statesSet.add(resources.get(i).getState());
        }
        states.add("All");
        states.addAll(statesSet);
        ArrayAdapter adapter1=new ArrayAdapter(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,states);
        stateSpnr.setAdapter(adapter1);
        stateSpnr.setVisibility(View.VISIBLE);
        stateSpnr.setSelection(0);
    }

    private void setCategoryFilter() {
        Set<String> categorySet;
        categorySet=new HashSet<String>();
        categories=new ArrayList<String>();
        for(int i=0;i<resources.size();i++){
            categorySet.add(resources.get(i).getCategory());
        }
        categories.add("All");
        categories.addAll(categorySet);
        ArrayAdapter adapter1=new ArrayAdapter(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,categories);
        catagorySpnr.setAdapter(adapter1);
        catagorySpnr.setVisibility(View.VISIBLE);
        catagorySpnr.setSelection(0);
    }

    private void intiViews() {
        resRV=findViewById(R.id.resoures_rv);
        stateSpnr=findViewById(R.id.state_spnr);
        catagorySpnr=findViewById(R.id.catagory_spnr);
    }
}
