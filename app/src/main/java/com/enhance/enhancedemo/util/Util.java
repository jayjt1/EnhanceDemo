package com.enhance.enhancedemo.util;

import android.app.ProgressDialog;
import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    static ProgressDialog progressDialog;

    public static  void showLoader(Context mContext) {

        progressDialog = new ProgressDialog(mContext);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.setTitle(Constants.TITLE);
        progressDialog.setMessage(Constants.MSG_LOADING);
        progressDialog.show();
    }

    public static  void hideLoader() {

        if (progressDialog != null && progressDialog.isShowing()) {

            progressDialog.dismiss();
        }
    }

    public static String getDate(Date date) {

        String PATTERN = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern(PATTERN);
        String newDate = dateFormat.format(date);
        return newDate;
    }
}
