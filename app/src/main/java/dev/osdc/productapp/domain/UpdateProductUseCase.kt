package dev.osdc.productapp.domain

import dev.osdc.productapp.data.ProductRepository
import dev.osdc.productapp.data.model.Product
import javax.inject.Inject

class UpdateProductUseCase @Inject constructor(private val repository: ProductRepository) {
    suspend operator fun invoke(product: Product, id: String) { repository.updateProduct(product, id) }
}