package dev.osdc.productapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.osdc.productapp.data.model.Product
import dev.osdc.productapp.domain.DeleteProductUseCase
import dev.osdc.productapp.domain.GetProductByIdUseCase
import dev.osdc.productapp.domain.GetProductsUseCase
import dev.osdc.productapp.domain.InsertProductUseCase
import dev.osdc.productapp.domain.UpdateProductUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val getProductByIdUseCase: GetProductByIdUseCase,
    private val insertProductUseCase: InsertProductUseCase,
    private val updateProductUseCase: UpdateProductUseCase,
    private val deleteProductUseCase: DeleteProductUseCase) : ViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product> = _product

    private val _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> = _success

    fun getProducts(){
        viewModelScope.launch {
            val result = getProductsUseCase()
            _products.value = result
        }
    }

    fun getProductById(id: String){
        viewModelScope.launch {
            val result = getProductByIdUseCase(id)
            this@ProductViewModel._product.value = result
        }
    }

    fun insertProduct(product: Product){
        viewModelScope.launch {
            val result = insertProductUseCase(product)
            this@ProductViewModel._product.value = result
        }
    }

    fun updateProduct(product: Product, id: String){
        viewModelScope.launch {
            updateProductUseCase(product, id)
            _success.value = true
        }
    }

    fun deleteProduct(id: String){
        viewModelScope.launch {
            deleteProductUseCase(id)
            _success.value = true
        }
    }
}