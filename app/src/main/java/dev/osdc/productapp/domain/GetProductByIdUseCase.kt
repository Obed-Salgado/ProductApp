package dev.osdc.productapp.domain

import dev.osdc.productapp.data.ProductRepository
import javax.inject.Inject

class GetProductByIdUseCase @Inject constructor(private val repository: ProductRepository) {
    suspend operator fun invoke(id: String) = repository.getProductById(id)
}