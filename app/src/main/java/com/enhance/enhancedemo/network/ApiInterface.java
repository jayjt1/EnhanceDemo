package com.enhance.enhancedemo.network;
/**
 * Created by riniramac001 on 28/12/16.
 */

import com.enhance.enhancedemo.model.LaunchInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("launches/")
    Call<List<LaunchInfo>> getSpaceXResponse();

}