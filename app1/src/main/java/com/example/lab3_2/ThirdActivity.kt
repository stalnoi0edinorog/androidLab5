package com.example.lab3_2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab3_2.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnGoTo1.setOnClickListener {
            //setResult(1) //2
            //finish()     //2
            val intent = Intent(this, MainActivity::class.java) //3
            //intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP //4
            startActivity(intent)
        }
        binding.bnGoTo2.setOnClickListener {
            finish() //2,3
        }
        binding.bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.about -> {
                    startActivity(Intent(this, AboutActivity::class.java))
                }
            }
            false
        }

    }
}