package com.enhance.enhancedemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Core {

    @SerializedName("core")
    @Expose
    var core: Any? = null
    @SerializedName("flight")
    @Expose
    var flight: Any? = null
    @SerializedName("gridfins")
    @Expose
    var gridfins: Any? = null
    @SerializedName("legs")
    @Expose
    var legs: Any? = null
    @SerializedName("reused")
    @Expose
    var reused: Any? = null
    @SerializedName("landing_attempt")
    @Expose
    var landingAttempt: Any? = null
    @SerializedName("landing_success")
    @Expose
    var landingSuccess: Any? = null
    @SerializedName("landing_type")
    @Expose
    var landingType: Any? = null
    @SerializedName("landpad")
    @Expose
    var landpad: Any? = null

}
