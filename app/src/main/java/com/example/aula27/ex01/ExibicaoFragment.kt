package com.example.aula27.ex01
import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.aula27.R


class ExibicaoFragment : Fragment() {


    private lateinit var nome: TextView
    private lateinit var email: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_exibicao, container, false)
        nome = view.findViewById(R.id.tv_exib_nome)
        email = view.findViewById(R.id.tv_exib_email)

        //Forma de recebimento de dados no fragmento de destino por meio de um objeto Bundle
//        val dados = arguments?.getStringArrayList("msg")
//        nome.text = "Nome ${dados?.get(0)?:" não informado"}"
//        email.text = "Email ${dados?.get(1)?:" não informado"}"

        return view
    }

    fun receberDados(dados: ArrayList<String>){
        dados?.let{
            nome.text = "Nome: ${it.get(0)}"
            email.text = "Email: ${it.get(1)}"
        }
    }

    fun receberDados(dados: Pessoa){

        dados?.let{
            nome.text = "Nome: ${it.nome}"
            email.text = "Email: ${it.email}"
        }
    }

}
