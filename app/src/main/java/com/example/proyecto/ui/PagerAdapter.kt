package com.example.proyecto.ui

import android.content.Context
import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.proyecto.fragments.entretenimiento.MusicFragment
import com.example.proyecto.fragments.entretenimiento.VideoFragment

class PagerAdapter (fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount()=2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{VideoFragment()}
            1->{MusicFragment()}
            else->{throw Resources.NotFoundException("Positiion Not Found")}
        }
    }
}