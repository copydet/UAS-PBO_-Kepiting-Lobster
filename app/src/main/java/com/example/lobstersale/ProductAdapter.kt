package com.example.lobstersale.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.lobstersale.R
import com.example.lobstersale.models.Product

class ProductAdapter(
    private val products: List<Product>,
    private val onOrderClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
        holder.itemView.findViewById<Button>(R.id.order_button).setOnClickListener {
            onOrderClick(product)
        }
    }

    override fun getItemCount(): Int = products.size
}
