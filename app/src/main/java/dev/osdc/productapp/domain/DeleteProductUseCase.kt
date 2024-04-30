package dev.osdc.productapp.domain

import dev.osdc.productapp.data.ProductRepository
import javax.inject.Inject

class DeleteProductUseCase @Inject constructor(private val repository: ProductRepository) {
    suspend operator fun invoke(id: String) { repository.deleteProduct(id) }
}