package com.test.istestprojectapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import com.google.android.material.appbar.AppBarLayout
import com.test.istestprojectapplication.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var userName : String? = null

    private var state : State = State.EXPANDED
    private var mode : Mode = Mode.STANDARD


    private val onOffsetChangedListener = AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
        if (Math.abs(verticalOffset) - appBarLayout.totalScrollRange == 0) {
            state = State.COLLAPSED
            showCollapsedView()
        } else {
            state = State.EXPANDED
            showExpandedView()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        setStandardActionBar(title.toString())

    }

     fun setStandardActionBar(title: String) {
         appBar.removeOnOffsetChangedListener(onOffsetChangedListener)
        mode = Mode.STANDARD
        customExpandView.visibility = GONE
        collapsingToolbar.title = title
    }

    fun setWelcomeActionBar(subtitle : String) {
        appBar.addOnOffsetChangedListener(onOffsetChangedListener)
        mode = Mode.CUSTOM
        userName = subtitle
       /* when(state) {
            is State.EXPANDED -> {
                showExpandedView()
            }
            else -> {
                showCollapsedView()
            }
        }*/
    }

    private fun showCollapsedView() {
        customExpandView.visibility = GONE
        collapsingToolbar.title = "Welcome $userName"
    }

    private fun showExpandedView() {
        customExpandView.visibility = VISIBLE
        main_title.text = "Welcome"
        sub_title.text = userName
        collapsingToolbar.title = " "
    }


    sealed class State {
      object EXPANDED : State()
      object COLLAPSED : State()
    }

    sealed class Mode {
        object STANDARD : Mode()
        object CUSTOM : Mode()
    }
}