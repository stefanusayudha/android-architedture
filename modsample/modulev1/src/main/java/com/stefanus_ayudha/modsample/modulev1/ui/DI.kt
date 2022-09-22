package com.stefanus_ayudha.modsample.modulev1.ui

import com.stefanus_ayudha.control.provider.sample.space.TodoSpace
import com.stefanus_ayudha.modsample.modulev1.ui.activity.todolist.TodoActivitySpace
import com.stefanus_ayudha.modsample.modulev1.ui.screen.todolist.viewmodel.TodoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {

    factory<TodoSpace> { TodoActivitySpace() }
    viewModel { TodoViewModel() }
}