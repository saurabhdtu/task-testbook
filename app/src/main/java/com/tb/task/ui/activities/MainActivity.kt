package com.tb.task.ui.activities

import android.graphics.Point
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.hike.assignment.ui.interfaces.ListItemClicked
import com.tb.task.R
import com.tb.task.databinding.ActivityMainBinding
import com.tb.task.ui.adapters.AdapterClasses
import com.tb.task.ui.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity(), ListItemClicked {
    lateinit var viewModel: MainActivityViewModel
    lateinit var adapter: AdapterClasses
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        val rv = findViewById<RecyclerView>(R.id.recycler_view)
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rv)
        rv.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        val point = Point()
        windowManager.defaultDisplay.getSize(point)
        adapter = AdapterClasses(point,this)
        rv.adapter = adapter
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        viewModel.classData.observe(this, {
            adapter.appendList(it)
        })
        viewModel.getClasses()
    }

    override fun itemClicked(position: Int, obj: Any, type: Int) {

    }
}