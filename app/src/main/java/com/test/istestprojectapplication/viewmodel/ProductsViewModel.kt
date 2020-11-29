package com.test.istestprojectapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.istestprojectapplication.core.RemoteCallState
import com.test.istestprojectapplication.data.remote.model.ProductListResponse
import com.test.istestprojectapplication.data.repository.ProductsRepository
import com.test.istestprojectapplication.model.Product
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ProductsViewModel(private val productsRepository: ProductsRepository) : BaseViewModel() {

    private val products = MutableLiveData<RemoteCallState<ProductListResponse>>()
    val productsView : LiveData<RemoteCallState<ProductListResponse>>
    get() = products


    fun getProducts() {
        products.value = RemoteCallState.loading()
        disposable.add(productsRepository.getProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                 products.value = if( it.error == null ) {
                     saveProducts(it.products)
                     RemoteCallState.success(it)
                 } else {
                     RemoteCallState.failed(it.error)
                 }
            }, {
                products.value = RemoteCallState.failed(it.localizedMessage)
            }))
    }


    private fun saveProducts(products : List<Product>) {
        disposable.add(productsRepository.saveAllProducts(products).
                subscribeOn(Schedulers.io())
               .subscribe()
        )
    }


    fun getProductsFromDb() {
        var productListResponse = ProductListResponse(emptyList())
        disposable.add(productsRepository.getProductsFromDb()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                productListResponse.products = it
                products.value = RemoteCallState.success(productListResponse)
            }, {}))
    }
}