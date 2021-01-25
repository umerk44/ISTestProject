package com.test.istestprojectapplication.data.repository


import com.test.istestprojectapplication.data.local.dao.ProductDao
import com.test.istestprojectapplication.data.remote.api.ProductsService
import com.test.istestprojectapplication.data.remote.model.ProductListResponse
import com.test.istestprojectapplication.model.Product
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class ProductsRepository @Inject constructor (private val productsService: ProductsService,
                         private val productDao: ProductDao) {

    fun getProducts() : Observable<ProductListResponse> {
        return productsService.getProducts()
    }

    fun getProductsFromDb() : Single<List<Product>> {
        return productDao.getAllProducts()
    }

    fun saveAllProducts(products : List<Product>) : Completable {
        return productDao.insertProducts(products)
    }

}