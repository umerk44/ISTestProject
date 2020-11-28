package com.test.istestprojectapplication.data.remote.api

import com.test.istestprojectapplication.data.remote.model.LoginRequest
import com.test.istestprojectapplication.data.remote.model.LoginResponse
import io.reactivex.Observable
import retrofit2.http.*

interface ISLoginService {

    @POST("/app/authenticate")
    fun login(@Body loginRequest: LoginRequest) : Observable<LoginResponse>

}