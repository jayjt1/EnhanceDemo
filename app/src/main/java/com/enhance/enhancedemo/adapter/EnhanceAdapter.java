package com.enhance.enhancedemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.enhance.enhancedemo.R;
import com.enhance.enhancedemo.model.LaunchInfo;
import com.enhance.enhancedemo.util.FontManager;
import com.enhance.enhancedemo.util.Util;

import java.util.Date;
import java.util.List;


public class EnhanceAdapter extends RecyclerView.Adapter<EnhanceAdapter.ViewHolder> {
    public List<LaunchInfo> launchInfo;
    Context mContext;
    public EnhanceAdapter(Context context, List<LaunchInfo> launchInfo) {

        this.mContext = context;
        this.launchInfo = launchInfo;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtTitle, txtLaunchDate, txtMissionStatus, txtMissionIcon;
        public ImageView imgAppIcon;

        //This is the subclass ViewHolder which simply
        //'holds the views' for us to show on each cell_row
        public ViewHolder(View itemView) {
            super(itemView);

            //Finds the views from our cell_row.xmlw.xml
            imgAppIcon = (ImageView) itemView.findViewById(R.id.imgAppIcon);

            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtLaunchDate = (TextView) itemView.findViewById(R.id.txtLaunchDate);
            txtMissionStatus = (TextView) itemView.findViewById(R.id.txtMissionStatus);
            txtMissionIcon = (TextView) itemView.findViewById(R.id.txtMissionIcon);

            Typeface iconFont = FontManager.getTypeface(mContext, FontManager.FONTAWESOME);
            txtMissionIcon.setTypeface(iconFont);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //This is what adds the code we've written in here to our target view

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cell_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EnhanceAdapter.ViewHolder viewHolder, int i) {

        LaunchInfo info = launchInfo.get(i);

        String url = info.getLinks().getPatch().getSmall();
        String title = info.getName();

        boolean status = info.getSuccess();
        Date date = new Date ();

        long unix_time = info.getDateUnix();
        date.setTime((long)unix_time*1000);

        Glide.with(mContext)
                .load(url)
                .thumbnail( 0.5f )
                .apply(new RequestOptions().placeholder(R.mipmap.ic_launcher))
                //  .apply(new RequestOptions().override(150, 150))
                .apply(new RequestOptions().diskCacheStrategy( DiskCacheStrategy.ALL))
                .into(viewHolder.imgAppIcon);

        viewHolder.txtTitle.setText(title);
        viewHolder.txtLaunchDate.setText("Launch Date: " + Util.getDate(date));
        viewHolder.txtMissionStatus.setText("Mission Success: ");

        if (status == true) {
            viewHolder.txtMissionIcon.setText(R.string.fa_icon_success);
            viewHolder.txtMissionIcon.setTextColor(Color.BLACK);

        } else {
            viewHolder.txtMissionIcon.setText(R.string.fa_icon_failure);
            viewHolder.txtMissionIcon.setTextColor(Color.RED);
        }
    }

    @Override
    public int getItemCount() {

        return launchInfo.size();
    }
}