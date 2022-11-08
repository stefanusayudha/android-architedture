package com.stefanus_ayudha.modsample.pokemon.data.payload

import com.stefanus_ayudha.core.common.domain.payload.Payload

data class GetPokemonListPayload(
    val limit: Int = 10,
    val offset: Int = 0
) : Payload