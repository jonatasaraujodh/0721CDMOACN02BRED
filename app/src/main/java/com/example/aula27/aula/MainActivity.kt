package com.example.aula27.aula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula27.R

class MainActivity : AppCompatActivity(), FragmentoA.IFragmentAListener,
    FragmentoB.IFragmentBListener {

    private lateinit var fragmentA: FragmentoA
    private lateinit var fragmentB: FragmentoB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentA = FragmentoA()
        fragmentB = FragmentoB()

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.container_a,fragmentA)
        fragmentTransaction.add(R.id.container_b,fragmentB)
        fragmentTransaction.commit()

//        supportFragmentManager.beginTransaction()
//            .add(R.id.container_a,fragmentA)
//            .add(R.id.container_b,fragmentB)
//            .commit()
    }

    override fun enviarDadosA(dados: String) {
        fragmentB.atualizaB(dados)
    }

    override fun enviarDadosB(dados: String) {
        fragmentA.atualizaA(dados)
    }
}