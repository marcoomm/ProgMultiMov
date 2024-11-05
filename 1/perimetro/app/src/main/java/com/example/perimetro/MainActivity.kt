package com.example.perimetro

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val  calcularCuadrado = findViewById<Button>(R.id.calcularCuadrado)
        val ladoCuad = findViewById<EditText>(R.id.lCuadrado)

        val calcularCirculo = findViewById<Button>(R.id.calcularCirculo)
        val radioCir = findViewById<EditText>(R.id.rCirculo)

        calcularCuadrado.setOnClickListener {
            val mensaje:Double = ladoCuad.text.toString().toDouble();
            val intent = Intent(this, cuadrado::class.java)
            intent.putExtra("envio", mensaje)
            startActivity(intent)
        }

        calcularCirculo.setOnClickListener{
            val mensaje:Double=radioCir.text.toString().toDouble()
            val intent = Intent(this, circulo::class.java)
            intent.putExtra("envio", mensaje)
            startActivity(intent)
        }

    }
}