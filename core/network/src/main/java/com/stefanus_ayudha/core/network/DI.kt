package com.stefanus_ayudha.core.network

import com.stefanus_ayudha.core.network.data.dataModule
import org.koin.core.module.Module

val coreNetworkModules = arrayOf<Module>(
    dataModule
)