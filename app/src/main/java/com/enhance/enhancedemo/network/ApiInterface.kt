package com.enhance.enhancedemo.network

import com.enhance.enhancedemo.model.LaunchInfo
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by riniramac001 on 28/12/16.
 */
interface ApiInterface {

    @get:GET("launches/")
    val spaceXResponse: Observable<List<LaunchInfo?>?>?
}