package dev.osdc.productapp.ui.view.adapters

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import dev.osdc.productapp.data.model.Product
import dev.osdc.productapp.databinding.ItemProductBinding
import dev.osdc.productapp.ui.view.fragments.ListProductFragmentDirections
import dev.osdc.productapp.utils.load

class ProductViewHolder(private val binding: ItemProductBinding): RecyclerView.ViewHolder(binding.root) {

    fun render(product: Product, onDelete: (String)-> Unit){
        binding.tvName.text = product.name
        binding.tvDescription.text = product.description
        binding.tvPrice.text = product.price.toString()
        binding.ivIcon.load(product.image)

        binding.root.rootView.setOnClickListener {
            binding.root.findNavController().
            navigate(ListProductFragmentDirections.actionListProductFragmentToAddProductFragment(product.id))
        }

        binding.ivDelete.setOnClickListener {
            onDelete(product.id!!)
        }
    }
}
