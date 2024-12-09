package com.example.tresenralla

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tresenralla.ui.theme.TresEnRallaTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TresEnRallaTheme {

            }
        }
    }
}
@Composable
fun MiApp() {

    // Estados para las posiciones
    var posT00 by remember { mutableStateOf(false) }
    var posT01 by remember { mutableStateOf(false) }
    var posT02 by remember { mutableStateOf(false) }
    var posT03 by remember { mutableStateOf(false) }
    var posT04 by remember { mutableStateOf(false) }
    var posT05 by remember { mutableStateOf(false) }
    var posT06 by remember { mutableStateOf(false) }
    var posT07 by remember { mutableStateOf(false) }
    var posT08 by remember { mutableStateOf(false) }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(70.dp)
    ) {
        Text(
            "Tres en Raya",
            color = Color.Black,
            fontSize = 25.sp,
            modifier = Modifier.padding(8.dp)
        )
    }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(80.dp, 170.dp)
        ) {
            Row {
                IconButtonWithState(
                    isClicked = posT00,
                    onClick = { posT00 = !posT00 }
                )
                IconButtonWithState(
                    isClicked = posT01,
                    onClick = { posT01 = !posT01 }
                )
                IconButtonWithState(
                    isClicked = posT02,
                    onClick = { posT02 = !posT02 }
                )
            }

            Row {
                IconButtonWithState(
                    isClicked = posT03,
                    onClick = { posT03 = !posT03 }
                )
                IconButtonWithState(
                    isClicked = posT04,
                    onClick = { posT04 = !posT04 }
                )
                IconButtonWithState(
                    isClicked = posT05,
                    onClick = { posT05 = !posT05 }
                )
            }

            Row {
                IconButtonWithState(
                    isClicked = posT06,
                    onClick = { posT06 = !posT06 }
                )
                IconButtonWithState(
                    isClicked = posT07,
                    onClick = { posT07 = !posT07 }
                )
                IconButtonWithState(
                    isClicked = posT08,
                    onClick = { posT08 = !posT08 }
                )
            }
        }
        Row(modifier = Modifier.padding(80.dp, 350.dp)){
        val ganador = Comprobar(
            posT00,
            posT01,
            posT02,
            posT03,
            posT04,
            posT05,
            posT06,
            posT07,
            posT08
        )
    }

}


@Composable
fun IconButtonWithState(
    isClicked: Boolean,
    onClick: () -> Unit
) {
    Icon(
        imageVector = if (isClicked) Icons.Filled.Close else Icons.Filled.Face,
        contentDescription = "Face",
        modifier = Modifier
            .width(50.dp)
            .height(50.dp)
            .clickable { onClick() }
    )
}

@Composable
fun Comprobar(
    posT00: Boolean,
    posT01: Boolean,
    posT02: Boolean,
    posT03: Boolean,
    posT04: Boolean,
    posT05: Boolean,
    posT06: Boolean,
    posT07: Boolean,
    posT08: Boolean
) {
    if (
        (posT00 && posT01 && posT02) ||
        (posT03 && posT04 && posT05) ||
        (posT06 && posT07 && posT08) ||
        (posT00 && posT03 && posT06) ||
        (posT01 && posT04 && posT07) ||
        (posT02 && posT05 && posT08) ||
        (posT00 && posT04 && posT08) ||
        (posT02 && posT04 && posT06)
    ) {
        Text(
            text = "¡Has ganado!",
            color = Color.Red,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun VistaPrevia() {
    TresEnRallaTheme {
        MiApp()
    }
}