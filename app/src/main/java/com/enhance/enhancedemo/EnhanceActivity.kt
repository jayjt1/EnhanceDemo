package com.enhance.enhancedemo

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enhance.enhancedemo.adapter.EnhanceAdapter
import com.enhance.enhancedemo.model.LaunchInfo
import com.enhance.enhancedemo.network.ApiInterface
import com.enhance.enhancedemo.network.NetworkUtil.client
import com.enhance.enhancedemo.util.Constants
import com.enhance.enhancedemo.util.SimpleDividerItemDecoration
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class EnhanceActivity : AppCompatActivity() {
    var recyclerSpaceX: RecyclerView? = null
    var launchInfo: List<LaunchInfo>? = null
    var enhanceAdapter: EnhanceAdapter? = null

    internal var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enhance)
        recyclerSpaceX = findViewById(R.id.recyclerSpaceX) as RecyclerView
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerSpaceX!!.layoutManager = mLayoutManager
        recyclerSpaceX!!.addItemDecoration(SimpleDividerItemDecoration(this))
        makeApiRequest()

    }

    private fun makeApiRequest() {
        showLoader(this)
        val apiService =
            client!!.create(ApiInterface::class.java)
        val launchInfoObservable =
            apiService.spaceXResponse
        launchInfoObservable!!.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { launchInfo: List<LaunchInfo?>? ->
                    handleResults(
                        launchInfo
                    )
                }
            ) { t: Throwable ->
                handleError(
                    t
                )
            }
    }

    private fun handleResults(launchInfo: List<LaunchInfo?>?) {

        hideLoader()

        enhanceAdapter = EnhanceAdapter(this@EnhanceActivity, launchInfo)
        recyclerSpaceX!!.adapter = enhanceAdapter
    }

    private fun handleError(t: Throwable) {

        hideLoader()
        Toast.makeText(this@EnhanceActivity, "Data not found", Toast.LENGTH_LONG).show()
    }

    fun showLoader(mContext: Context) {

        progressDialog = ProgressDialog(mContext)
        progressDialog!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        progressDialog!!.setCancelable(false)
        progressDialog!!.setTitle(Constants.TITLE)
        progressDialog!!.setMessage(Constants.MSG_LOADING)
        progressDialog!!.show()
    }

    fun hideLoader() {

        if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog!!.dismiss()
        }
    }
}