package com.stefanus_ayudha.core.network.util.okhttp

import com.stefanus_ayudha.core.network.util.interceptor.chuckerInterceptor
import okhttp3.OkHttpClient

fun defaultOkhttp() = OkHttpClient.Builder()
    .addInterceptor(chuckerInterceptor)
    .build()