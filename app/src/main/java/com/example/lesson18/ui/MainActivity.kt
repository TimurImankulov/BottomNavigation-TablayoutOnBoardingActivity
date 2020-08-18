package com.example.lesson18.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson18.R
import com.example.lesson18.ui.bottomnavigation.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNav()
        setupListeners()
    }

    private fun setupBottomNav() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
        adapter.addFragment(HomeFragment())
        adapter.addFragment(SubscriptionsFragment())
        adapter.addFragment(NotificationsFragment())
        adapter.addFragment(LibraryFragment())
    }

    private fun setupListeners() {
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> viewPager.currentItem = 0
                R.id.subscriptions -> viewPager.currentItem = 1
                R.id.notifications -> viewPager.currentItem = 2
                R.id.library -> viewPager.currentItem = 3
            }

            return@setOnNavigationItemSelectedListener true
        }
    }
}