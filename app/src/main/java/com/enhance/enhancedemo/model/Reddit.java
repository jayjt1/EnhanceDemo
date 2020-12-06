package com.enhance.enhancedemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Reddit {

    @SerializedName("campaign")
    @Expose
    private String campaign;
    @SerializedName("launch")
    @Expose
    private Object launch;
    @SerializedName("media")
    @Expose
    private Object media;
    @SerializedName("recovery")
    @Expose
    private Object recovery;

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public Object getLaunch() {
        return launch;
    }

    public void setLaunch(Object launch) {
        this.launch = launch;
    }

    public Object getMedia() {
        return media;
    }

    public void setMedia(Object media) {
        this.media = media;
    }

    public Object getRecovery() {
        return recovery;
    }

    public void setRecovery(Object recovery) {
        this.recovery = recovery;
    }

}