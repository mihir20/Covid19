package com.example.covid19.Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resource {

    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("contact")
    @Expose
    private String contact;
    @SerializedName("descriptionandorserviceprovided")
    @Expose
    private String descriptionandorserviceprovided;
    @SerializedName("nameoftheorganisation")
    @Expose
    private String nameoftheorganisation;
    @SerializedName("phonenumber")
    @Expose
    private String phonenumber;
    @SerializedName("state")
    @Expose
    private String state;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescriptionandorserviceprovided() {
        return descriptionandorserviceprovided;
    }

    public void setDescriptionandorserviceprovided(String descriptionandorserviceprovided) {
        this.descriptionandorserviceprovided = descriptionandorserviceprovided;
    }

    public String getNameoftheorganisation() {
        return nameoftheorganisation;
    }

    public void setNameoftheorganisation(String nameoftheorganisation) {
        this.nameoftheorganisation = nameoftheorganisation;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}