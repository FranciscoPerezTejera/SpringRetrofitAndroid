package com.example.springretrofit.repositorio

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.springretrofit.data.CarService
import com.example.springretrofit.model.Car
import com.example.springretrofit.model.Model
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

enum class estadoApi{
    IDLE, LOADING, SUCCESS, ERROR
}

class ViewModelRetrofit : ViewModel() {

    private val _carList : MutableStateFlow<List<Model>?> = MutableStateFlow(null)
    var carList = _carList.asStateFlow()

    private val _estadoLlamada : MutableStateFlow<estadoApi> = MutableStateFlow(estadoApi.IDLE)
    var estadoLlamada = _estadoLlamada.asStateFlow()

    private val _car : MutableStateFlow<Car?> = MutableStateFlow(null)
    val car = _car.asStateFlow()

    init {
        getAllModel()
    }

    fun getAllModel() {
        _estadoLlamada.value = estadoApi.LOADING
        viewModelScope.launch {
            var service = CarService.RetrofitServiceFactory.makeRetrofitService()
            var response = service.getAll()

            if (response.isSuccessful) {
                _carList.value = response.body()
                _estadoLlamada.value = estadoApi.SUCCESS

            } else {
                Log.e("Error de informacion", response.message())
            }
        }
    }

    fun addCar(model : Model) {
        _estadoLlamada.value = estadoApi.LOADING
        viewModelScope.launch {
            try {
                var service = CarService.RetrofitServiceFactory.makeRetrofitService()
                var response = service.createCar(model)

                if (response.isSuccessful) {
                    getAllModel()
                    _estadoLlamada.value = estadoApi.SUCCESS
                } else {
                    Log.d("Error al crear Coche: ", response.errorBody().toString())
                    _estadoLlamada.value = estadoApi.ERROR
                }

            } catch(e: Exception) {

            }
        }
    }

    /*fun deleteCar(code : Int) {
        _estadoLlamada.value = estadoApi.LOADING
        viewModelScope.launch {
            try {
                var service = CarService.RetrofitServiceFactory.makeRetrofitService()
                var response = service.deleteModel(code)

                if (response.isSuccessful) {
                    getAllModel()
                    Log.d("Se elimino el coche con exito: ", response.errorBody().toString())
                    _estadoLlamada.value = estadoApi.SUCCESS
                } else {
                    Log.d("Error al borrar Coche: ", response.errorBody().toString())
                    _estadoLlamada.value = estadoApi.ERROR
                }

            } catch (e: Exception) {
                Log.d("Error al borrar Coche: ", e.message.toString())
                _estadoLlamada.value = estadoApi.ERROR
            }
        }
    }*/

    fun deleteModel(id : Int) {
        _estadoLlamada.value = estadoApi.LOADING
        viewModelScope.launch {
            try {
                var service = CarService.RetrofitServiceFactory.makeRetrofitService()
                var response = service.deleteModel(id)

                if (response.isSuccessful) {
                    getAllModel()
                    Log.d("Se elimino el coche con exito: ", response.errorBody().toString())
                    _estadoLlamada.value = estadoApi.SUCCESS
                } else {
                    Log.d("Error al borrar Coche: ", response.errorBody().toString())
                    _estadoLlamada.value = estadoApi.ERROR
                }

            } catch (e: Exception) {
                Log.d("Error al borrar Coche: ", e.message.toString())
                _estadoLlamada.value = estadoApi.ERROR
            }
        }
    }

    fun updateCar(code : Int, model: Model) {
        _estadoLlamada.value = estadoApi.LOADING
        viewModelScope.launch {
            try {
                var service = CarService.RetrofitServiceFactory.makeRetrofitService()
                var response = service.updateCar(code, model)

                if (response.isSuccessful) {
                    getAllModel()
                    Log.d("Se actualizçó el coche con exito: ", response.message())
                    _estadoLlamada.value = estadoApi.SUCCESS
                } else {
                    Log.d("Error al actualizar el coche: ", response.errorBody().toString())
                    _estadoLlamada.value = estadoApi.ERROR
                }

            } catch (e: Exception) {
                Log.d("Error al actualizar un coche: ", e.message.toString())
                _estadoLlamada.value = estadoApi.ERROR
            }
        }
    }



    fun getImageFromModel(car: Car) : String? {
        var list = car.models
        return list[0].imageModel
    }

    fun getInformationText(car : Car): String? {
        var list = car.models
        return list.get(0).model
    }

}