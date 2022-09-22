package com.stefanus_ayudha.modsample.modulev1.ui.screen.todolist.viewmodel

import com.stefanus_ayudha.core.common.util.viewmodel.BaseViewModel
import com.stefanus_ayudha.modsample.modulev1.data.getTodoList
import com.stefanus_ayudha.modsample.modulev1.data.model.Todo
import com.stefanus_ayudha.modsample.modulev1.data.payload.GetTodoListPayload

class TodoViewModel : BaseViewModel(), TodoViewModelUseCase {

    override val todoListState = object : State<List<Todo>, GetTodoListPayload>() {
        override val operator: suspend (GetTodoListPayload) -> List<Todo> = { getTodoList(it) }
    }

    override fun clear() {
        todoListState.resetClear()
    }
}