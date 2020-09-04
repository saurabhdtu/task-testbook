package com.tb.task.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.tb.task.R
import com.tb.task.ui.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewModel:MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataB
        viewModel = ViewModelProvider(this)
    }
}