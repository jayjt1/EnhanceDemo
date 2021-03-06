package com.enhance.enhancedemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Fairings {

    @SerializedName("reused")
    @Expose
    var reused: Any? = null
    @SerializedName("recovery_attempt")
    @Expose
    var recoveryAttempt: Any? = null
    @SerializedName("recovered")
    @Expose
    var recovered: Any? = null
    @SerializedName("ships")
    @Expose
    var ships: List<String>? = null

}