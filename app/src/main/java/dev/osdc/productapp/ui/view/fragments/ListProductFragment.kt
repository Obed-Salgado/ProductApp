package dev.osdc.productapp.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.osdc.productapp.R
import dev.osdc.productapp.databinding.FragmentListProductBinding
import dev.osdc.productapp.ui.view.adapters.ProductAdapter
import dev.osdc.productapp.ui.viewmodel.ProductViewModel
import dev.osdc.productapp.utils.toast

@AndroidEntryPoint
class ListProductFragment : Fragment() {

    private val viewModel: ProductViewModel by viewModels()
    private var _binding : FragmentListProductBinding? = null
    private val binding get() = _binding!!
    private val adapter = ProductAdapter(
        onDelete = {
            viewModel.deleteProduct(it)
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        viewModel.getProducts()

        viewModel.products.observe(viewLifecycleOwner){ products ->
            adapter.setProducts(products)
            if(products.isEmpty())
                binding.infoLayout.visibility = View.VISIBLE
            else
                binding.infoLayout.visibility = View.INVISIBLE
        }

        viewModel.success.observe(viewLifecycleOwner){
            if(it) {
                toast("Producto eliminado")
                viewModel.getProducts()
            }
        }

        binding.fbAddProduct.setOnClickListener {
            findNavController().navigate(R.id.action_listProductFragment_to_addProductFragment)
        }
    }

    private fun initRecyclerView(){
        val manager = LinearLayoutManager(requireContext())
        binding.rvProducts.layoutManager = manager
        binding.rvProducts.adapter = adapter
    }
}