package com.stefanus_ayudha.modsample.modulev1.data.payload

import com.stefanus_ayudha.core.common.domain.payload.Payload

data class GetTodoByIdPayload(
    val id: String = ""
) : Payload {
    fun getQueryMap() = hashMapOf<String, String>()
        .apply {
            // No query payload
        }
}