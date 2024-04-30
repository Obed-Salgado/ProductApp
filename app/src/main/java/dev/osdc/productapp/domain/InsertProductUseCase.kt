package dev.osdc.productapp.domain

import dev.osdc.productapp.data.ProductRepository
import dev.osdc.productapp.data.model.Product
import javax.inject.Inject

class InsertProductUseCase @Inject constructor(private val repository: ProductRepository) {
    suspend operator fun invoke(product: Product) = repository.insertProduct(product)
}