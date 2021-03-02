package com.example.testapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.testapp.R
import com.example.testapp.adapter.PageAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val pagerAdapter = PageAdapter(supportFragmentManager, tab_layout.getTabCount())
        view_pager.adapter = pagerAdapter
        tab_layout.setupWithViewPager(view_pager)

    }
}