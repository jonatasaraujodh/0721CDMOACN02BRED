package com.example.aula24

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.aula27.R

class PrimeiraActivity : AppCompatActivity() {

    private lateinit var botao: Button
    private lateinit var tvNome: TextView
    private lateinit var tvEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inicializando os componentes da tela
        setContentView(R.layout.activity_primeira)
        botao = findViewById(R.id.act_primeira_bt_confirmar)
        tvNome = findViewById(R.id.act_primeira_tv_nome)
        tvEmail = findViewById(R.id.act_primeira_tv_email)


        //iniciando a escuta do botão "Confirmar"
        botao.setOnClickListener {
            val intent = Intent(this, SegundaActivity::class.java)

            //enviando dados para a segunda activity
            intent.putExtra("nome",tvNome.text.toString())
            intent.putExtra("email",tvEmail.text.toString())

            startActivity(intent)
        }

    }

}