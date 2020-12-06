package com.enhance.enhancedemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Core {

    @SerializedName("core")
    @Expose
    private Object core;
    @SerializedName("flight")
    @Expose
    private Object flight;
    @SerializedName("gridfins")
    @Expose
    private Object gridfins;
    @SerializedName("legs")
    @Expose
    private Object legs;
    @SerializedName("reused")
    @Expose
    private Object reused;
    @SerializedName("landing_attempt")
    @Expose
    private Object landingAttempt;
    @SerializedName("landing_success")
    @Expose
    private Object landingSuccess;
    @SerializedName("landing_type")
    @Expose
    private Object landingType;
    @SerializedName("landpad")
    @Expose
    private Object landpad;

    public Object getCore() {
        return core;
    }

    public void setCore(Object core) {
        this.core = core;
    }

    public Object getFlight() {
        return flight;
    }

    public void setFlight(Object flight) {
        this.flight = flight;
    }

    public Object getGridfins() {
        return gridfins;
    }

    public void setGridfins(Object gridfins) {
        this.gridfins = gridfins;
    }

    public Object getLegs() {
        return legs;
    }

    public void setLegs(Object legs) {
        this.legs = legs;
    }

    public Object getReused() {
        return reused;
    }

    public void setReused(Object reused) {
        this.reused = reused;
    }

    public Object getLandingAttempt() {
        return landingAttempt;
    }

    public void setLandingAttempt(Object landingAttempt) {
        this.landingAttempt = landingAttempt;
    }

    public Object getLandingSuccess() {
        return landingSuccess;
    }

    public void setLandingSuccess(Object landingSuccess) {
        this.landingSuccess = landingSuccess;
    }

    public Object getLandingType() {
        return landingType;
    }

    public void setLandingType(Object landingType) {
        this.landingType = landingType;
    }

    public Object getLandpad() {
        return landpad;
    }

    public void setLandpad(Object landpad) {
        this.landpad = landpad;
    }

}
