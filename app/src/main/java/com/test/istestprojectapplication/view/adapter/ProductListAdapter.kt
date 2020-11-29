package com.test.istestprojectapplication.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.istestprojectapplication.model.Product
import com.test.istestprojectapplication.R
import kotlinx.android.synthetic.main.product_item.view.*

class ProductListAdapter(private var products : List<Product>) :
    RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) = holder.bind(products.get(position))

    override fun getItemCount(): Int = products.size


    class ProductViewHolder(private val view : View) : RecyclerView.ViewHolder(view) {
       fun bind(product : Product) {
           with(view) {
               name.text = product.name
               description.text = product.description
               price.text = "Price:"+product.price
           }
       }
    }


    fun setData(_products: List<Product>) {
        products = _products
        notifyDataSetChanged()
    }
}