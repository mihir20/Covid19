package com.example.covid19.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResourceResponse {
    @SerializedName("resources")
    @Expose
    private List<Resource> resources = null;

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
