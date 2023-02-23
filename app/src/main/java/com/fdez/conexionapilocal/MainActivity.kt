package com.fdez.conexionapilocal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fdez.conexionapilocal.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductosAdapter
    private lateinit var api: Api

    private lateinit var bind : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        val view = bind.root
        setContentView(view)

        recyclerView = bind.rcv
        //establecemos el layoutManager en el recyclerview
        recyclerView.layoutManager = LinearLayoutManager(this)
        //creamos una instancia de retrofir para que se comunique con un servidor
        // en el emulador de android
        val retrofit = Retrofit.Builder()
                //se reemplaza el localHost por 10.0.2.2
            .baseUrl("http://10.0.2.2:8000")// colocamos el alias especial de la interfaz host de bucle invertido
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //utilizamos la instancia que se uriliza para crear la solicitud
        api = retrofit.create(Api::class.java)
        //lanzamos una tarea asincrona para obtener la lista de productos
        GlobalScope.launch(Dispatchers.Main) {
            val productos = api.getProductos()
            adapter = ProductosAdapter(productos)
            recyclerView.adapter = adapter
        }
    }
}