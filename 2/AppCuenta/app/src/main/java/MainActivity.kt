import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appcuenta.ui.theme.AppCuentaTheme
import componentes.CajaTexto
import widgets.IconoBotonRedondo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppCuentaTheme {
                MiApp {
                    TopCabecera()

                }
            }
        }
    }
}

@Composable
fun MiApp(content: @Composable ()->Unit){
    AppCuentaTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            content()
        }
    }
}


@Preview
@Composable
fun TopCabecera(totalPorPersona: Double=0.0){
    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .clip(shape= CircleShape.copy(all= CornerSize(12.dp))),
        color = Color(0xFFE9D7F7)
    ) {
        Column(modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)
            {
            val total = "%.2f".format(totalPorPersona)
            Text(text = "Cantidad por persona", style = MaterialTheme.typography.titleSmall)
            Text(text="$totalPorPersona€", style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@Preview
@Composable
fun ContenidoPrincipal(){
    FormularioCuenta() { cantidadCuenta ->
        Log.d("Cantidad", "ContenidoPrincipal:${cantidadCuenta.toInt() * 100}")
    }
}

@Composable
private fun FormularioCuenta(modifier: Modifier=Modifier,
                             onValChange: (String)->Unit) {
    val totalCuenta = remember {
        mutableStateOf("")
    }

    val estadoValido = remember(totalCuenta.value) {
        totalCuenta.value.trim().isNotEmpty()
    }

    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 2.dp, color = Color.LightGray)
    ) {
        Column(modifier = Modifier.padding(6.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start) {
            CajaTexto(valueState = totalCuenta,
                labelId = "Introduce la cuenta",
                enabled = true,
                isSingleLine = true,
                onAction = KeyboardActions {
                    if (!estadoValido) return@KeyboardActions
                    onValChange(totalCuenta.value.trim())
                    keyboardController?.hide()
                })
            //if(estadoValido){
                Row (modifier = Modifier.padding(3.dp),
                    horizontalArrangement = Arrangement.Start){
                    Text(text = "Escribiendo...",modifier = Modifier.align(
                        alignment = Alignment.CenterVertically
                    ))
                    Spacer(modifier=Modifier.width(120.dp))
                    Row(modifier = Modifier.padding(horizontal=3.dp),
                        horizontalArrangement = Arrangement.End){
                        IconoBotonRedondo(
                            imageVector = Icons.Default.Remove,
                            onClick = {
                                Log.d("Icono","pulsado el menos")
                            }
                        )
                        Text(text = "2",
                            modifier = Modifier.align(Alignment.CenterVertically)
                                .padding(start=9.dp, end = 9.dp))
                        IconoBotonRedondo(
                            imageVector = Icons.Default.Add,
                            onClick = {
                                Log.d("Icono","pulsado el más")
                            }
                        )

                    }
                }
            //}else{
            //    Box(){}
            //}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VistaPreeliminar() {
    AppCuentaTheme {
    }
}