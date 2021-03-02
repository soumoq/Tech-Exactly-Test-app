package com.example.testapp.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.example.testapp.R
import com.example.testapp.fragment.ApplicationFragment
import com.example.testapp.model.application.AppLists
import kotlinx.android.synthetic.main.layout_app.view.*


class AppAdapter(private val appFragment: ApplicationFragment) :
    RecyclerView.Adapter<AppAdapter.ViewHolder>() {


    private var allApps: ArrayList<AppLists> = ArrayList()

    fun updateData(apps: List<AppLists>) {
        this.allApps.clear()
        this.allApps.addAll(apps)
        notifyDataSetChanged()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.layout_app, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(appFragment, allApps.get(position), position)
    }

    override fun getItemCount() = allApps.size

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(appFragment: ApplicationFragment, appLists: AppLists, position: Int) {
            view.app_name.setText(appLists.app_name)
            Glide.with(view.context)
                .load(appLists.app_icon)
                .error(R.drawable.ic_baseline_apps_24)
                .into(view.app_image)



        }
    }
}