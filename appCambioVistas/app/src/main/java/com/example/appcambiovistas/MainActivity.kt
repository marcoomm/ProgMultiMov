package com.example.appcambiovistas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import com.example.appcambiovistas.ui.theme.AppCambioVistasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppCambioVistasTheme {

            }
        }
    }
}

@Composable
fun NavegacionEntreVentana(){
    val controladorNavegacion = rememberNavController()
    NavHost(navController = controladorNavegacion, startDestination = "inicio"){
        composable("inicio"){ MyApp(controladorNavegacion) }
        composable("detalles"){DetallesProducto(controladorNavegacion)}
    }
}

@Composable
fun DetallesProducto(navController : NavController){
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text("Esto son los detalles cuadno pinchas en el botón")
        Button(onClick = {navController.popBackStack()}){
            Text("Volver atrás")
        }
    }

}

@Composable
fun MyApp(navController: NavHostController) {
    Surface(){
        Column(modifier = Modifier.padding(6.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start){
            Button(onClick={
                navController.navigate("detalle")
            }){
                Text("boton del pene")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun VistaPrevia() {
    AppCambioVistasTheme {
        NavegacionEntreVentana()
    }
}







