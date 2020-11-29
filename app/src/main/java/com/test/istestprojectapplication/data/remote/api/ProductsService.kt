package com.test.istestprojectapplication.data.remote.api

import com.test.istestprojectapplication.data.remote.model.ProductListResponse
import io.reactivex.Observable
import retrofit2.http.POST

interface ProductsService {

    @POST("/app/item-list")
    fun getProducts(): Observable<ProductListResponse>
}