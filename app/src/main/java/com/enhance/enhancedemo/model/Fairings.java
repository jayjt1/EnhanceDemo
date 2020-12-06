package com.enhance.enhancedemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Fairings {

    @SerializedName("reused")
    @Expose
    private Object reused;
    @SerializedName("recovery_attempt")
    @Expose
    private Object recoveryAttempt;
    @SerializedName("recovered")
    @Expose
    private Object recovered;
    @SerializedName("ships")
    @Expose
    private List<String> ships = null;

    public Object getReused() {
        return reused;
    }

    public void setReused(Object reused) {
        this.reused = reused;
    }

    public Object getRecoveryAttempt() {
        return recoveryAttempt;
    }

    public void setRecoveryAttempt(Object recoveryAttempt) {
        this.recoveryAttempt = recoveryAttempt;
    }

    public Object getRecovered() {
        return recovered;
    }

    public void setRecovered(Object recovered) {
        this.recovered = recovered;
    }

    public List<String> getShips() {
        return ships;
    }

    public void setShips(List<String> ships) {
        this.ships = ships;
    }

}