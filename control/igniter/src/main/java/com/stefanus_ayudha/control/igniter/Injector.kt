package com.stefanus_ayudha.control.igniter

import com.stefanus_ayudha.core.common.coreMainModules
import com.stefanus_ayudha.core.network.coreNetworkModules
import com.stefanus_ayudha.core.ui.coreUIModules
import com.stefanus_ayudha.modsample.modulev1.modSampleModules

val allModules = arrayOf(
    *coreMainModules,
    *coreNetworkModules,
    *coreUIModules,
    *modSampleModules
)