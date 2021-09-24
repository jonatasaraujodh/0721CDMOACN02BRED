package com.example.aula28.ex01

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.aula27.R

class Fragmento05 : Fragment() {

    private lateinit var tvClicks: TextView
    private var clicks: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =  inflater.inflate(R.layout.fragment_fragmento05, container, false)
        tvClicks = view.findViewById(R.id.tv_clicks_ex03)
        view.isVisible = false
        return view
    }

    fun setClicks(){
        view?.isVisible = true
        tvClicks.text = "Clicks: ${++clicks}"
    }

}