package com.example.aula27.ex01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.aula27.R

class CadastroActivity : AppCompatActivity(), IFormulario {

    private lateinit var formularioFragment: FormularioFragment
    private lateinit var exibicaoFragment: ExibicaoFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        initFragments()

    }

    override fun enviarDadosFormulario(dados: ArrayList<String>) {
        exibicaoFragment.receberDados(dados)

    }

    override fun enviarDadosFormulario(dados: Pessoa) {
        exibicaoFragment.receberDados(dados)

    }

    private fun initFragments() {
        formularioFragment = FormularioFragment()
        exibicaoFragment = ExibicaoFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.container_a_ex01,formularioFragment)
        fragmentTransaction.add(R.id.container_b_ex01,exibicaoFragment)
        fragmentTransaction.commit()
    }

}