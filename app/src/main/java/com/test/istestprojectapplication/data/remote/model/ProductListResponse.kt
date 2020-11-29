package com.test.istestprojectapplication.data.remote.model

import com.test.istestprojectapplication.model.Product
import com.google.gson.annotations.SerializedName

data class ProductListResponse(@SerializedName("itemList") val products : List<Product>) : BaseResponse()