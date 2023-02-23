package com.fdez.conexionapilocal

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface Api {
    //devolvemos la lista de productos
    @GET("/api-rest/productos")
    suspend fun getProductos(): List<Producto>

}