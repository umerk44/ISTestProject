package com.test.istestprojectapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.istestprojectapplication.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        collapsingToolbar.title = title
    }

    fun setActionbarTitle(title: String) {
        collapsingToolbar.title = title
    }
}