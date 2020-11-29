package com.test.istestprojectapplication.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.*
import com.test.istestprojectapplication.core.RemoteCallState
import com.test.istestprojectapplication.core.SessionManager
import com.test.istestprojectapplication.data.remote.model.LoginResponse
import com.test.istestprojectapplication.data.repository.ISLoginRepository
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito

class LoginViewModelTest {
    @get:Rule
    var testRule: TestRule = InstantTaskExecutorRule()

    private val isLoginRepository : ISLoginRepository = mock()
    private val sessionManager : SessionManager = mock()

    private val loginObserver: Observer<RemoteCallState<String>> = mock()

    private  lateinit var SUT : LoginViewModel

    private val USERNAME = "user"
    private val PASSWORD = "password"
    private val TOKEN = "SOMETOKEN"

    @Before
    fun setUP() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        SUT = LoginViewModel(isLoginRepository, sessionManager)

        SUT.loginView.observeForever(loginObserver)

    }

    @After fun onEnd() {
        Mockito.reset(isLoginRepository)
        Mockito.reset(sessionManager)
    }

    @Test
    fun `on Login success saveToken should be called once`() {
        val loginResponse = LoginResponse("")
        whenever(isLoginRepository.login(any(), any())).thenReturn(Observable.just(loginResponse))

        SUT.login(USERNAME, PASSWORD)

        verify(sessionManager, times(1)).saveToken(any())
    }

    @Test
    fun `on Login success saveUserName should be called once`() {
        val loginResponse = LoginResponse("")
        whenever(isLoginRepository.login(any(), any())).thenReturn(Observable.just(loginResponse))

        SUT.login(USERNAME, PASSWORD)

        verify(sessionManager, times(1)).saveUserName(any())
    }

    @Test
    fun `on Login success saveToken should be called with token that is returned in login response`() {
        val loginResponse = LoginResponse(TOKEN)
        whenever(isLoginRepository.login(any(), any())).thenReturn(Observable.just(loginResponse))


        SUT.login(USERNAME, PASSWORD)

        verify(sessionManager).saveToken(TOKEN)
    }


    @Test
    fun `on Login success saveUserName should be called with username that was initially passed in as argument`() {
        val loginResponse = LoginResponse("")
        whenever(isLoginRepository.login(any(), any())).thenReturn(Observable.just(loginResponse))

        SUT.login(USERNAME, PASSWORD)

        verify(sessionManager).saveUserName(USERNAME)
    }


}