package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.Main.Companion.prefs
import com.example.proyecto.ui.CustomAdapter
import com.example.proyecto.ui.CustomAdapter.OnModuleClickListener
import com.example.proyecto.viewmodel.ModuleViewModel
import com.facebook.shimmer.ShimmerFrameLayout

class Modulos : AppCompatActivity(), OnModuleClickListener {
    private val adapter = CustomAdapter(this, this)
    private val viewModel by lazy { ViewModelProvider(this).get(ModuleViewModel::class.java) }
    lateinit var container: ShimmerFrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modulos)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewMOD)
        container = findViewById(R.id.shimmer_view_container)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        observeData()
    }

    fun observeData() {
        container.startShimmer()
        viewModel.fetchModuleData().observe(this, Observer {
            container.stopShimmer()
            container.visibility = View.GONE
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
            prefs.saveM(adapter.itemCount)
        })
    }

    override fun onItemClick(title: String) {
        //Toast.makeText(this,"Este es un $title",Toast.LENGTH_LONG).show()
        val intent = Intent(this, MActivity::class.java)
        intent.putExtra("titulo",title)
        startActivity(intent)
    }
}