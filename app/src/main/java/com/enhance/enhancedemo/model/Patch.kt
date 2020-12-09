package com.enhance.enhancedemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Patch {

    @SerializedName("small")
    @Expose
    var small: String? = null
    @SerializedName("large")
    @Expose
    var large: String? = null

}
