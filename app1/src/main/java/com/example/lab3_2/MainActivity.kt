package com.example.lab3_2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.lab3_2.databinding.ActivityMainBinding
import com.example.lab3_2.databinding.ActivityMainTask5Binding
import com.example.lab3_2.databinding.FragmentFirstBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_first.view.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val binding = ActivityMainBinding.inflate(layoutInflater)
        val binding = ActivityMainTask5Binding.inflate(layoutInflater) //5
        setContentView(binding.root)

        /*binding.bnGoTo2.setOnClickListener { //2,3
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }*/

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
        when (resultCode) {
            1 -> finish()
        }
    }
}

class MainFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        view.bnGoTo2.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_secondFragment)
        }
        
        return view
    }
}