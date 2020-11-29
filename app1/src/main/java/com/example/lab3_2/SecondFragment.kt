package com.example.lab3_2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_second.view.*
import kotlinx.android.synthetic.main.fragment_third.view.bnGoTo1

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        view.bnGoTo1.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_mainFragment)
        }

        view.bnGoTo3.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_thirdFragment)
        }
        return view
    }

}