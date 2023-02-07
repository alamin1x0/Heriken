package com.developeralamin.heriken.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.developeralamin.heriken.R
import com.developeralamin.heriken.adaper.BranceItemAdapter
import com.developeralamin.heriken.adaper.NewItemAdapter
import com.developeralamin.heriken.adaper.ProductAdapter
import com.developeralamin.heriken.adaper.ShopByItemAdapter
import com.developeralamin.heriken.databinding.FragmentHomeBinding
import com.developeralamin.heriken.model.AddProductModel
import com.developeralamin.heriken.model.BranceModel
import com.developeralamin.heriken.model.NewProductModel
import com.developeralamin.heriken.model.ShopbyModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)


        CoroutineScope(Dispatchers.Main).launch {
            while (true) {
                dateTimeUpdate();
                delay(1000L)
            }
        }


        val imageList = ArrayList<SlideModel>()
        imageList.add(
            SlideModel(
                "https://api.heriken.co/api/upload/images/hhhhhhh-33e4.png",
                ScaleTypes.CENTER_CROP
            )
        )
        imageList.add(
            SlideModel(
                "https://api.heriken.co/api/upload/images/hhhhhhh-33e4.png",
                ScaleTypes.CENTER_CROP
            )
        )
        binding.imageSlider.setImageList(imageList)

        getProductes()

        getNewItems()

        getShopItems()

        getBranceItems()

        referesApp()

        return binding.root
    }

    private fun referesApp() {
        binding.swipeRefresLayout.setOnRefreshListener {

            binding.swipeRefresLayout.isRefreshing = false
        }
    }

    private fun getBranceItems() {

        val list = ArrayList<BranceModel>()
        Firebase.firestore.collection("brance")
            .get().addOnSuccessListener {
                list.clear()
                for (doc in it.documents) {
                    val data = doc.toObject(BranceModel::class.java)
                    list.add(data!!)
                }

                binding.shopbyBranchRecyclerview.adapter = BranceItemAdapter(requireContext(), list)

            }
    }

    private fun getShopItems() {
        val list = ArrayList<ShopbyModel>()
        Firebase.firestore.collection("shopimage")
            .get().addOnSuccessListener {
                list.clear()
                for (doc in it.documents) {
                    val data = doc.toObject(ShopbyModel::class.java)
                    list.add(data!!)
                }

                binding.shopByCategoryRecyclerview.adapter =
                    ShopByItemAdapter(requireContext(), list)

            }
    }

    private fun getNewItems() {
        val list = ArrayList<NewProductModel>()
        Firebase.firestore.collection("newitem")
            .get().addOnSuccessListener {
                list.clear()
                for (doc in it.documents) {
                    val data = doc.toObject(NewProductModel::class.java)
                    list.add(data!!)
                }

                binding.collectionRecyclerview.adapter = NewItemAdapter(requireContext(), list)

            }
    }

    private fun getProductes() {
        val list = ArrayList<AddProductModel>()
        Firebase.firestore.collection("product")
            .get().addOnSuccessListener {
                list.clear()
                for (doc in it.documents) {
                    val data = doc.toObject(AddProductModel::class.java)
                    list.add(data!!)
                }

                binding.productRecyclerview.adapter = ProductAdapter(requireContext(), list)
                binding.progressBarId.visibility = GONE

            }
    }

    private fun dateTimeUpdate() {

        val currentDate: String =
            SimpleDateFormat("HH : mm : ss", Locale.getDefault()).format(Date())
        binding.datetime.setText(currentDate)

    }
}