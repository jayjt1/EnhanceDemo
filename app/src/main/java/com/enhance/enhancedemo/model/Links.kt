package com.enhance.enhancedemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Links {

    @SerializedName("patch")
    @Expose
    var patch: Patch? = null
    @SerializedName("reddit")
    @Expose
    var reddit: Reddit? = null
    @SerializedName("flickr")
    @Expose
    var flickr: Flickr? = null
    @SerializedName("presskit")
    @Expose
    var presskit: Any? = null
    @SerializedName("webcast")
    @Expose
    var webcast: Any? = null
    @SerializedName("youtube_id")
    @Expose
    var youtubeId: Any? = null
    @SerializedName("article")
    @Expose
    var article: Any? = null
    @SerializedName("wikipedia")
    @Expose
    var wikipedia: Any? = null

}
