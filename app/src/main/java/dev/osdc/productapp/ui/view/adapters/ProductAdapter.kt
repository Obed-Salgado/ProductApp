package dev.osdc.productapp.ui.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.osdc.productapp.R
import dev.osdc.productapp.data.model.Product
import dev.osdc.productapp.databinding.ItemProductBinding

class ProductAdapter(
    private val onDelete: (String) ->Unit,
    ): RecyclerView.Adapter<ProductViewHolder>() {

    private var products = emptyList<Product>()

    fun setProducts(products: List<Product>){
        this.products = products
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_product, parent, false)
        val binding = ItemProductBinding.bind(view)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.render(products[position], onDelete)
    }

    override fun getItemCount(): Int = products.size
}