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
import com.developeralamin.heriken.databinding.ShopbybrancItemLayoutBinding
import com.developeralamin.heriken.databinding.ShopbycategoryBinding
import com.developeralamin.heriken.model.AddProductModel
import com.developeralamin.heriken.model.BranceModel
import com.developeralamin.heriken.model.NewProductModel
import com.developeralamin.heriken.model.ShopbyModel

class BranceItemAdapter(val context: Context, val list: ArrayList<BranceModel>) :
    RecyclerView.Adapter<BranceItemAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: ShopbybrancItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding =
            ShopbybrancItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val data = list[position]

        holder.binding.textView.text = data.name
        Glide.with(context).load(data.image).into(holder.binding.profileImage)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}