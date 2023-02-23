package com.fdez.conexionapilocal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fdez.conexionapilocal.databinding.ItemProductoBinding

class ProductosAdapter (private val productos: List<Producto>) : RecyclerView.Adapter<ProductoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view = ItemProductoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = productos[position]
        holder.bind(producto)
    }

    override fun getItemCount() = productos.size
}
class ProductoViewHolder(private val itemProductoBinding: ItemProductoBinding) : RecyclerView.ViewHolder(itemProductoBinding.root) {

    fun bind(producto: Producto) {
        itemProductoBinding.tvNombre.text = producto.nombre
        itemProductoBinding.tvDescripcion.text = producto.descripcion
        itemProductoBinding.tvPrecio.text = producto.precio.toString()

    }
}