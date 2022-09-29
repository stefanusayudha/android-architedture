package com.stefanus_ayudha.core.common.util.viewmodel

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stefanus_ayudha.core.common.domain.model.Error
import com.stefanus_ayudha.core.common.domain.payload.Payload
import com.stefanus_ayudha.core.common.util.request.*
import com.stefanus_ayudha.core.common.util.retrofit.eitherResponseOf
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel() {
    abstract inner class State<T, P : Payload> {
        private val state = MutableStateFlow<RequestState<T>>(Default())
        private var job: Job? = null

        private val streamSuperVisor = SupervisorJob()
        private val handler: (onError: ((c: CoroutineContext, e: Throwable) -> Unit)?) -> CoroutineExceptionHandler =
            {
                CoroutineExceptionHandler { coroutineContext, throwable ->
                    it?.invoke(coroutineContext, throwable)
                        ?: run {
                            Log.e(
                                "${coroutineContext::class.simpleName}",
                                "launchJob: ${throwable.localizedMessage}"
                            )
                        }
                }
            }

        private val streamScope = CoroutineScope(
            streamSuperVisor
                    + Dispatchers.IO
                    + handler { c, e ->
                state.value = Failed(
                    Error(
                        message = e.message.toString(),
                        code = 0
                    )
                )
            })

        @Composable
        fun collectAsState() = state.collectAsState()
        fun request(payload: P) {
            state.value = Loading()
            job?.cancel()
            job = viewModelScope.launch(
                streamSuperVisor +
                        Dispatchers.IO +
                        handler { c, e ->
                            state.value = Failed(
                                Error(
                                    message = e.message.toString(),
                                    code = 0
                                )
                            )
                        }
            ) {
                state.value = eitherResponseOf { operator(payload) }.fold(
                    ifLeft = { Failed(it) },
                    ifRight = { Success(it) }
                )
            }
        }

        fun resetClear() {
            job?.cancel()
            state.value = Default()
        }

        abstract val operator: suspend (payload: P) -> T
    }

    fun <P : Payload, T> createState(
        block: suspend (payload: P) -> T
    ): BaseViewModel.State<T, P> {
        return object : State<T, P>() {
            override val operator: suspend (payload: P) -> T
                get() = { block.invoke(it) }
        }
    }

    abstract fun clear()
}