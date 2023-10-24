package com.pankaj6apr.newsdaily.common.model

import com.google.gson.annotations.SerializedName

enum class ErrorCode(val category: String) {
    @SerializedName("ok")
    OK("ok"),
    @SerializedName("error")
    ERROR("error");
}