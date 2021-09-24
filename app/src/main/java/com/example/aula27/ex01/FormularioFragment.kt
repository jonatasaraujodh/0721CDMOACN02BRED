package com.example.aula27.ex01

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.aula27.R
import java.lang.RuntimeException


class FormularioFragment : Fragment() {

    private lateinit var callback: IFormulario
    private lateinit var nome: EditText
    private lateinit var email: EditText
    private lateinit var senha: EditText
    private lateinit var senha2: EditText
    private lateinit var botao: Button

    /* Na função OnAtach, que é o primeiro estado do ciclo de vida de um fragmento, chamado
    * quando o fragmento tiver sido associado a Activity, verificamo se esta Activiy corresponde
    * ao tipo da Interface que tratará os dados deste Fragmento (esta Activity deve implementar a
    * interface definida). Em caso afirmativo, o callback passa a ser uma referencia para a activity
    * Neste exemplo, verifica
     */
    override fun onAttach(activity: Context) {
        super.onAttach(activity)
        if (activity is IFormulario){
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
        var view: View = inflater.inflate(R.layout.fragment_formulario, container, false)
        nome = view.findViewById<EditText>(R.id.et_form_nome)
        email = view.findViewById<EditText>(R.id.et_form_email)
        senha = view.findViewById<EditText>(R.id.et_form_senha)
        senha2 = view.findViewById<EditText>(R.id.et_form_confirma_senha)
        botao = view.findViewById(R.id.bt_formulario_cadastrar)

        // chamando função com dados em um arraylist
//        botao.setOnClickListener {
//            val pessoa = arrayListOf<String> (nome.text.toString(),
//                email.text.toString(),
//                senha.text.toString(),
//                senha2.text.toString())
//            callback.enviarDadosFormulario(pessoa)
//        }
        // chamando função com dados em um objeto
        botao.setOnClickListener {
            var pessoa: Pessoa = Pessoa (nome.text.toString(),
                email.text.toString(),
                senha.text.toString(),
                senha2.text.toString())
            callback.enviarDadosFormulario(pessoa)
        }
        return view
    }

}