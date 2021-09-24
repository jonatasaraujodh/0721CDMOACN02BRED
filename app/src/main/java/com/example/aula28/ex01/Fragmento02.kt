package com.example.aula28.ex01

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.aula27.R


class Fragmento02 : Fragment() {

    private lateinit var tvResultado: TextView
    private var contador: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragmento02, container, false)
        tvResultado = view.findViewById(R.id.tv_result_ex03)
        view.isVisible = false
        return view
    }

    fun setContador(valor: Int){
        contador+=valor
        if (contador == 0 || valor == 0){
            contador = 0
            view?.isVisible = false
        } else {
            view?.isVisible = true
            tvResultado.text = "Contador: ${contador}"
        }
    }

    fun somar(){
        view?.isVisible = true
        tvResultado.text = "Contador: ${++contador}"
    }

    fun reduzir(){
        view?.isVisible = true
        tvResultado.text = "Contador: ${--contador}"
    }

    fun zerarContador(){
        view?.isVisible = false
        contador = 0
        tvResultado.text = "Contador: ${contador}"
    }


}