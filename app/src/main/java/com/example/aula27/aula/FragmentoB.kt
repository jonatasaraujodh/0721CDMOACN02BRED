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


class FragmentoB : Fragment() {

    private lateinit var editText: EditText
    private lateinit var botao: Button
    private var callback: IFragmentBListener? = null

    interface IFragmentBListener {
        fun enviarDadosB(dados: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is IFragmentBListener){
            callback = context
        } else{
            throw RuntimeException(context.toString() + "Callback não implementado")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view: View = inflater.inflate(R.layout.fragment_fragmento_b, container, false)
        editText = view.findViewById(R.id.edit_tex_fragment_b)
        botao = view.findViewById(R.id.bt_fragment_b)

        botao.setOnClickListener {
            callback?.enviarDadosB(editText?.text.toString())
        }

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_fragmento_b, container, false)
        return view
    }

    fun atualizaB(dados: String){
        editText.setText(dados)


    }

    override fun onDetach() {
        super.onDetach()
        callback = null
    }


}