package dev.osdc.productapp.data

import dev.osdc.productapp.data.model.Product
import dev.osdc.productapp.data.network.ApiService
import javax.inject.Inject

class ProductRepository @Inject constructor(private val api: ApiService) {

    suspend fun getAllProducts(): List<Product>{
        return api.getProducts()
    }

    suspend fun getProductById(id: String): Product{
        return api.getProductById(id)
    }

    suspend fun insertProduct(product: Product): Product{
        return api.insertProduct(product)
    }

    suspend fun updateProduct(product: Product, id: String){
        api.updateProduct(product, id)
    }

    suspend fun deleteProduct(id: String){
        api.deleteProduct(id)
    }
}