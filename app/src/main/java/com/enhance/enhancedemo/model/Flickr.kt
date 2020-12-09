package com.enhance.enhancedemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Flickr {

    @SerializedName("small")
    @Expose
    var small: List<Any>? = null
    @SerializedName("original")
    @Expose
    var original: List<String>? = null

}
