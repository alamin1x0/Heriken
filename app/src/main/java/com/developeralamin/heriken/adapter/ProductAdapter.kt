package com.developeralamin.heriken.adaper

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.developeralamin.heriken.databinding.LayoutProductItemBinding
import com.developeralamin.heriken.model.AddProductModel

class ProductAdapter(val context: Context, val list: ArrayList<AddProductModel>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: LayoutProductItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding =
            LayoutProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val data = list[position]

        holder.binding.textView3.text = data.productName
        holder.binding.textView4.text = data.productMrp
        holder.binding.textView5.text = data.productSp
        Glide.with(context).load(data.productImages).into(holder.binding.imageView2)

        holder.binding.addBtn.setOnClickListener {
            Toast.makeText(context, "Product Added", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}