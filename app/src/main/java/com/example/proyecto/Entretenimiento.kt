package com.example.proyecto

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.proyecto.ui.PagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Entretenimiento : AppCompatActivity() {
    private lateinit var tabLayout:TabLayout
    private lateinit var viewPager:ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entretenimiento)
        tabLayout=findViewById(R.id.tabLayout)
        viewPager=findViewById(R.id.viewPager)
        viewPager.adapter=PagerAdapter(this)
        TabLayoutMediator(tabLayout,viewPager){ tab,index->
            tab.text=when(index){
                0->{"Videos"}
                1->{"Musica"}
                else->{ throw Resources.NotFoundException("Position Not Found")}
            }
        }.attach()

    }
}