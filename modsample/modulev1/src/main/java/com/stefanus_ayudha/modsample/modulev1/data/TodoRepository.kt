package com.stefanus_ayudha.modsample.modulev1.data

import com.stefanus_ayudha.modsample.modulev1.data.model.Todo
import com.stefanus_ayudha.modsample.modulev1.data.payload.GetTodoByIdPayload
import com.stefanus_ayudha.modsample.modulev1.data.payload.GetTodoListPayload
import com.stefanus_ayudha.modsample.modulev1.data.src.web.todoListWebApi

suspend fun getTodoList(
    payload: GetTodoListPayload
): List<Todo> {
    return todoListWebApi.getTodoList(
        payload.getQueryMap()
    )
}

suspend fun getTodoById(
    payload: GetTodoByIdPayload
): Todo {
    return todoListWebApi.getTodoById(
        payload.id
    )
}