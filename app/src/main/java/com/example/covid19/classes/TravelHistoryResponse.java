package com.example.covid19.classes;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TravelHistoryResponse {

    @SerializedName("travel_history")
    @Expose
    private List<TravelHistory> travelHistory = null;

    public List<TravelHistory> getTravelHistory() {
        return travelHistory;
    }

    public void setTravelHistory(List<TravelHistory> travelHistory) {
        this.travelHistory = travelHistory;
    }

}