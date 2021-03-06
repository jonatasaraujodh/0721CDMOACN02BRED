package com.example.aula28.aula

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.aula27.R

class FragmentInferior : Fragment() {

    private var contador: Int = 0
    private lateinit var textResult: TextView
    private lateinit var botao: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // variável que vai capturar o conteúdo do fragmento B
        val view: View =  inflater.inflate(R.layout.fragment_inferior, container, false)

        //tornando a view do fragmento não visivel inicialmente
        view.isVisible = false

        // recuperando os elementos de botão do layout
        textResult = view.findViewById(R.id.tv_result_ex03)
        botao = view.findViewById(R.id.bt_zerar)


        // adicionando tratamento ao evento de clique no botão zerar
        botao.setOnClickListener {
            //chama função setResult, no próprio fragmento, para zerar o conteúdo do contador
            setResult(0)
        }
        return view
    }

    // Função que atualiza o valro do contador no fragmento B, a partir das chamadas das funções
    // da interface IComunicador, implementada na MainActivity, e no evento do botão "Zerar",
    // do próprio fragmento B.
    // Por fim, o conteúdo (texto) do elemento TextView do fragmento B é atualizado.
    fun setResult(valor: Int){
        contador+=valor
        if (contador == 0 || valor == 0){
            contador = 0
            view?.isVisible = false
        } else {
            view?.isVisible = true
            textResult.text = "Contador: ${contador}"
        }

    }

}