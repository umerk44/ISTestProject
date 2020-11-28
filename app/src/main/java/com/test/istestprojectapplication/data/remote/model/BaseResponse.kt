package com.test.istestprojectapplication.data.remote.model

import com.google.gson.annotations.SerializedName

 open class BaseResponse(@SerializedName("timestamp") val timeStamp : Long? = null,
                         @SerializedName("status") val status : Int? = null,
                         @SerializedName("error") val error : String? = null,
                         @SerializedName("message") val message : String? = null)