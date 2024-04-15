package com.jhostinluna.ejercicio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jhostinluna.ejercicio1.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initListeners()
    }
    private fun initListeners() {
        binding.buttonChangeText.setOnClickListener {
            val detectButton = Random.nextBoolean()
            when(detectButton) {
                true -> binding.textViewLeft.text = getNewParagraph()
                false -> binding.textViewRight.text = getNewParagraph()
            }
            println(getNewParagraph())
        }
    }
    private fun getNewWord(): String{
        val randomCharCode = List(Random.nextInt(2,10)) { Random.nextInt(97, 122) }
        val stringBuilder = StringBuilder()
        randomCharCode.forEach {
            stringBuilder.append(it.toChar())
        }
        return stringBuilder.toString()
    }
    private fun getNewParagraph(): String {
        val stringBuilder = StringBuilder()
        val quantity = Random.nextInt(10,100)
        for (i in 1..quantity) {
            stringBuilder.append(getNewWord())
            stringBuilder.append(" ")
        }
        return stringBuilder.toString()
    }
}