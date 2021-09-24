package com.example.aula27.aula

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.aula27.R
import java.lang.RuntimeException


class FragmentoA : Fragment() {

    private var callback: IFragmentAListener? = null
    private lateinit var botao: Button
    private lateinit var editText: EditText

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is IFragmentAListener){
            callback = context
        } else{
            throw RuntimeException(context.toString() + "Callback não implementado")
        }

    }

    interface IFragmentAListener {
        fun enviarDadosA(dados: String)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_fragmento_a, container, false)
        botao = view.findViewById(R.id.bt_fragment_a)
        editText = view.findViewById(R.id.edit_tex_fragment_a)

        botao.setOnClickListener {
            callback?.enviarDadosA(editText.text.toString())
        }
        return view
    }

    fun atualizaA(dados:String){
        editText.setText(dados)
    }

    override fun onDetach() {
        super.onDetach()
        callback = null
    }


}