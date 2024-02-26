package com.example.springretrofit.data

import com.example.springretrofit.model.Model
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

private const val URL = "http://192.168.1.34:8080/"

interface CarService {

    @GET("api/v1/model")
    @Headers("Accept: application/json")
    suspend fun getAll() : Response<List<Model>>

    @GET("api/v1/model/code{code}")
    @Headers("Accept: application/json")
    suspend fun getByCode(@Path("code") code: Int) : Response<Model>

    @POST("api/v1/model")
    suspend fun createCar(@Body model: Model) : Response<Void>

    /*@DELETE("api/v1/model{code}")
    suspend fun deleteCar(@Path("code") code : Int): Response<Void>*/

    @DELETE("api/v1/model/delete/{id}")
    suspend fun deleteModel(@Path("id") id : Int): Response<Void>

    @PUT("api/v1/model{code}")
    suspend fun updateCar(@Path("code") code: Int, @Body model: Model): Response<Void>

    object RetrofitServiceFactory {
        fun makeRetrofitService() : CarService {
            return Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CarService::class.java)
        }
    }
}