package com.test.istestprojectapplication.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.istestprojectapplication.data.repository.ISLoginRepository
import com.test.istestprojectapplication.data.repository.ProductsRepository
import com.test.istestprojectapplication.viewmodel.LoginViewModel
import com.test.istestprojectapplication.viewmodel.ProductsViewModel

class LoginViewModelFactory(private val isLoginRepository: ISLoginRepository,
                            private val sessionManager: SessionManager) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(isLoginRepository, sessionManager) as T
    }
}

class ProductsViewModelFactory(private val productsRepository: ProductsRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductsViewModel(productsRepository) as T
    }
}
