package com.example.appprueba1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appprueba1.ui.theme.AppPrueba1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppPrueba1Theme {
                }
            }
        }
    }

@Composable
private fun MiApp(){
    Surface(
        modifier = Modifier.fillMaxSize().padding(50.dp),
        shape = MaterialTheme.shapes .small,
        color = MaterialTheme.colorScheme.primary,
        shadowElevation = 10.dp,
        border = BorderStroke(3.dp, Color.Black)
    ){
        /*
        Column(modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Text("Hola a todos")
            Text("¿Cómo están ustedes?",
                modifier = Modifier.background(Color.Transparent),
                color = Color.Gray,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold
            )
        }
        */
        Row(modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically){
            Text("Hola a todos")
            Text("¿Cómo están ustedes?")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun VistaPrevia() {
    AppPrueba1Theme {
        MiApp()
    }
}