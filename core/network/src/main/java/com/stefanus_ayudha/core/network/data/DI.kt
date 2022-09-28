package com.stefanus_ayudha.core.network.data

import com.stefanus_ayudha.core.network.util.interceptor.chuckerInterceptor
import com.stefanus_ayudha.core.network.util.okhttp.defaultOkhttp
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * in case you wanted to do casual object oriented
 */
val dataModule = module {
    single(named(BASE_URL)) { Secured.getBaseUrl() }

    factory<OkHttpClient> { defaultOkhttp() }
}