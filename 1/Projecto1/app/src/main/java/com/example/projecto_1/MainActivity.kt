package com.example.projecto_1

import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

      val btnToast = findViewById<Button>(R.id.btnToast)
      btnToast.setOnClickListener{
          //
          Log.i("MainActivity","Botón pulsado")

        Toast.makeText(this, "Calculando", Toast.LENGTH_LONG).show()


      }

    }

    }
