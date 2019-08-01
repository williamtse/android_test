package com.example.bottomnavigationtest.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavigationtest.Adapter.ProductAdapter
import com.example.bottomnavigationtest.Model.Product
import com.example.bottomnavigationtest.R
import com.example.bottomnavigationtest.Service.DataService
import com.example.bottomnavigationtest.ui.product.ProductInfoActivity
import com.leonbec.coderswag.Utility.EXTRA_CATEGORY
import com.leonbec.coderswag.Utility.EXTRA_PRODUCT

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val productRV:RecyclerView = root.findViewById(R.id.listView1)

        var spanCount = 2
        if (resources.configuration.screenWidthDp > 650)
            spanCount = 3

        val plist:List<Product> = DataService.getProducts("SHIRTS")

        val layoutManager = GridLayoutManager(activity, spanCount)
        adapter = ProductAdapter(this.requireContext(), plist) { product ->
            val intent = Intent(activity, ProductInfoActivity::class.java)
            intent.putExtra(EXTRA_PRODUCT, product)
            startActivity(intent)
        }

        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })
        productRV.adapter = adapter
        productRV.layoutManager = layoutManager
        return root
    }
}