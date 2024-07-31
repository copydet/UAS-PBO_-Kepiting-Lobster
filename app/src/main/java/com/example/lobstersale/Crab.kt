package com.example.lobstersale.models

class Crab(name: String, price: Int) : Product(name, price) {
    override fun getProductType(): String {
        return "Kepiting"
    }
}
