package com.example.lobstersale.models

class Lobster(name: String, price: Int) : Product(name, price) {
    override fun getProductType(): String {
        return "Lobster"
    }
}
