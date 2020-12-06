package com.enhance.enhancedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.enhance.enhancedemo.adapter.EnhanceAdapter;
import com.enhance.enhancedemo.model.LaunchInfo;
import com.enhance.enhancedemo.network.ApiInterface;
import com.enhance.enhancedemo.network.NetworkUtil;
import com.enhance.enhancedemo.util.SimpleDividerItemDecoration;
import com.enhance.enhancedemo.util.Util;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EnhanceActivity extends AppCompatActivity {

    RecyclerView recyclerSpaceX;
    List<LaunchInfo> launchInfo;
    EnhanceAdapter enhanceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enhance);

        recyclerSpaceX = (RecyclerView) findViewById(R.id.recyclerSpaceX);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerSpaceX.setLayoutManager(mLayoutManager);
        recyclerSpaceX.addItemDecoration(new SimpleDividerItemDecoration(this));

        makeApiRequest();

        //recyclerSpaceX.setAdapter(enhanceAdapter);
    }

    private void makeApiRequest() {

        Util.showLoader(this);

        ApiInterface apiService = NetworkUtil.getClient().create(ApiInterface.class);
        Call<List<LaunchInfo>> call = apiService.getSpaceXResponse();
        call.enqueue(new Callback<List<LaunchInfo>>() {
            @Override
            public void onResponse(Call<List<LaunchInfo>> call, Response<List<LaunchInfo>> response) {

                Util.hideLoader();
                if (response.isSuccessful()) {
                    List<LaunchInfo> launchInfo = response.body();
                    enhanceAdapter = new EnhanceAdapter(EnhanceActivity.this, launchInfo);
                    recyclerSpaceX.setAdapter(enhanceAdapter);

                } else {

                    Toast.makeText(EnhanceActivity.this, "Data not found", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<LaunchInfo>> call, Throwable t) {

                Util.hideLoader();
                Toast.makeText(EnhanceActivity.this, "Data not found", Toast.LENGTH_LONG).show();
            }
        });
    }
}
