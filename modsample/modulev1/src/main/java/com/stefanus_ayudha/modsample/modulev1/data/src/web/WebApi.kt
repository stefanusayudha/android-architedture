package com.stefanus_ayudha.modsample.modulev1.data.src.web

import com.stefanus_ayudha.core.common.util.retrofit.createRetrofitService
import com.stefanus_ayudha.core.network.data.Secured
import com.stefanus_ayudha.core.network.util.okhttp.defaultOkhttp
import com.stefanus_ayudha.modsample.modulev1.data.model.Todo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface TodoListApi {
    @GET("todos/")
    suspend fun getTodoList(
        @QueryMap queries: HashMap<String, String>
    ): List<Todo>

    @GET("todos/{id}")
    suspend fun getTodoById(
        @Path("id") id: String
    ): Todo
}

val todoListWebApi by lazy {
    createRetrofitService(
        TodoListApi::class.java,
        defaultOkhttp(),
        Secured.getBaseUrl()
    )
}