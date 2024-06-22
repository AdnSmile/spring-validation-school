package com.example.springvalidationtest.dto.response

data class BaseResponse<T>(

    val status: String? = null,

    val message: String? = null,

    val data: T? = null
)
