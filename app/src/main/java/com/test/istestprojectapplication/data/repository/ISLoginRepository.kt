package com.test.istestprojectapplication.data.repository

import com.test.istestprojectapplication.data.remote.api.ISLoginService
import com.test.istestprojectapplication.data.remote.model.LoginRequest
import com.test.istestprojectapplication.data.remote.model.LoginResponse
import io.reactivex.Observable

class ISLoginRepository(private val service : ISLoginService) {

    fun login(username : String, password: String): Observable<LoginResponse> {
        return service.login(LoginRequest(username, password))
    }
}