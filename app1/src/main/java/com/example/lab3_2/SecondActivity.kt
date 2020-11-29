package com.example.lab3_2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.lab3_2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bnGoTo1.setOnClickListener {
            //startActivity(Intent(this, MainActivity::class.java)) // singleTop
            finish() //2,3
        }

        binding.bnGoTo3.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java) //2,3
            startActivity(intent) //3
            //startActivityForResult(intent, 2) //2
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) { //2
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 2) {
            if (resultCode == 1) {
                finish()
            }
        }
    }

}