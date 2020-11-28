package com.test.istestprojectapplication.core

sealed class RemoteCallState<T> {
    class Loading<T> : RemoteCallState<T>()
    class Success<T>(val data: T) : RemoteCallState<T>()
    class Failed<T>(val message: String) : RemoteCallState<T>()

    companion object {
        fun <T> loading() = Loading<T>()
        fun <T> success(data: T) = Success(data)
        fun <T> failed(message: String) = Failed<T>(message)
    }
}