package com.example.springretrofit.ui.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.springretrofit.ui.primerapantalla.PrimeraPantalla
import com.example.springretrofit.ui.ruta.Rutas

@Composable
fun GrafoDeNavegacion() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.PantallaPrincipal.ruta) {

        composable(Rutas.PantallaPrincipal.ruta) {
            PrimeraPantalla()
        }

        composable(Rutas.ActualizarPantalla.ruta + "/{code}") {
                /*llamada ->
            val code = llamada.arguments?.getInt("code")
            code?.let { ActualizarPantalla(navController = navController, code =  it) }*/
        }

        composable(Rutas.CrearPantalla.ruta) {
            //CrearPantalla(navController = navController)
        }
    }

}