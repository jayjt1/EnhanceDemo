package com.enhance.enhancedemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class LaunchInfo {

    @SerializedName("fairings")
    @Expose
    var fairings: Fairings? = null
    @SerializedName("links")
    @Expose
    var links: Links? = null
    @SerializedName("static_fire_date_utc")
    @Expose
    var staticFireDateUtc: Any? = null
    @SerializedName("static_fire_date_unix")
    @Expose
    var staticFireDateUnix: Any? = null
    @SerializedName("tbd")
    @Expose
    var isTbd: Boolean = false
    @SerializedName("net")
    @Expose
    var isNet: Boolean = false
    @SerializedName("window")
    @Expose
    var window: Any? = null
    @SerializedName("rocket")
    @Expose
    var rocket: String? = null
    @SerializedName("success")
    @Expose
    var success: Boolean = false
    @SerializedName("details")
    @Expose
    var details: Any? = null
    @SerializedName("crew")
    @Expose
    var crew: List<Any>? = null
    @SerializedName("ships")
    @Expose
    var ships: List<String>? = null
    @SerializedName("capsules")
    @Expose
    var capsules: List<Any>? = null
    @SerializedName("payloads")
    @Expose
    var payloads: List<String>? = null
    @SerializedName("launchpad")
    @Expose
    var launchpad: String? = null
    @SerializedName("auto_update")
    @Expose
    var isAutoUpdate: Boolean = false
    @SerializedName("failures")
    @Expose
    var failures: List<Any>? = null
    @SerializedName("flight_number")
    @Expose
    var flightNumber: Int = 0
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("date_utc")
    @Expose
    var dateUtc: String? = null
    @SerializedName("date_unix")
    @Expose
    var dateUnix: Long = 0
    @SerializedName("date_local")
    @Expose
    var dateLocal: String? = null
    @SerializedName("date_precision")
    @Expose
    var datePrecision: String? = null
    @SerializedName("upcoming")
    @Expose
    var isUpcoming: Boolean = false
    @SerializedName("cores")
    @Expose
    var cores: List<Core>? = null
    @SerializedName("id")
    @Expose
    var id: String? = null

}
