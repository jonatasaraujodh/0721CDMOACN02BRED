package com.example.aula28.ex01

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aula27.R
import android.content.Context
import android.widget.Button
import java.lang.RuntimeException


class Fragmento03 : Fragment() {

    private lateinit var callback: IComunicador
    private lateinit var botaoMenos: Button

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
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fragmento03, container, false)
        botaoMenos = view.findViewById(R.id.bt_menos)

        botaoMenos.setOnClickListener {
//            callback.reduzir()
            callback.setContador(-1)
            callback.contarClicks()
        }
        return view
    }

}