package com.test.istestprojectapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.istestprojectapplication.core.RemoteCallState
import com.test.istestprojectapplication.core.SessionManager
import com.test.istestprojectapplication.data.repository.ISLoginRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class LoginViewModel(private val loginRepository: ISLoginRepository,
                     private val sessionManager: SessionManager
) : BaseViewModel() {

    private val login = MutableLiveData<RemoteCallState<String>>()
    val loginView : LiveData<RemoteCallState<String>>
    get() = login


    fun login(userName : String, password : String) {
        login.value = RemoteCallState.loading()
        disposable.add(loginRepository.login(userName, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                login.value = if( it.error == null ) {
                    sessionManager.saveToken(it.token)
                    sessionManager.saveUserName(userName)
                    RemoteCallState.success("Success")
                } else  RemoteCallState.failed(it.error)
            }, {
               login.value = RemoteCallState.failed(it.message!!)
            })

        )
    }
}