package com.developeralamin.heriken.adaper

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.developeralamin.heriken.databinding.LayoutProductItemBinding
import com.developeralamin.heriken.databinding.NewProductsBinding
import com.developeralamin.heriken.model.AddProductModel
import com.developeralamin.heriken.model.NewProductModel

class NewItemAdapter(val context: Context, val list: ArrayList<NewProductModel>) :
    RecyclerView.Adapter<NewItemAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: NewProductsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding =
            NewProductsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val data = list[position]

        holder.binding.newProductName.text = data.productName
        holder.binding.newPrice.text = data.price
        Glide.with(context).load(data.productImages).into(holder.binding.newImg)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}