package com.developeralamin.heriken.model


data class NewProductModel(
    val productName: String? = "",
    val productDescription: String? = "",
    val productCoverImg: String? = "",
    val productCategoryImg: String? = "",
    val productId: String? = "",
    val productMrp: String? = "",
    val productSp: String? = "",
    val productImages: String?="",
    val price: String?="",
)
