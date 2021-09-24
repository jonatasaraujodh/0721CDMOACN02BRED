package com.example.aula28.ex01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula27.R

class ScreenActivity : AppCompatActivity(), IComunicador {

    private lateinit var fragmento01: Fragmento01
    private lateinit var fragmento02: Fragmento02
    private lateinit var fragmento03: Fragmento03
    private lateinit var fragmento04: Fragmento04
    private lateinit var fragmento05: Fragmento05

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen)

        initFragments()
    }

    private fun initFragments() {
        fragmento01 = Fragmento01()
        fragmento02 = Fragmento02()
        fragmento03 = Fragmento03()
        fragmento04 = Fragmento04()
        fragmento05 = Fragmento05()

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.container_01_ex03,fragmento01)
        fragmentTransaction.add(R.id.container_02_ex03,fragmento02)
        fragmentTransaction.add(R.id.container_03_ex03,fragmento03)
        fragmentTransaction.add(R.id.container_04_ex03,fragmento04)
        fragmentTransaction.add(R.id.container_05_ex03,fragmento05)
        fragmentTransaction.commit()
    }

    override fun contarClicks() {
        fragmento05.setClicks()
    }

    override fun setContador(contador: Int) {
        fragmento02.setContador(contador)
    }

    override fun somar() {
//        fragmento02.somar()
        fragmento02.setContador(1)
    }

    override fun reduzir() {
//        fragmento02.reduzir()
        fragmento02.setContador(-1)
    }

    override fun zerarContador() {
        fragmento02.setContador(0)
//        fragmento02.zerarContador()
    }

}