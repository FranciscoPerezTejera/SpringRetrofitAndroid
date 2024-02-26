package com.example.springretrofit.ui.crearPantalla
/*
import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.springretrofit.model.Car
import com.example.springretrofit.model.Model
import com.example.springretrofit.repositorio.ViewModelRetrofit
import com.example.springretrofit.repositorio.estadoApi
import com.example.springretrofit.ui.ruta.Rutas
import com.example.springretrofit.ui.theme.SpringRetrofitTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CrearPantalla(navController: NavController?) {

    val viewModel : ViewModelRetrofit = viewModel()
    val carList by viewModel.carList.collectAsState()
    val estate by viewModel.estadoLlamada.collectAsState()

    var context = LocalContext.current

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
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(5.dp, top = 70.dp)
                .fillMaxSize()
        ) {
            Text(text = "CREACIÓN DE COCHE", modifier = Modifier.padding(top = 20.dp))

            TextField(
                value = carCode,
                onValueChange = {carCode = it},
                label = { Text(" Código coche") },
                modifier = Modifier.padding(8.dp, top = 5.dp)
            )
            TextField(
                value = carBrand,
                onValueChange = {carBrand = it},
                label = { Text("Marca") },
                modifier = Modifier.padding(8.dp)
            )
            TextField(
                value = modelCode,
                onValueChange = {modelCode = it},
                label = { Text("Código modelo") },
                modifier = Modifier.padding(8.dp)
            )
            TextField(
                value = modelModel,
                onValueChange = {modelModel = it},
                label = { Text("Modelo") },
                modifier = Modifier.padding(8.dp)
            )
            TextField(
                value = modelImage,
                onValueChange = {modelImage = it},
                label = { Text("Imagén del modelo") },
                modifier = Modifier.padding(8.dp)
            )
            Button(
                content = { Text(text = "ADD CAR")},
                colors = ButtonDefaults.buttonColors(Color(144, 238, 144)),
                onClick = {

                    a?.setModel(nombreModel)
                    a?.setImageModel(imagenModel)

                    viewModel.addCar(model!!)

                    if (viewModel.estadoLlamada.value != estadoApi.ERROR) {
                        val toast = Toast.makeText(context, "Usuario creadp con exito", Toast.LENGTH_SHORT)
                        toast.show()
                    } else {
                        val toast = Toast.makeText(context, "No se pudo crear el usuario", Toast.LENGTH_SHORT)
                        toast.show()
                    }

                    navController?.navigate(Rutas.PantallaPrincipal.ruta)},
                modifier = Modifier
                    .height(60.dp)
                    .width(200.dp)
                    .padding(10.dp),
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaPreview() {
    SpringRetrofitTheme {
        CrearPantalla(navController = null)
    }
}
*/