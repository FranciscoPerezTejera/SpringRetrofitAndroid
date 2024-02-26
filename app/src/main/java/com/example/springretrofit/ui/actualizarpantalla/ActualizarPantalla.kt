package com.example.springretrofit.ui.actualizarpantalla
/*
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.springretrofit.repositorio.ViewModelRetrofit
import com.example.springretrofit.ui.ruta.Rutas
import com.example.springretrofit.ui.theme.SpringRetrofitTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ActualizarPantalla(navController: NavController?, code : Int) {

    val viewModel : ViewModelRetrofit = viewModel()
    val carList by viewModel.carList.collectAsState()
    val estate by viewModel.estadoLlamada.collectAsState()

    Scaffold(
        topBar = { TopAppBar(
            colors = TopAppBarDefaults
                .centerAlignedTopAppBarColors(
                    containerColor = Color(179,  27,  27),
                    titleContentColor = Color.Black),
            title = {
                Text(text = "APPRetrofitAPI", modifier = Modifier.fillMaxWidth(),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 24.sp)
            })
        }) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(5.dp, top = 70.dp)
                .fillMaxSize()
        ) {
            Text(text = "ACTUALIZACIÓN DE COCHE", modifier = Modifier.padding(top = 20.dp))

            TextField(
                value = "",
                onValueChange = {},
                label = { Text("Marca") },
                modifier = Modifier.padding(8.dp)
            )

            TextField(
                value = "",
                onValueChange = {},
                label = { Text("Modelo") },
                modifier = Modifier.padding(8.dp)
            )
            TextField(
                value = "",
                onValueChange = {},
                label = { Text("Imagén del modelo") },
                modifier = Modifier.padding(8.dp)
            )
            Row {

                Button(
                    content = { Text(text = "UPDATE CAR") },
                    colors = ButtonDefaults.buttonColors(Color(105,105,105)),
                    onClick = {/*Actualizar COCHE*/navController?.navigate(Rutas.PantallaPrincipal.ruta)},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .weight(1f)
                )
                Button(
                    content = { Text(text = "DELETE CAR") },
                    colors = ButtonDefaults.buttonColors(Color(179,  27,  27)),
                    onClick = {
                        viewModel.deleteModel(code)
                        navController?.navigate(Rutas.PantallaPrincipal.ruta)},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .weight(1f)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaPreview() {
    SpringRetrofitTheme {
        //ActualizarPantalla(navController = null, 0)
    }
}*/