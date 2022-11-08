package com.stefanus_ayudha.modsample.todolist.ui.screen.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.stefanus_ayudha.core.common.util.viewmodel.BaseViewModel
import com.stefanus_ayudha.core.network.GetPokemonListQuery
import com.stefanus_ayudha.core.network.data.Secured
import com.stefanus_ayudha.core.network.util.apolloClient
import com.stefanus_ayudha.modsample.todolist.data.getTodoList
import com.stefanus_ayudha.modsample.todolist.data.model.Todo
import com.stefanus_ayudha.modsample.todolist.data.payload.GetTodoListPayload
import kotlinx.coroutines.launch

class TodoViewModel : BaseViewModel(), TodoViewModelUseCase {

    override val todoListState = object : State<List<Todo>, GetTodoListPayload>() {
        override val operator: suspend (GetTodoListPayload) -> List<Todo> = { getTodoList(it) }
    }

    private fun getPokemon() {

        viewModelScope.launch {
            val apolloClient = apolloClient(Secured.getBasePokemonUrl())
            val response = apolloClient.query(
                GetPokemonListQuery(
                    limit = 10,
                    offset = 1
                )
            ).execute()

            Log.d("TAG", "getPokemon: ${response.data?.pokemon_v2_pokemon}")
        }
    }

    override fun clear() {
        todoListState.resetClear()
    }

    init {
        getPokemon()
    }
}