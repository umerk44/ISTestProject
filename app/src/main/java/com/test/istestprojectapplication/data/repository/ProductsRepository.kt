package com.test.istestprojectapplication.data.repository


import com.test.istestprojectapplication.data.remote.api.ProductsService
import com.test.istestprojectapplication.data.remote.model.ProductListResponse
import io.reactivex.Observable

class ProductsRepository(private val productsService: ProductsService) {

    fun getProducts() : Observable<ProductListResponse> {
        return productsService.getProducts()
    }

}