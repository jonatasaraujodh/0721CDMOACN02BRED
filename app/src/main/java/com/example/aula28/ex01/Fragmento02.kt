package com.example.aula28.ex01

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.aula27.R
import java.lang.RuntimeException


class Fragmento02 : Fragment() {

    private lateinit var callback: IComunicador
    private lateinit var tvResultado: TextView
    private var contador: Int = 0

    override fun onAttach(activity: Context) {
        super.onAttach(activity)
        if(activity is IComunicador){
            callback = activity
        } else{
            throw RuntimeException(context.toString() + "Callback não implementado")
        }
    }

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
            callback.ocultarFragmentoZerar(true)
        } else {
            view?.isVisible = true
            callback.ocultarFragmentoZerar(false)
            tvResultado.text = "Contador: ${contador}"
        }
    }
}