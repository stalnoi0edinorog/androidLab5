package com.example.lab3_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_third.view.*

class ThirdFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        view.bnGoTo1.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_thirdFragment_to_mainFragment)
        }
        view.bnGoTo2.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_thirdFragment_to_secondFragment)
        }
        return view
    }
}