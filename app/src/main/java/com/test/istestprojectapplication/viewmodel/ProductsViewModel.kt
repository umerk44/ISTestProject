package com.test.istestprojectapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.istestprojectapplication.core.RemoteCallState
import com.test.istestprojectapplication.data.remote.model.ProductListResponse
import com.test.istestprojectapplication.data.repository.ProductsRepository
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
                 products.value = if( it.error == null ) RemoteCallState.success(it) else RemoteCallState.failed(it.error)
            }, {
                products.value = RemoteCallState.failed(it.localizedMessage)
            }))
    }
}