package com.example.appprueba1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appprueba1.ui.theme.AppPrueba1Theme
import com.google.ai.client.generativeai.type.content

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MiApp(){
    Surface(
        modifier = Modifier.fillMaxSize().padding(50.dp),
        shape = MaterialTheme.shapes .small,
        color = MaterialTheme.colorScheme.primary,
        shadowElevation = 10.dp,
        border = BorderStroke(3.dp, Color.Black)
    ){
        Scaffold(
            topBar= { TopAppBar(title = {Text("Barra Superior")},
            colors = topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary
            ))},
            bottomBar = {BottomAppBar() { Text("Barra Inferior") } },

            floatingActionButton = {
                FloatingActionButton(onClick = {}) {
                    Icon(Icons.Filled.AddCircle, contentDescription = "Check")
                }
            },

            content = {padding ->
                Surface(
                    modifier = Modifier.fillMaxSize().padding(padding),
                    shape = MaterialTheme.shapes .small,
                    color = MaterialTheme.colorScheme.primary,
                    shadowElevation = 10.dp,
                    border = BorderStroke(3.dp, Color.Black)
                ){
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            "¿Cómo están ustedes?",
                            modifier = Modifier.background(Color.Transparent),
                            color = Color.Black,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 50.sp
                        )
                        Icon(Icons.Filled.Face, contentDescription = "Face",modifier = Modifier.width(50.dp).height(50.dp))

                        val texto by remember { mutableStateOf("") }

                        TextField(texto,onValueChange = {}, modifier = Modifier.padding(50.dp), label ={Text("Datos")})

                    }}})}}



/*
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        shape = MaterialTheme.shapes.small,
        color = MaterialTheme.colorScheme.primary,
        shadowElevation = 10.dp,
        border = BorderStroke(3.dp, Color.Black)
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Barra Superior") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary
                    )
                )
            },
            bottomBar = {
                BottomAppBar {
                    Text("Barra Inferior")
                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {}) {
                    Icon(Icons.Filled.AddCircle, contentDescription = "Check")
                }
            },
            content = { padding ->
                Box(modifier = Modifier.padding(padding)) {
                    Text("Principal")
                }
            }
        )
    }
}
*/
/*
   Surface(
       modifier = Modifier.fillMaxSize().padding(50.dp),
       shape = MaterialTheme.shapes .small,
       color = MaterialTheme.colorScheme.primary,
       shadowElevation = 10.dp,
       border = BorderStroke(3.dp, Color.Black)
   ){

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

       Row(modifier = Modifier.padding(10.dp),
           verticalAlignment = Alignment.CenterVertically){
           Text("Hola a todos")
           Text("¿Cómo están ustedes?")
       }
       Box(){
           Text("de la Tele")
           Icon(Icons.Filled.Check, contentDescription = "Check")
       }

   }
}
*/
@Preview(showBackground = true)
@Composable
fun VistaPrevia() {
   AppPrueba1Theme {
       MiApp()
   }
}