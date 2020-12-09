package com.enhance.enhancedemo.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.enhance.enhancedemo.R
import com.enhance.enhancedemo.model.LaunchInfo
import com.enhance.enhancedemo.util.FontManager
import com.enhance.enhancedemo.util.Util
import java.util.*


class EnhanceAdapter(internal var mContext: Context, var launchInfo: List<LaunchInfo?>?) : RecyclerView.Adapter<EnhanceAdapter.ViewHolder>() {

    inner class ViewHolder//This is the subclass ViewHolder which simply
    //'holds the views' for us to show on each cell_row
    (itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtTitle: TextView
        var txtLaunchDate: TextView
        var txtMissionStatus: TextView
        var txtMissionIcon: TextView
        var imgAppIcon: ImageView

        init {

            //Finds the views from our cell_row.xmlw.xml
            imgAppIcon = itemView.findViewById<View>(R.id.imgAppIcon) as ImageView

            txtTitle = itemView.findViewById<View>(R.id.txtTitle) as TextView
            txtLaunchDate = itemView.findViewById<View>(R.id.txtLaunchDate) as TextView
            txtMissionStatus = itemView.findViewById<View>(R.id.txtMissionStatus) as TextView
            txtMissionIcon = itemView.findViewById<View>(R.id.txtMissionIcon) as TextView

            val iconFont = FontManager.getTypeface(mContext, FontManager.FONTAWESOME)
            txtMissionIcon.typeface = iconFont
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //This is what adds the code we've written in here to our target view

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.cell_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: EnhanceAdapter.ViewHolder, i: Int) {

        val info = launchInfo?.get(i)!!

        val url = info.links!!.patch!!.small
        val title = info.name

        val status = info.success
        val date = Date()

        val unix_time = info.dateUnix
        date.time = unix_time * 1000

        Glide.with(mContext)
                .load(url)
                .thumbnail(0.5f)
                .apply(RequestOptions().placeholder(R.mipmap.ic_launcher))
                //  .apply(new RequestOptions().override(150, 150))
                .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(viewHolder.imgAppIcon)

        viewHolder.txtTitle.text = title
        viewHolder.txtLaunchDate.text = "Launch Date: " + Util.getDate(date)
        viewHolder.txtMissionStatus.text = "Mission Success: "

        if (status == true) {
            viewHolder.txtMissionIcon.setText(R.string.fa_icon_success)
            viewHolder.txtMissionIcon.setTextColor(Color.BLACK)

        } else {
            viewHolder.txtMissionIcon.setText(R.string.fa_icon_failure)
            viewHolder.txtMissionIcon.setTextColor(Color.RED)
        }
    }

    override fun getItemCount(): Int {

        return launchInfo!!.size
    }
}