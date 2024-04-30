package dev.osdc.productapp.data.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("_id") val id: String? = null,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("price") val price: Double,
    @SerializedName("image") val image: String
)
