package com.example.springretrofit.ui.primerapantalla


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.springretrofit.model.Model
import com.example.springretrofit.repositorio.ViewModelRetrofit
import com.example.springretrofit.repositorio.estadoApi
import com.example.springretrofit.ui.theme.SpringRetrofitTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimeraPantalla() {

    val viewModel: ViewModelRetrofit = viewModel()
    val carList by viewModel.carList.collectAsState()
    val estate by viewModel.estadoLlamada.collectAsState()

    var openDialogCrearCoche by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults
                    .centerAlignedTopAppBarColors(
                        containerColor = Color(179, 27, 27),
                        titleContentColor = Color.Black
                    ),
                title = {
                    Text(
                        text = "APPRetrofitAPI", modifier = Modifier.fillMaxWidth(),
                        fontFamily = FontFamily.Monospace,
                        fontSize = 24.sp
                    )
                })
        },
        floatingActionButton = {
            Column {
                FloatingActionButton(
                    containerColor = Color(179, 27, 27),
                    modifier = Modifier
                        .padding(7.dp)
                        .width(80.dp)
                        .height(80.dp),
                    onClick = {
                        openDialogCrearCoche = true
                    }) {
                    Icon(Icons.TwoTone.Add, "")
                }
            }
        }) {
        if (estate == estadoApi.LOADING) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "LOANDING...")
            }

        } else {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(5.dp, top = 70.dp)
            )
            {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {

                    items(carList!!) { model ->
                        CarItem(model = model, viewModel)
                        Log.d("MODELOS DE COCHE", model.toString())
                    }
                }
                if (openDialogCrearCoche) {
                    addDialog(viewModel = viewModel) {
                        openDialogCrearCoche = false
                    }

                }
            }
        }
    }
}

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CarItem(model: Model?, viewModel: ViewModelRetrofit) {

        var openDialog by remember { mutableStateOf(false) }

        if (openDialog) {
            updateDialog(model = model, viewModel = viewModel) {
                openDialog = false
            }

        }

        Card(
            onClick = { openDialog = true },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(Color(105, 105, 105))
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(8.dp)
            ) {

                AsyncImage(
                    model = model!!.imageModel, contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .fillMaxWidth()
                        .weight(1f)
                )

                Column(verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(3.dp)
                        .weight(1f)) {
                    if (model.getCar() == null) {
                        //Text(text = "Marca: " + model.getCar().brand) Me devuelve un null
                        Text(text = "Marca del coche", fontSize = 20.sp)
                    }

                    Text(text = "Modelo: " + model.getModel(), fontSize = 20.sp)
                    Text(text = " CODE: " + model.getCode(), fontSize = 20.sp)

                }
            }
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun updateDialog(model: Model?, viewModel: ViewModelRetrofit, onCloseDialog: () -> Unit) {

    var nombreModel by remember { mutableStateOf(model?.getModel()) }
    var imagenModel by remember { mutableStateOf(model?.getImageModel()) }

    AlertDialog(
        onDismissRequest = {
            onCloseDialog()
        },
        title = {
            Text(text = "UPDATE/DELETE")
        },
        text = {
            Column {
                Text("Puedes modificar lo siguiente")

                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = nombreModel!!,
                    onValueChange = { nombreModel = it },
                    label = { Text("Cambiar modelo") }
                )
                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = imagenModel!!,
                    onValueChange = { imagenModel = it },
                    label = { Text("Cambiar imagen") }
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    model?.setModel(nombreModel)
                    model?.setImageModel(imagenModel)

                viewModel.updateCar(model!!.getCode(),model)

                    onCloseDialog()

                }) {
                Text("UPDATE")
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    viewModel.deleteModel(model!!.getId())
                    onCloseDialog()

                }) {
                Text("DELETE")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun addDialog(viewModel: ViewModelRetrofit, onCloseDialog: () -> Unit) {

    var nombreModel by remember { mutableStateOf("") }
    var imagenModel by remember { mutableStateOf("") }
    var a = Model(nombreModel, imagenModel)

    AlertDialog(
        onDismissRequest = {
            onCloseDialog()

        },
        title = {
            Text(text = "ADD MODELO")
        },
        text = {
            Column {
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = nombreModel,
                    onValueChange = { nombreModel = it },
                    label = { Text("nuevo Modelo") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = imagenModel,
                    onValueChange = { imagenModel = it },
                    label = { Text("nueva imagen de Modelo") }
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    a.setModel(nombreModel)
                    a.setImageModel(imagenModel)
                    viewModel.addCar(a)
                    onCloseDialog()
                }) {
                Text("ADD")
            }
        },
        dismissButton = {
            Button(
                onClick = {

                    onCloseDialog()

                }) {
                Text("EXIT")
            }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaPreview() {
    SpringRetrofitTheme {
        PrimeraPantalla()
    }
}