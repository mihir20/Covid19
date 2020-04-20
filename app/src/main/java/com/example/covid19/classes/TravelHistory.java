package com.example.covid19.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TravelHistory {

    @SerializedName("_cn6ca")
    @Expose
    private String cn6ca;
    @SerializedName("accuracylocation")
    @Expose
    private String accuracylocation;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("datasource")
    @Expose
    private String datasource;
    @SerializedName("latlong")
    @Expose
    private String latlong;
    @SerializedName("modeoftravel")
    @Expose
    private String modeoftravel;
    @SerializedName("pid")
    @Expose
    private String pid;
    @SerializedName("placename")
    @Expose
    private String placename;
    @SerializedName("timefrom")
    @Expose
    private String timefrom;
    @SerializedName("timeto")
    @Expose
    private String timeto;
    @SerializedName("type")
    @Expose
    private String type;

    public String getCn6ca() {
        return cn6ca;
    }

    public void setCn6ca(String cn6ca) {
        this.cn6ca = cn6ca;
    }

    public String getAccuracylocation() {
        return accuracylocation;
    }

    public void setAccuracylocation(String accuracylocation) {
        this.accuracylocation = accuracylocation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDatasource() {
        return datasource;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }

    public String getLatlong() {
        return latlong;
    }

    public void setLatlong(String latlong) {
        this.latlong = latlong;
    }

    public String getModeoftravel() {
        return modeoftravel;
    }

    public void setModeoftravel(String modeoftravel) {
        this.modeoftravel = modeoftravel;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }

    public String getTimefrom() {
        return timefrom;
    }

    public void setTimefrom(String timefrom) {
        this.timefrom = timefrom;
    }

    public String getTimeto() {
        return timeto;
    }

    public void setTimeto(String timeto) {
        this.timeto = timeto;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}