package com.example.springretrofit.ui.ruta

sealed class Rutas (val ruta : String) {
    object PantallaPrincipal : Rutas("pantallaprincipal")
    object ActualizarPantalla : Rutas("actualizarpantalla")
    object CrearPantalla : Rutas("crearpantalla")
}

