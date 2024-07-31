package com.example.lobstersale

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lobstersale.adapters.ProductAdapter
import com.example.lobstersale.models.Crab
import com.example.lobstersale.models.Lobster
import com.example.lobstersale.models.Product

class HomeActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val productList = listOf<Product>(
            Lobster("Lobster Biru", 25000),
            Crab("Kepiting Biru", 20000),
            Crab("Kepiting Bakau", 15000),
            Crab("Kepiting Merah", 22000),
            Lobster("Lobster Air Tawar", 12000),
            Lobster("Lobster Merah", 30000),
            Lobster("Lobster Mutiara", 50000),
        )

        productAdapter = ProductAdapter(productList) { product ->
            val intent = Intent(this, ChatActivity::class.java).apply {
                putExtra("product_name", product.name)
            }
            startActivity(intent)
        }

        recyclerView.adapter = productAdapter

        findViewById<Button>(R.id.profile_button).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
        findViewById<Button>(R.id.chat_button).setOnClickListener {
            startActivity(Intent(this, ChatActivity::class.java))
        }
    }
}
