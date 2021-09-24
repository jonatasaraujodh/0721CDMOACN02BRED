package com.example.aula24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.aula27.R

class SegundaActivity : AppCompatActivity() {

    lateinit var tvNome: TextView
    lateinit var tvEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //iniciando os componentes da tela
        setContentView(R.layout.activity_segunda)
        tvNome = findViewById(R.id.act_segunda_tv_nome)
        tvEmail = findViewById(R.id.act_segunda_tv_email)

        // recuperando os dados enviados da activity anterior
        val extras: Bundle? = intent.extras

        // inserindo conteudo enviado nos elementos da activity atual
        tvNome.text  = extras?.getString("nome")
        tvEmail.text  = extras?.getString("email")


    }
}