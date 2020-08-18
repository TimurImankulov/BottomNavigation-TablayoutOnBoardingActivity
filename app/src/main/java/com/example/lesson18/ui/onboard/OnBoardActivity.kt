package com.example.lesson18.ui.onboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.lesson18.R
import com.example.lesson18.data.OnBoardModel
import com.example.lesson18.ui.MainActivity
import kotlinx.android.synthetic.main.activity_on_board.*

class OnBoardActivity : AppCompatActivity() {

    private val list = arrayListOf<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_board)
        setupViewPager()
        setupListeners()
    }

    private fun setupListeners() {
        tvNext.setOnClickListener {
            if (isLastPage(onBoardViewPager.currentItem)) {
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish()
            } else {
                onBoardViewPager.currentItem += 1
            }
        }

        tvSkip.setOnClickListener{
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }
    }

    private fun isLastPage(position: Int) = position == list.size - 1

    private fun setupViewPager() {
        val adapter = OnBoardAdapter(supportFragmentManager)
        onBoardViewPager.adapter = adapter
        list.add(OnBoardFragment.getInstance(OnBoardModel(R.drawable.mobile_development, " Mobile Development","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua")))
        list.add(OnBoardFragment.getInstance(OnBoardModel(R.drawable.web_development, "Web Development","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua")))
        list.add(OnBoardFragment.getInstance(OnBoardModel(R.drawable.web_desing, "Web Design","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua")))

        adapter.update(list)
        onBoardTabLayout.setupWithViewPager(onBoardViewPager)
    }
}