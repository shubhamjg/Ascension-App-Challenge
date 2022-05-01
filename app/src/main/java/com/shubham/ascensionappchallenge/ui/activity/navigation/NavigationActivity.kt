package com.shubham.ascensionappchallenge.ui.activity.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shubham.ascensionappchallenge.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
    }
}