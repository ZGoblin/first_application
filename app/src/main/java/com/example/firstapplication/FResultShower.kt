package com.example.firstapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.firstapplication.databinding.ActivityMainBinding
import com.example.firstapplication.databinding.FragmentResultShowerBinding

class FResultShower: Fragment() {
    private lateinit var binding: FragmentResultShowerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_result_shower, container, false)

        binding.bBack.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }

        val args = arguments
        binding.textView.text = args?.getString(resultNumber)?.toLong().toString()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    companion object {
        fun newInstance(): FResultShower = FResultShower()
    }
}