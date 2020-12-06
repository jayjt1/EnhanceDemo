package com.enhance.enhancedemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("patch")
    @Expose
    private Patch patch;
    @SerializedName("reddit")
    @Expose
    private Reddit reddit;
    @SerializedName("flickr")
    @Expose
    private Flickr flickr;
    @SerializedName("presskit")
    @Expose
    private Object presskit;
    @SerializedName("webcast")
    @Expose
    private Object webcast;
    @SerializedName("youtube_id")
    @Expose
    private Object youtubeId;
    @SerializedName("article")
    @Expose
    private Object article;
    @SerializedName("wikipedia")
    @Expose
    private Object wikipedia;

    public Patch getPatch() {
        return patch;
    }

    public void setPatch(Patch patch) {
        this.patch = patch;
    }

    public Reddit getReddit() {
        return reddit;
    }

    public void setReddit(Reddit reddit) {
        this.reddit = reddit;
    }

    public Flickr getFlickr() {
        return flickr;
    }

    public void setFlickr(Flickr flickr) {
        this.flickr = flickr;
    }

    public Object getPresskit() {
        return presskit;
    }

    public void setPresskit(Object presskit) {
        this.presskit = presskit;
    }

    public Object getWebcast() {
        return webcast;
    }

    public void setWebcast(Object webcast) {
        this.webcast = webcast;
    }

    public Object getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(Object youtubeId) {
        this.youtubeId = youtubeId;
    }

    public Object getArticle() {
        return article;
    }

    public void setArticle(Object article) {
        this.article = article;
    }

    public Object getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(Object wikipedia) {
        this.wikipedia = wikipedia;
    }

}
