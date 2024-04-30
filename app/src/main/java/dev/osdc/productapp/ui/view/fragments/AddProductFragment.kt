package dev.osdc.productapp.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import dev.osdc.productapp.data.model.Product
import dev.osdc.productapp.databinding.FragmentAddProductBinding
import dev.osdc.productapp.ui.viewmodel.ProductViewModel
import dev.osdc.productapp.utils.isNotEmpty
import dev.osdc.productapp.utils.toast

@AndroidEntryPoint
class AddProductFragment : Fragment() {

    private val viewModel: ProductViewModel by viewModels()
    private var _binding : FragmentAddProductBinding? = null
    private val binding get() = _binding!!
    private val args: AddProductFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args.id?.let { id ->
            if (id.isNotEmpty())
                viewModel.getProductById(id)
        }

        binding.btnAddProduct.setOnClickListener{
            try {
                val name = binding.etName.text.toString()
                val description = binding.etDescription.text.toString()
                val price = binding.etPrice.text.toString()
                val image = binding.etImage.text.toString()

                if (name.isNotEmpty() && description.isNotEmpty()
                    && image.isNotEmpty() && price.isNotEmpty()
                ) {
                    val product = Product(
                        name = name,
                        description = description,
                        price = price.toDouble(),
                        image = image
                    )

                    if(args.id?.isEmpty()!!)
                        viewModel.insertProduct(product)
                    else {
                        viewModel.updateProduct(product, args.id!!)
                    }
                } else {
                    toast("Faltan datos")
                }
            } catch (_: Exception){ }
        }

        viewModel.product.observe(viewLifecycleOwner){ product ->
            setValues(product)

            if (product.isNotEmpty() && args.id?.isEmpty()!!) {
                toast("${product.name} se ha guardado")
                clearValues()
                binding.etName.requestFocus()
            }
        }

        viewModel.success.observe(viewLifecycleOwner){
            if(it) {
                toast("Producto actualizado")
                clearValues()
                binding.etName.requestFocus()
            }
        }
    }

    private fun setValues(product: Product){
        binding.etName.setText(product.name)
        binding.etDescription.setText(product.description)
        binding.etPrice.setText(product.price.toString())
        binding.etImage.setText(product.image)
    }

    private fun clearValues(){
        binding.etName.setText("")
        binding.etDescription.setText("")
        binding.etPrice.setText("")
        binding.etImage.setText("")
    }
}