package com.example.testapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testapp.R
import com.example.testapp.adapter.AppAdapter
import com.example.testapp.viewmodel.ApplicationViewModel
import kotlinx.android.synthetic.main.fragment_application.*
import kotlinx.android.synthetic.main.fragment_application.view.*

class ApplicationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_application, container, false)

        val appAdapter = AppAdapter(this)
        view.recycler_view.adapter = appAdapter
        val applicationViewModel = ViewModelProvider(this).get(ApplicationViewModel::class.java)
        applicationViewModel.appList.observe(viewLifecycleOwner, Observer {
            if (it.size > 0) {
                appAdapter.updateData(it)
            }
        })
        if (view.search.text.toString().length > 0) {
            applicationViewModel.createOrder(context!!, view.search.text.toString())
        } else {
            applicationViewModel.createOrder(context!!, "")
        }

        view.searching.setOnClickListener {
            if (view.search.text.toString().length > 0) {
                applicationViewModel.createOrder(
                    context!!,
                    view.search.text.toString().toLowerCase()
                )
            } else {
                applicationViewModel.createOrder(context!!, "")
            }
        }

        return view
    }


}