package com.example.lobstersale.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lobstersale.R
import com.example.lobstersale.models.Product

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val productName: TextView = itemView.findViewById(R.id.product_name)
    private val productPrice: TextView = itemView.findViewById(R.id.product_price)

    fun bind(product: Product) {
        productName.text = product.name
        productPrice.text = "Rp ${product.price}"
    }
}
