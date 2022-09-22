package com.stefanus_ayudha.modsample.modulev1.ui.screen.todolist.viewmodel

import com.stefanus_ayudha.core.common.util.viewmodel.BaseViewModel
import com.stefanus_ayudha.modsample.modulev1.data.model.Todo
import com.stefanus_ayudha.modsample.modulev1.data.payload.GetTodoListPayload

interface TodoViewModelUseCase {
    val todoListState: BaseViewModel.State<List<Todo>, GetTodoListPayload>
}