package com.example.lobstersale.models

abstract class Product(val name: String, val price: Int) {
    abstract fun getProductType(): String
}
