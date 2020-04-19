package com.example.covid19.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid19.classes.Resource;
import com.example.covid19.R;

import java.util.List;

public class ResourcesAdapter extends RecyclerView.Adapter<ResourcesAdapter.ViewHolder> {
    
    private List<Resource> mResources;

    public ResourcesAdapter(List<Resource> resources) {
        this.mResources = resources;
    }

    @NonNull
    @Override
    public ResourcesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context =parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View resView = inflater.inflate(R.layout.item_resource,parent,false);
        return new ViewHolder(resView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResourcesAdapter.ViewHolder holder, int position) {
        Resource res = mResources.get(position);
        holder.phoneTV.setText(res.getPhonenumber());
        holder.catagoryTV.setText(res.getCategory());
        holder.contactTV.setText(res.getContact());
        holder.desTV.setText(res.getDescriptionandorserviceprovided());
        holder.nameTV.setText(res.getNameoftheorganisation());
        holder.cityTV.setText(res.getCity().concat(",").concat(res.getState()));
    }

    @Override
    public int getItemCount() {
        return mResources.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTV, catagoryTV, cityTV, desTV, contactTV, phoneTV;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            
            nameTV=itemView.findViewById(R.id.res_itm_name);
            catagoryTV=itemView.findViewById(R.id.res_itm_category);
            cityTV=itemView.findViewById(R.id.res_itm_city);
            desTV=itemView.findViewById(R.id.res_itm_des);
            contactTV=itemView.findViewById(R.id.res_itm_contact);
            phoneTV=itemView.findViewById(R.id.res_itm_phone);
        }
    }
}
