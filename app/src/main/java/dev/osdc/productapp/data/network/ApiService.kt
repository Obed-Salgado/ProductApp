package dev.osdc.productapp.data.network

import dev.osdc.productapp.data.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiService @Inject constructor(private val apiClient: ApiClient) {

    suspend fun getProducts(): List<Product> {
        return withContext(Dispatchers.IO){
            val response = apiClient.getAllProducts()
            if(response.isSuccessful){
                return@withContext response.body() ?: emptyList<Product>()
            }else{
                return@withContext emptyList<Product>()
            }
        }
    }

    suspend fun getProductById(id: String): Product{
        return withContext(Dispatchers.IO){
            val response = apiClient.getProductById(id)
            if(response.isSuccessful){
                return@withContext response.body() ?: Product("", "", "",0.0, "")
            }else{
                return@withContext Product("", "", "",0.0, "")
            }
        }
    }

    suspend fun insertProduct(product: Product): Product{
        return withContext(Dispatchers.IO){
            val response = apiClient.insertProduct(product)
            if(response.isSuccessful){
                return@withContext response.body() ?: Product("", "", "",0.0, "")
            }else{
                return@withContext Product("", "", "",0.0, "")
            }
        }
    }

    suspend fun updateProduct(product: Product, id: String) {
        return withContext(Dispatchers.IO){
            apiClient.updateProduct(id, product)
        }
    }

    suspend fun deleteProduct(id: String) {
        return withContext(Dispatchers.IO){
            apiClient.deleteProduct(id)
        }
    }
}