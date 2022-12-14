package com.stefanus_ayudha.modsample.pokemon.ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.stefanus_ayudha.core.common.util.request.Default
import com.stefanus_ayudha.core.common.util.request.Failed
import com.stefanus_ayudha.core.common.util.request.Loading
import com.stefanus_ayudha.core.common.util.request.Success
import com.stefanus_ayudha.core.network.GetPokemonListQuery
import com.stefanus_ayudha.core.ui.util.toDp
import com.stefanus_ayudha.modsample.pokemon.ui.screen.home.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    vm: HomeViewModel = viewModel(),
    modifier: Modifier = Modifier
) = Box(
    modifier = Modifier
        .fillMaxSize()
        .then(modifier)
) {

    val pokemonList = vm.pokemonListState.collectAsState().value
    when (pokemonList) {
        is Default -> {
            Iddle()
        }
        is Loading -> {
            LoadingPage()
        }
        is Failed -> {
            Error(pokemonList.e)
        }
        is Success -> {
            SuccessPage(pokemonList.value)
        }
    }
}

@Composable
fun Iddle() {

}

@Composable
fun BoxScope.LoadingPage() {
    CircularProgressIndicator(
        modifier = Modifier.align(
            Alignment.Center
        )
    )
}

@Composable
fun SuccessPage(
    data: GetPokemonListQuery.Data
) {
    LazyColumn(
        modifier = Modifier.padding(16.toDp)
    ) {
        data.pokemon_v2_pokemon.map { data ->
            item(
                key = data.id
            ) {
                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(text = data.name)
                }
            }
        }
    }
}

@Composable
fun Error(
    e: com.stefanus_ayudha.core.common.domain.model.Error
) {
    Text(text = e.message.toString())
}